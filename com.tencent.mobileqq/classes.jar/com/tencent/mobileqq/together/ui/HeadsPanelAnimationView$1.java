package com.tencent.mobileqq.together.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

class HeadsPanelAnimationView$1
  implements Animation.AnimationListener
{
  HeadsPanelAnimationView$1(HeadsPanelAnimationView paramHeadsPanelAnimationView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(500);
    paramAnimation.setFillAfter(true);
    paramAnimation.setAnimationListener(new HeadsPanelAnimationView.1.1(this));
    this.a.d.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.HeadsPanelAnimationView.1
 * JD-Core Version:    0.7.0.1
 */