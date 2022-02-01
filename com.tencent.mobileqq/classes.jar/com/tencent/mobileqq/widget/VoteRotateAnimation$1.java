package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class VoteRotateAnimation$1
  implements Animation.AnimationListener
{
  VoteRotateAnimation$1(View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RotatePageInAnimation(this.a);
    paramAnimation.setDuration(VoteRotateAnimation.a());
    paramAnimation.setFillAfter(true);
    this.a.startAnimation(paramAnimation);
    this.a.setVisibility(0);
    this.b.clearAnimation();
    this.b.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.clearAnimation();
    this.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteRotateAnimation.1
 * JD-Core Version:    0.7.0.1
 */