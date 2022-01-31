package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import mqq.os.MqqHandler;

class UIJsPlugin$25
  implements ValueAnimator.AnimatorUpdateListener
{
  UIJsPlugin$25(UIJsPlugin paramUIJsPlugin, PageWebview paramPageWebview) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ThreadManager.getUIHandler().post(new UIJsPlugin.25.1(this, paramValueAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.25
 * JD-Core Version:    0.7.0.1
 */