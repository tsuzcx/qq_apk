package com.tencent.mobileqq.widget;

import android.animation.Animator;

class SlideBottomPanel$3
  extends D8SafeAnimatorListener
{
  SlideBottomPanel$3(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = false;
    paramAnimator.c = false;
    paramAnimator.w = false;
    if (paramAnimator.z != null) {
      this.a.z.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = false;
    paramAnimator.c = false;
    paramAnimator.w = false;
    if (paramAnimator.z != null) {
      this.a.z.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */