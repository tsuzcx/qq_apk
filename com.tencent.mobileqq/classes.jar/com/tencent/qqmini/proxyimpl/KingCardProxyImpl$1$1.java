package com.tencent.qqmini.proxyimpl;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;

class KingCardProxyImpl$1$1
  extends D8SafeAnimatorListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */