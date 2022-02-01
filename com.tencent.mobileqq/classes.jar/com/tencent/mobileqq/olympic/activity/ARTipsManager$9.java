package com.tencent.mobileqq.olympic.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

class ARTipsManager$9
  extends AnimatorListenerAdapter
{
  ARTipsManager$9(ARTipsManager paramARTipsManager, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ARTipsManager.e(this.b).removeView(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.9
 * JD-Core Version:    0.7.0.1
 */