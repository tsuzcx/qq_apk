package com.tencent.mobileqq.flashshow.widgets.comment;

import android.animation.Animator;
import com.tencent.mobileqq.flashshow.widgets.animation.D8SafeAnimatorListener;

class FSSlidBottomView$3
  extends D8SafeAnimatorListener
{
  FSSlidBottomView$3(FSSlidBottomView paramFSSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (FSSlidBottomView.a(this.a) != null) {
      FSSlidBottomView.a(this.a).b();
    }
    this.a.setVisibility(8);
    FSSlidBottomView.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FSSlidBottomView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView.3
 * JD-Core Version:    0.7.0.1
 */