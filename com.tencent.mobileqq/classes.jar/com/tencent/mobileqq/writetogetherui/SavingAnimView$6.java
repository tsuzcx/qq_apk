package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class SavingAnimView$6
  extends D8SafeAnimatorListener
{
  SavingAnimView$6(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a, 0);
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    SavingAnimView.c(paramAnimator, SavingAnimView.a(paramAnimator));
    paramAnimator = this.a;
    SavingAnimView.d(paramAnimator, SavingAnimView.d(paramAnimator));
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.6
 * JD-Core Version:    0.7.0.1
 */