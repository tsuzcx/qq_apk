package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class TroopAvatarWallPreviewActivity$7
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$7(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.mBottomBar == null) {
      return;
    }
    this.a.mBottomBar.post(new TroopAvatarWallPreviewActivity.7.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */