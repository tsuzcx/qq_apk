package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;

class FloatingScreenContainer$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingScreenContainer$1(FloatingScreenContainer paramFloatingScreenContainer, int paramInt1, int paramInt2, WindowManager.LayoutParams paramLayoutParams, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (this.jdField_a_of_type_Int >= -this.b) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = ((int)(this.c + paramValueAnimator.floatValue() * (this.jdField_a_of_type_Int - this.c)));
    }
    if (this.d >= this.e) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = ((int)(this.f + paramValueAnimator.floatValue() * (this.d - this.f)));
    }
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer.a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    FloatingScreenContainer.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer).setFloatingCenterX(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x);
    FloatingScreenContainer.a(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer).setFloatingCenterY(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.1
 * JD-Core Version:    0.7.0.1
 */