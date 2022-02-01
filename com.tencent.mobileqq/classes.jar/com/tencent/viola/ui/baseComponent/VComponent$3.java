package com.tencent.viola.ui.baseComponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.viola.core.ViolaInstance;

class VComponent$3
  extends AnimatorListenerAdapter
{
  VComponent$3(VComponent paramVComponent, ViolaInstance paramViolaInstance) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$instance.decreaseTransformCount();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$instance.decreaseTransformCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent.3
 * JD-Core Version:    0.7.0.1
 */