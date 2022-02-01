package com.tencent.mobileqq.onlinestatus.manager;

import android.animation.Animator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class OnlineStatusOlympicManager$2
  extends D8SafeAnimatorListener
{
  OnlineStatusOlympicManager$2(OnlineStatusOlympicManager paramOnlineStatusOlympicManager) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    OnlineStatusSPUtil.c(OnlineStatusOlympicManager.a(this.a).getApplicationContext(), OnlineStatusOlympicManager.c(this.a));
    OnlineStatusOlympicManager.d(this.a);
    OnlineStatusOlympicManager.a(this.a, System.currentTimeMillis() / 1000L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager.2
 * JD-Core Version:    0.7.0.1
 */