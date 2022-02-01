package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ColorBandVideoEntranceButton$3
  implements ValueAnimator.AnimatorUpdateListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  ColorBandVideoEntranceButton$3(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getCurrentPlayTime() >= 100L) && (!this.jdField_a_of_type_Boolean))
    {
      ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton).start();
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton.3
 * JD-Core Version:    0.7.0.1
 */