package com.tencent.mobileqq.relationx.icebreaking;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AIOIceBreakShow$3
  extends D8SafeAnimatorListener
{
  AIOIceBreakShow$3(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, false);
    AIOIceBreakShow.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, false);
    AIOIceBreakShow.a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.3
 * JD-Core Version:    0.7.0.1
 */