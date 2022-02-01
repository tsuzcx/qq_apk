package com.tencent.richframework.text.rich;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RFWTailExpandText$2
  implements ValueAnimator.AnimatorUpdateListener
{
  RFWTailExpandText$2(RFWTailExpandText paramRFWTailExpandText) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWTailExpandText.2
 * JD-Core Version:    0.7.0.1
 */