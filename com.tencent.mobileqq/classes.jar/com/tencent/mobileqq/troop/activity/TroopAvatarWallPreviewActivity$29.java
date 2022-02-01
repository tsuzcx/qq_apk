package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopAvatarWallPreviewActivity$29
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$29(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.animated = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.29
 * JD-Core Version:    0.7.0.1
 */