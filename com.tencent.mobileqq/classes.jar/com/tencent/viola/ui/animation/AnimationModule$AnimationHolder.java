package com.tencent.viola.ui.animation;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.MethodAnimation;
import com.tencent.viola.ui.baseComponent.VComponent;

public class AnimationModule$AnimationHolder
{
  private String callback;
  private AnimationBean wxAnimationBean;
  
  public AnimationModule$AnimationHolder(AnimationBean paramAnimationBean, String paramString)
  {
    this.wxAnimationBean = paramAnimationBean;
    this.callback = paramString;
  }
  
  public void execute(ViolaInstance paramViolaInstance, VComponent paramVComponent)
  {
    paramVComponent = new MethodAnimation(paramVComponent.getRef(), this.wxAnimationBean, this.callback);
    ViolaSDKManager.getInstance().getRenderManager().runOnThread(paramViolaInstance.getInstanceId(), paramVComponent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.animation.AnimationModule.AnimationHolder
 * JD-Core Version:    0.7.0.1
 */