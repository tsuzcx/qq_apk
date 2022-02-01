package com.tencent.mobileqq.extendfriend.wiget;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ExtendFriendSearchBarView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ExtendFriendSearchBarView$1(ExtendFriendSearchBarView paramExtendFriendSearchBarView, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    int i = (int)((1.0F - ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F) * -ExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView));
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.1
 * JD-Core Version:    0.7.0.1
 */