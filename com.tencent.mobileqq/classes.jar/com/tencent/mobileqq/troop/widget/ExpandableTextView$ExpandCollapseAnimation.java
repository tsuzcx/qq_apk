package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class ExpandableTextView$ExpandCollapseAnimation
  extends Animation
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)((this.b - this.jdField_a_of_type_Int) * paramFloat + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a.setMaxHeight(i - ExpandableTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView));
    if (Float.compare(ExpandableTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView), 1.0F) != 0) {
      ExpandableTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a, ExpandableTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView) + (1.0F - ExpandableTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView)) * paramFloat);
    }
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = i;
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView.ExpandCollapseAnimation
 * JD-Core Version:    0.7.0.1
 */