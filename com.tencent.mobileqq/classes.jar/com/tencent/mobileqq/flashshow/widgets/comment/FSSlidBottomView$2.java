package com.tencent.mobileqq.flashshow.widgets.comment;

import android.animation.Animator;
import com.tencent.mobileqq.flashshow.widgets.animation.D8SafeAnimatorListener;

class FSSlidBottomView$2
  extends D8SafeAnimatorListener
{
  FSSlidBottomView$2(FSSlidBottomView paramFSSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (FSSlidBottomView.a(this.a) != null) {
      FSSlidBottomView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView.2
 * JD-Core Version:    0.7.0.1
 */