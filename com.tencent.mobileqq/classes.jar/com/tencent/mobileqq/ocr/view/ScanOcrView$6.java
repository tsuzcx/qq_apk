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
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.e = i;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.6
 * JD-Core Version:    0.7.0.1
 */