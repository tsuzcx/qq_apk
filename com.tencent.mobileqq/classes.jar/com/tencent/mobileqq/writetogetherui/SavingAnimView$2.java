package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class SavingAnimView$2
  implements Animator.AnimatorListener
{
  SavingAnimView$2(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a, 2);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.2
 * JD-Core Version:    0.7.0.1
 */