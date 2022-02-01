package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class PlayOperationViewModelImpl$29
  extends AnimatorListenerAdapter
{
  PlayOperationViewModelImpl$29(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.mHeadBinding.findViewById(2131433526).setVisibility(8);
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.mHeadBinding.findViewById(2131433526).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.29
 * JD-Core Version:    0.7.0.1
 */