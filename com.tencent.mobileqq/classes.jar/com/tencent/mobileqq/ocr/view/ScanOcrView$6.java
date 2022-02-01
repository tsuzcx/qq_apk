package com.tencent.mobileqq.ocr.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanOcrView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanOcrView$6(ScanOcrView paramScanOcrView, ScanOcrView.ScanRectAniParam paramScanRectAniParam) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.h = i;
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.6
 * JD-Core Version:    0.7.0.1
 */