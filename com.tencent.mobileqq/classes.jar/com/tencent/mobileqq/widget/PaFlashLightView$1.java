package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PaFlashLightView$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.h = false;
    if (paramAnimation.g == 0) {
      this.a.i.sendEmptyMessage(0);
    }
    if (this.a.g == 2) {
      this.a.i.sendEmptyMessage(2);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView.1
 * JD-Core Version:    0.7.0.1
 */