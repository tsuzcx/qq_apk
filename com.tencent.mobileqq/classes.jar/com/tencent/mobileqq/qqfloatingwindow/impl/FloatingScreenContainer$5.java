package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;

class FloatingScreenContainer$5
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingScreenContainer$5(FloatingScreenContainer paramFloatingScreenContainer, WindowManager.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.alpha = (paramValueAnimator.floatValue() * 1.0F + 0.0F);
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer.a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.5
 * JD-Core Version:    0.7.0.1
 */