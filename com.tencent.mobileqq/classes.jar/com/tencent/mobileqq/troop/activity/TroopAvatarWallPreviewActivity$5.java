package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopAvatarWallPreviewActivity$5
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$5(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.b == null) {
      return;
    }
    this.a.b.post(new TroopAvatarWallPreviewActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */