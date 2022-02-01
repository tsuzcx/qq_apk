package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopAvatarWallPreviewActivity$14
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$14(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.mBottomBar == null) {
      return;
    }
    this.a.mBottomBar.post(new TroopAvatarWallPreviewActivity.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */