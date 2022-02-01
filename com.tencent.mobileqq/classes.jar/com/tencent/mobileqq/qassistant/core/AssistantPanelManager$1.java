package com.tencent.mobileqq.qassistant.core;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AssistantPanelManager$1
  extends D8SafeAnimatorListener
{
  AssistantPanelManager$1(AssistantPanelManager paramAssistantPanelManager, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AssistantPanelManager.a(this.b, this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AssistantPanelManager.a(this.b, this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.AssistantPanelManager.1
 * JD-Core Version:    0.7.0.1
 */