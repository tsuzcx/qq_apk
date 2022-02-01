package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

class SavingAnimView$4
  implements Animator.AnimatorListener
{
  SavingAnimView$4(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a).start();
    SavingAnimView.b(this.a, 1);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SavingAnimView.c(this.a, SavingAnimView.a(this.a));
    SavingAnimView.d(this.a, SavingAnimView.d(this.a));
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.4
 * JD-Core Version:    0.7.0.1
 */