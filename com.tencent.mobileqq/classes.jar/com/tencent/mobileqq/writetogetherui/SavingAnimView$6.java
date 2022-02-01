package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class SavingAnimView$6
  implements Animator.AnimatorListener
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
    SavingAnimView.c(this.a, SavingAnimView.a(this.a));
    SavingAnimView.d(this.a, SavingAnimView.d(this.a));
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.6
 * JD-Core Version:    0.7.0.1
 */