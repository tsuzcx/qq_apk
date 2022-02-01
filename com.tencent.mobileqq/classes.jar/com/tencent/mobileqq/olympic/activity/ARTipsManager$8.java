package com.tencent.mobileqq.olympic.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ARTipsManager$8
  implements ValueAnimator.AnimatorUpdateListener
{
  ARTipsManager$8(ARTipsManager paramARTipsManager, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(f * AIOUtils.a(25.0F, ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.8
 * JD-Core Version:    0.7.0.1
 */