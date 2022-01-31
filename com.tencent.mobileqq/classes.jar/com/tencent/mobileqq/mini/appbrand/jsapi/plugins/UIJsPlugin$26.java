package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class UIJsPlugin$26
  implements Animator.AnimatorListener
{
  UIJsPlugin$26(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.26
 * JD-Core Version:    0.7.0.1
 */