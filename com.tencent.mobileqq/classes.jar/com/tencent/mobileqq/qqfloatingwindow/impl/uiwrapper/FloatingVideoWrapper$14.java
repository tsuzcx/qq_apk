package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FloatingVideoWrapper$14
  extends D8SafeAnimatorListener
{
  FloatingVideoWrapper$14(FloatingVideoWrapper paramFloatingVideoWrapper, int paramInt, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.b;
    if (paramAnimator != null)
    {
      int i = this.a;
      if (i == 0) {
        paramAnimator.setAlpha(1.0F);
      } else if (i == 1) {
        paramAnimator.setAlpha(0.0F);
      }
      FloatingVideoWrapper.d(this.c, this.a);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingVideoWrapper.d(this.c, this.a);
    if (this.a == 1)
    {
      FloatingVideoWrapper.b(this.c, false);
      paramAnimator = this.c;
      paramAnimator.a(false, new View[] { FloatingVideoWrapper.b(paramAnimator) });
    }
    FloatingVideoWrapper.l(this.c);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FloatingVideoWrapper.d(this.c, 2);
    if (this.a == 0)
    {
      FloatingVideoWrapper.b(this.c, true);
      if ((FloatingVideoWrapper.e(this.c) == 1) || (FloatingVideoWrapper.e(this.c) == 4))
      {
        paramAnimator = this.c;
        paramAnimator.a(true, new View[] { FloatingVideoWrapper.b(paramAnimator) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.14
 * JD-Core Version:    0.7.0.1
 */