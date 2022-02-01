package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AutoScrollImageView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AutoScrollImageView$1(AutoScrollImageView paramAutoScrollImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AutoScrollImageView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AutoScrollImageView.1
 * JD-Core Version:    0.7.0.1
 */