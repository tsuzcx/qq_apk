package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class PlayOperationViewModelImpl$28
  extends AnimatorListenerAdapter
{
  PlayOperationViewModelImpl$28(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.mHeadBinding.findViewById(2131433529).setBackgroundDrawable(null);
    this.a.mHeadBinding.findViewById(2131433528).setBackgroundColor(-637534209);
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.isPlayingAnim = true;
    paramAnimator.mHeadBinding.findViewById(2131433529).setBackgroundResource(2130847055);
    this.a.mHeadBinding.findViewById(2131433528).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.28
 * JD-Core Version:    0.7.0.1
 */