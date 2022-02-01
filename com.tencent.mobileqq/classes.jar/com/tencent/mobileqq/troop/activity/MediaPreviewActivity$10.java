package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MediaPreviewActivity$10
  implements Animation.AnimationListener
{
  MediaPreviewActivity$10(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b = false;
    paramAnimation.setAnimationListener(null);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.10
 * JD-Core Version:    0.7.0.1
 */