package com.tencent.viola.ui.view.list;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class DefaultRecycleItemAnimator$3$2
  implements Animator.AnimatorListener
{
  DefaultRecycleItemAnimator$3$2(DefaultRecycleItemAnimator.3 param3) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.this$0.val$convertView.getLayoutParams();
    if (paramAnimator != null)
    {
      paramAnimator.height = (-this.this$0.val$height);
      this.this$0.val$convertView.setLayoutParams(paramAnimator);
    }
    this.this$0.val$convertView.setAlpha(1.0F);
    if (this.this$0.val$listener != null) {
      this.this$0.val$listener.onAnimFinash();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.3.2
 * JD-Core Version:    0.7.0.1
 */