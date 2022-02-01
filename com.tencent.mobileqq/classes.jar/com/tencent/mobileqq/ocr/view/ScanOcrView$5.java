package com.tencent.mobileqq.ocr.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

class ScanOcrView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanOcrView$5(ScanOcrView paramScanOcrView, ScanOcrView.ScanRectAniParam paramScanRectAniParam) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int n = (int)(this.a.c * f);
    int k = (int)(this.a.d * f);
    int i1 = this.a.c;
    int m = this.a.d;
    int j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    int i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.a.b.left;
    n = (n - i1) / 2;
    i1 = this.a.b.top;
    k = (k - m) / 2;
    m = this.a.b.right;
    int i2 = this.a.b.bottom;
    paramValueAnimator = this.a;
    paramValueAnimator.h = j;
    paramValueAnimator.g.set(i - n, i1 - k, m + n, i2 + k);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.5
 * JD-Core Version:    0.7.0.1
 */