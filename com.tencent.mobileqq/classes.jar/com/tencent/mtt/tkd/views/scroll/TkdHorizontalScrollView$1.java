package com.tencent.mtt.tkd.views.scroll;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class TkdHorizontalScrollView$1
  implements Animator.AnimatorListener
{
  TkdHorizontalScrollView$1(TkdHorizontalScrollView paramTkdHorizontalScrollView, Promise paramPromise) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.val$promise != null)
    {
      paramAnimator = new HippyMap();
      paramAnimator.pushString("msg", "on scroll end!");
      this.val$promise.resolve(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.scroll.TkdHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */