package com.tencent.mobileqq.ocr.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanOcrView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanOcrView$3(ScanOcrView paramScanOcrView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.e = i;
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.3
 * JD-Core Version:    0.7.0.1
 */