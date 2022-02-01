package com.tencent.mobileqq.flashshow.player.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class FSProgressLoadingView$CycleAnimationListener
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator != null) {
      try
      {
        paramAnimator.start();
        return;
      }
      catch (Exception paramAnimator)
      {
        paramAnimator.printStackTrace();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSProgressLoadingView.CycleAnimationListener
 * JD-Core Version:    0.7.0.1
 */