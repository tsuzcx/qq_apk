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
    if (PopupWindowWithMask.a(this.a) != null)
    {
      PopupWindowWithMask.a(this.a).removeViewImmediate(PopupWindowWithMask.a(this.a));
      PopupWindowWithMask.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PopupWindowWithMask.4
 * JD-Core Version:    0.7.0.1
 */