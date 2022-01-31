package com.tencent.mobileqq.mini.appbrand;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class AppBrandRuntime$8$1
  implements Animation.AnimationListener
{
  AppBrandRuntime$8$1(AppBrandRuntime.8 param8) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AppBrandRuntime.access$200()) {
      this.this$1.this$0.pageContainer.onDomReady();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.8.1
 * JD-Core Version:    0.7.0.1
 */