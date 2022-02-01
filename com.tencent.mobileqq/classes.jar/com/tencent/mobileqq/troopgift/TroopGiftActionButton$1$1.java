package com.tencent.mobileqq.troopgift;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

class TroopGiftActionButton$1$1
  implements Animation.AnimationListener
{
  TroopGiftActionButton$1$1(TroopGiftActionButton.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(100L);
    this.a.a.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton.1.1
 * JD-Core Version:    0.7.0.1
 */