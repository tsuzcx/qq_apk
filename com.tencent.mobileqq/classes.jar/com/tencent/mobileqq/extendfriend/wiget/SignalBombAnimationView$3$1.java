package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;

class SignalBombAnimationView$3$1
  implements Animator.AnimatorListener
{
  SignalBombAnimationView$3$1(SignalBombAnimationView.3 param3) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.a.a), "alpha", new float[] { 1.0F, 0.0F });
    paramAnimator.setDuration(280L);
    paramAnimator.addListener(new SignalBombAnimationView.3.1.1(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView.3.1
 * JD-Core Version:    0.7.0.1
 */