package com.tencent.mobileqq.ocr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ScanOcrView$4
  extends AnimatorListenerAdapter
{
  ScanOcrView$4(ScanOcrView paramScanOcrView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.b.x) {
      ScanOcrView.a(this.b, this.a + 1);
    }
    if (this.a == 2) {
      this.b.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.4
 * JD-Core Version:    0.7.0.1
 */