package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class PlayOperationViewModelImpl$30
  extends AnimatorListenerAdapter
{
  PlayOperationViewModelImpl$30(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.isPlayingAnim = false;
    paramAnimator.mHeadBinding.findViewById(2131367078).setVisibility(8);
    this.a.mHeadBinding.findViewById(2131367057).setTranslationY(0.0F);
    this.a.mHeadBinding.findViewById(2131367077).setTranslationY(0.0F);
    this.a.mHeadBinding.findViewById(2131367083).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.isPlayingAnim = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.isPlayingAnim = true;
    int i = paramAnimator.mFollowBackColor;
    this.a.mHeadBinding.findViewById(2131367076).setBackgroundResource(2130845591);
    this.a.mHeadBinding.findViewById(2131367076).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.mHeadBinding.findViewById(2131367075).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.30
 * JD-Core Version:    0.7.0.1
 */