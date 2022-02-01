package com.tencent.mobileqq.olympic.view;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ScanIconAnimateView$8
  extends D8SafeAnimatorListener
{
  ScanIconAnimateView$8(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScanIconAnimateView.a(this.a, true);
    if (this.a.t != null) {
      this.a.t.b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.t != null) {
      this.a.t.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView.8
 * JD-Core Version:    0.7.0.1
 */