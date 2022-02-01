package com.tencent.mobileqq.qassistant.view;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class VoicePanelSlideContainer$2
  extends D8SafeAnimatorListener
{
  VoicePanelSlideContainer$2(VoicePanelSlideContainer paramVoicePanelSlideContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VoicePanelSlideContainer.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VoicePanelSlideContainer.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer.2
 * JD-Core Version:    0.7.0.1
 */