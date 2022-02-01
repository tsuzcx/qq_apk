package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class DynamicGridView$4
  extends AnimatorListenerAdapter
{
  DynamicGridView$4(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, false);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, true);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */