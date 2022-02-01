package com.tencent.mobileqq.qqexpand.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

class HeadsPanelAnimationView$2
  implements Animation.AnimationListener
{
  HeadsPanelAnimationView$2(HeadsPanelAnimationView paramHeadsPanelAnimationView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(500);
    paramAnimation.setFillAfter(true);
    paramAnimation.setAnimationListener(new HeadsPanelAnimationView.2.1(this));
    this.a.i.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView.2
 * JD-Core Version:    0.7.0.1
 */