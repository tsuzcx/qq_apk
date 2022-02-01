package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.widget.Gallery;

class TroopAvatarWallPreviewActivity$27
  implements Animation.AnimationListener
{
  TroopAvatarWallPreviewActivity$27(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.mAnimationView.setVisibility(4);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.mGallery.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.27
 * JD-Core Version:    0.7.0.1
 */