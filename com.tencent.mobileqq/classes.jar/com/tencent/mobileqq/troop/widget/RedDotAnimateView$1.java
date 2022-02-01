package com.tencent.mobileqq.troop.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RedDotAnimateView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RedDotAnimateView$1(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.b = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a.a / 2.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotAnimateView.1
 * JD-Core Version:    0.7.0.1
 */