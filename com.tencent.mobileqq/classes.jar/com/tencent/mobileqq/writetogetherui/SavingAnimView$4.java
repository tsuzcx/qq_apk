package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class SavingAnimView$4
  extends D8SafeAnimatorListener
{
  SavingAnimView$4(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.f(this.a).start();
    SavingAnimView.b(this.a, 1);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    SavingAnimView.c(paramAnimator, SavingAnimView.a(paramAnimator));
    paramAnimator = this.a;
    SavingAnimView.d(paramAnimator, SavingAnimView.e(paramAnimator));
    if (SavingAnimView.b(this.a) != null) {
      SavingAnimView.b(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.4
 * JD-Core Version:    0.7.0.1
 */