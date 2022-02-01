package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class AnimatorHandler$2
  implements Animator.AnimatorListener
{
  AnimatorHandler$2(AnimatorHandler paramAnimatorHandler, View paramView, long paramLong, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
    AnimatorHandler.playing = false;
    if (this.val$remindTime != 0L) {
      ProfileDiamondWallComponent.saveShowPopTime(this.val$remindTime, this.val$type);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
    AnimatorHandler.playing = false;
    if (this.val$remindTime != 0L) {
      ProfileDiamondWallComponent.saveShowPopTime(this.val$remindTime, this.val$type);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AnimatorHandler.playing = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.2
 * JD-Core Version:    0.7.0.1
 */