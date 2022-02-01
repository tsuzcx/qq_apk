package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GradientAnimTextView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GradientAnimTextView$1(GradientAnimTextView paramGradientAnimTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GradientAnimTextView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.GradientAnimTextView.1
 * JD-Core Version:    0.7.0.1
 */