package com.tencent.mobileqq.flashshow.widgets.common;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FSExpandableTextView$1$1
  implements Animation.AnimationListener
{
  FSExpandableTextView$1$1(FSExpandableTextView.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.l = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.l = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSExpandableTextView.1.1
 * JD-Core Version:    0.7.0.1
 */