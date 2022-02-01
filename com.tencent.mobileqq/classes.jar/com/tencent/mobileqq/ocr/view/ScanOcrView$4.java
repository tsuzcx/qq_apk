package com.tencent.mobileqq.ocr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ScanOcrView$4
  extends AnimatorListenerAdapter
{
  ScanOcrView$4(ScanOcrView paramScanOcrView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.b) {
      ScanOcrView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView, this.jdField_a_of_type_Int + 1);
    }
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.4
 * JD-Core Version:    0.7.0.1
 */