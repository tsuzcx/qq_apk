package com.tencent.superplayer.seamless;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class SPSeamlessHelper$5
  implements ViewTreeObserver.OnPreDrawListener
{
  SPSeamlessHelper$5(SPSeamlessHelper paramSPSeamlessHelper, ViewGroup paramViewGroup, View paramView, SPSeamlessParam paramSPSeamlessParam, Animator.AnimatorListener paramAnimatorListener, Animator paramAnimator) {}
  
  public boolean onPreDraw()
  {
    this.val$parent.getViewTreeObserver().removeOnPreDrawListener(this);
    this.val$videoView.setX(0.0F);
    this.val$videoView.setY(0.0F);
    this.this$0.attachVideoView(this.val$parent, this.val$videoView, this.val$seamlessParam.layoutParams, this.val$seamlessParam.viewIndex);
    Animator.AnimatorListener localAnimatorListener = this.val$animatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(this.val$animation);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper.5
 * JD-Core Version:    0.7.0.1
 */