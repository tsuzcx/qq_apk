package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ComboCountDownAnimation$2
  implements Animator.AnimatorListener
{
  ComboCountDownAnimation$2(ComboCountDownAnimation paramComboCountDownAnimation) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((!ComboCountDownAnimation.a(this.a)) && (ComboCountDownAnimation.b(this.a) != null)) {
      ComboCountDownAnimation.b(this.a).b();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboCountDownAnimation.2
 * JD-Core Version:    0.7.0.1
 */