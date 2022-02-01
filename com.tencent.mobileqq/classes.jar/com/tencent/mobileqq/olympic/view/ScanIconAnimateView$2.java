package com.tencent.mobileqq.olympic.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanIconAnimateView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanIconAnimateView$2(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView.2
 * JD-Core Version:    0.7.0.1
 */