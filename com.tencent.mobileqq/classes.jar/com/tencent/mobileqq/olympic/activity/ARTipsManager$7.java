package com.tencent.mobileqq.olympic.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class ARTipsManager$7
  extends AnimatorListenerAdapter
{
  ARTipsManager$7(ARTipsManager paramARTipsManager) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ARTipsManager.a(this.a) != null) {
      ARTipsManager.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.7
 * JD-Core Version:    0.7.0.1
 */