package com.tencent.superplayer.seamless;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;

class SPSeamlessHelper$4
  implements Animator.AnimatorListener
{
  SPSeamlessHelper$4(SPSeamlessHelper paramSPSeamlessHelper, Animator.AnimatorListener paramAnimatorListener, View paramView, ViewGroup paramViewGroup, SPSeamlessParam paramSPSeamlessParam) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.val$animatorListener != null) {
      this.val$animatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SPSeamlessHelper.access$300(this.this$0, paramAnimator, this.val$videoView, this.val$parent, this.val$seamlessParam, this.val$animatorListener);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.val$animatorListener != null) {
      this.val$animatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.val$animatorListener != null) {
      this.val$animatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper.4
 * JD-Core Version:    0.7.0.1
 */