package org.cuiyang.assistant.control;

import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * box控件，有一个标题
 *
 * @author cuiyang
 */
public class Box extends AnchorPane {

    private Label titleLabel;
    private StringProperty title = new StringPropertyBase("") {
        @Override public void set(String value) {
            super.set((value != null) ? value : "");
        }

        @Override
        protected void invalidated() {
        }

        @Override
        public Object getBean() {
            return Box.this;
        }

        @Override
        public String getName() {
            return "title";
        }
    };

    public Box() {
        init();
    }

    public Box(Node... children) {
        super(children);
        init();
    }

    private void init() {
        titleLabel = new Label("标题");
        titleLabel.setStyle("-fx-background-color: -fx-background");
        AnchorPane.setTopAnchor(titleLabel, -10d);
        AnchorPane.setLeftAnchor(titleLabel, 10d);
        super.getChildren().add(titleLabel);
        this.setStyle("-fx-border-style: segments(0.166667em, 0.166667em);\n" +
                "    -fx-border-color:  gray;\n" +
                "    -fx-border-width: 0.083333em;");
    }

    public final void setTitle(String value) {
        this.title.set(value);
        this.titleLabel.setText(value);
    }

    public final String getTitle() {
        return title.get();
    }
}
