package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VideofeedsUserGuideController$3
  implements Animation.AnimationListener
{
  VideofeedsUserGuideController$3(VideofeedsUserGuideController paramVideofeedsUserGuideController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)VideofeedsUserGuideController.c(this.a).findViewById(2131449242);
    ImageView localImageView = (ImageView)VideofeedsUserGuideController.c(this.a).findViewById(2131449243);
    VideofeedsUserGuideController.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideofeedsUserGuideController.3
 * JD-Core Version:    0.7.0.1
 */