package com.tencent.viola.ui.action;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponent.AnimationInfo;
import com.tencent.viola.utils.ViolaLogUtils;

class MethodAnimation$2
  extends AnimatorListenerAdapter
{
  MethodAnimation$2(MethodAnimation paramMethodAnimation, ViolaInstance paramViolaInstance, VComponent paramVComponent, VComponent.AnimationInfo paramAnimationInfo, String paramString) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.val$instance == null) || (this.val$instance.isDestroy()))
    {
      ViolaLogUtils.e("MethodAnimation", "RenderActionContextImpl-onAnimationEnd Instance == null NPE or instance is destroyed");
      return;
    }
    this.val$component.removeAnimationInfo(this.val$info);
    ViolaBridgeManager.getInstance().callbackJavascript(this.val$instance.getInstanceId(), "animate", "callback", this.val$callBack, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodAnimation.2
 * JD-Core Version:    0.7.0.1
 */