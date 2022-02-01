package com.tencent.mobileqq.olympic.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ScanIconAnimateView$8
  implements Animator.AnimatorListener
{
  ScanIconAnimateView$8(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScanIconAnimateView.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView.8
 * JD-Core Version:    0.7.0.1
 */