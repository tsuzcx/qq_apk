package com.tencent.mobileqq.olympic.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ScanIconAnimateView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanIconAnimateView$4(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * -1.0F * AIOUtils.b(1.5F, this.a.getResources()));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView.4
 * JD-Core Version:    0.7.0.1
 */