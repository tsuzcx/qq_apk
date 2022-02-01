package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class UnderlineIndicator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  UnderlineIndicator$1(UnderlineIndicator paramUnderlineIndicator, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.z = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.b.z == this.a) {
      this.b.t = false;
    }
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnderlineIndicator.1
 * JD-Core Version:    0.7.0.1
 */