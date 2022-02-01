package com.tencent.mobileqq.portal;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class FormalView$3
  implements Animator.AnimatorListener
{
  FormalView$3(FormalView paramFormalView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.f();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.f();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FormalView.g(this.a).setVisibility(0);
    if (this.a.b == 1)
    {
      FormalView.i(this.a).setVisibility(0);
      return;
    }
    FormalView.i(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView.3
 * JD-Core Version:    0.7.0.1
 */