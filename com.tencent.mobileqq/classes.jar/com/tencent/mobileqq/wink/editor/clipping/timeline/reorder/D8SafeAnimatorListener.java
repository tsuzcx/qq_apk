package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

public abstract class D8SafeAnimatorListener
  implements Animator.AnimatorListener
{
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.D8SafeAnimatorListener
 * JD-Core Version:    0.7.0.1
 */