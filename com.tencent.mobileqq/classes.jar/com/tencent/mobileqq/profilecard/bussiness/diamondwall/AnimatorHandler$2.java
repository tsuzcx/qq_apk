package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AnimatorHandler$2
  extends D8SafeAnimatorListener
{
  AnimatorHandler$2(AnimatorHandler paramAnimatorHandler, View paramView, long paramLong, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
    AnimatorHandler.playing = false;
    long l = this.val$remindTime;
    if (l != 0L) {
      ProfileDiamondWallComponent.saveShowPopTime(l, this.val$type);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
    AnimatorHandler.playing = false;
    long l = this.val$remindTime;
    if (l != 0L) {
      ProfileDiamondWallComponent.saveShowPopTime(l, this.val$type);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AnimatorHandler.playing = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.2
 * JD-Core Version:    0.7.0.1
 */