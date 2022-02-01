package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ReadInJoyDynamicGridView$4
  extends AnimatorListenerAdapter
{
  ReadInJoyDynamicGridView$4(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView, false);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView, true);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */