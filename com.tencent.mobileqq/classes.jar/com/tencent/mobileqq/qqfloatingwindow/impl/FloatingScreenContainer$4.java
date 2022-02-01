package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;

class FloatingScreenContainer$4
  implements Animator.AnimatorListener
{
  FloatingScreenContainer$4(FloatingScreenContainer paramFloatingScreenContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a).removeAllListeners();
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).b();
    }
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).a();
    }
    FloatingScreenContainer.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.4
 * JD-Core Version:    0.7.0.1
 */