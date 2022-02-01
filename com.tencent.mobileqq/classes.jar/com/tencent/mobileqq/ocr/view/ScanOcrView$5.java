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
    int n = (int)(this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.a * f);
    int k = (int)(this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_Int * f);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.a;
    int m = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_Int;
    int j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    int i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_AndroidGraphicsRect.left;
    n = (n - i1) / 2;
    i1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_AndroidGraphicsRect.top;
    k = (k - m) / 2;
    m = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_AndroidGraphicsRect.right;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_b_of_type_AndroidGraphicsRect.bottom;
    paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
    paramValueAnimator.e = j;
    paramValueAnimator.c.set(i - n, i1 - k, m + n, i2 + k);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.5
 * JD-Core Version:    0.7.0.1
 */