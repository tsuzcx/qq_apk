package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PaFlashLightView$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.h = false;
    paramAnimation.i.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.2
 * JD-Core Version:    0.7.0.1
 */