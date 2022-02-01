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
    int n = (int)(this.a.a.a * f);
    int k = (int)(this.a.a.jdField_b_of_type_Int * f);
    int i1 = this.a.a.a;
    int m = this.a.a.jdField_b_of_type_Int;
    int j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    int i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.a.a.jdField_b_of_type_AndroidGraphicsRect.left;
    n = (n - i1) / 2;
    i1 = this.a.a.jdField_b_of_type_AndroidGraphicsRect.top;
    k = (k - m) / 2;
    m = this.a.a.jdField_b_of_type_AndroidGraphicsRect.right;
    int i2 = this.a.a.jdField_b_of_type_AndroidGraphicsRect.bottom;
    this.a.a.e = j;
    this.a.a.c.set(i - n, i1 - k, m + n, i2 + k);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.2
 * JD-Core Version:    0.7.0.1
 */