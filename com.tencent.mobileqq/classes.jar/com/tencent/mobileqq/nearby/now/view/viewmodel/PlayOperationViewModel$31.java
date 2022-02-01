package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class PlayOperationViewModel$31
  extends AnimatorListenerAdapter
{
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.findViewById(2131367290).setVisibility(8);
    this.a.c = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b.findViewById(2131367290).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.31
 * JD-Core Version:    0.7.0.1
 */