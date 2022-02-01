package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.view.WindowManager;

class PopupWindowWithMask$4
  extends D8SafeAnimatorListener
{
  PopupWindowWithMask$4(PopupWindowWithMask paramPopupWindowWithMask) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PopupWindowWithMask.b(this.a) != null)
    {
      PopupWindowWithMask.c(this.a).removeViewImmediate(PopupWindowWithMask.b(this.a));
      PopupWindowWithMask.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PopupWindowWithMask.4
 * JD-Core Version:    0.7.0.1
 */