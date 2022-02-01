package com.tencent.mobileqq.minigame.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class BlockAdView$2
  extends AnimatorListenerAdapter
{
  BlockAdView$2(BlockAdView paramBlockAdView, Handler paramHandler, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!BlockAdView.access$100(this.this$0))
    {
      BlockAdView.access$608(this.this$0);
      this.val$uiHandler.post(this.val$aniPlayMulti);
      super.onAnimationEnd(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.2
 * JD-Core Version:    0.7.0.1
 */