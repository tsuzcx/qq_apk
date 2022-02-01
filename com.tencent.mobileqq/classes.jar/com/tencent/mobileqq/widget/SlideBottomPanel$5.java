package com.tencent.mobileqq.widget;

import android.animation.Animator;

class SlideBottomPanel$5
  extends D8SafeAnimatorListener
{
  SlideBottomPanel$5(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = false;
    if (paramAnimator.z != null) {
      this.a.z.displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = false;
    if (paramAnimator.z != null) {
      this.a.z.displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.5
 * JD-Core Version:    0.7.0.1
 */