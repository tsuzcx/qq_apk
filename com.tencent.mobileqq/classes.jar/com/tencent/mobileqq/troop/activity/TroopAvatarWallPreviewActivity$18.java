package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopAvatarWallPreviewActivity$18
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$18(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.m = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.18
 * JD-Core Version:    0.7.0.1
 */