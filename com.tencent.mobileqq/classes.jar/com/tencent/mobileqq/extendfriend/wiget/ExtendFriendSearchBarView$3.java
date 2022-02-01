package com.tencent.mobileqq.extendfriend.wiget;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ExtendFriendSearchBarView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ExtendFriendSearchBarView$3(ExtendFriendSearchBarView paramExtendFriendSearchBarView, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-ExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView) * f);
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.3
 * JD-Core Version:    0.7.0.1
 */