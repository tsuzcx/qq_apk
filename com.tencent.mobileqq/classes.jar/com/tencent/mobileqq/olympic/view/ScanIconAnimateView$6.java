package com.tencent.mobileqq.olympic.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanIconAnimateView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanIconAnimateView$6(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView.6
 * JD-Core Version:    0.7.0.1
 */