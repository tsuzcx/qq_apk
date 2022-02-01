package com.tencent.qqmini.proxyimpl;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;

class KingCardProxyImpl$1$1
  implements Animator.AnimatorListener
{
  KingCardProxyImpl$1$1(KingCardProxyImpl.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */