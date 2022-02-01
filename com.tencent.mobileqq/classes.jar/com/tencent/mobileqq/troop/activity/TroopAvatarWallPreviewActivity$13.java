package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class TroopAvatarWallPreviewActivity$13
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$13(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.mBottomBar == null) {
      return;
    }
    this.a.mBottomBar.post(new TroopAvatarWallPreviewActivity.13.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.mPhotoDesc == null) {
      return;
    }
    this.a.mPhotoDesc.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */