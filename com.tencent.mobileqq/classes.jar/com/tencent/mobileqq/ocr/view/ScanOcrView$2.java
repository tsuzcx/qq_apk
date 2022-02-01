package com.tencent.mobileqq.ocr.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

class ScanOcrView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanOcrView$2(ScanOcrView paramScanOcrView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int n = (int)(this.a.z.c * f);
    int k = (int)(this.a.z.d * f);
    int i1 = this.a.z.c;
    int m = this.a.z.d;
    int j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    int i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.a.z.b.left;
    n = (n - i1) / 2;
    i1 = this.a.z.b.top;
    k = (k - m) / 2;
    m = this.a.z.b.right;
    int i2 = this.a.z.b.bottom;
    this.a.z.h = j;
    this.a.z.g.set(i - n, i1 - k, m + n, i2 + k);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.2
 * JD-Core Version:    0.7.0.1
 */