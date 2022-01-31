package com.tencent.mobileqq.mini.appbrand.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;

class AppBrandPageContainer$3
  implements Animation.AnimationListener
{
  AppBrandPageContainer$3(AppBrandPageContainer paramAppBrandPageContainer, AbsAppBrandPage paramAbsAppBrandPage) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$page.setVisibility(8);
    AppBrandTask.runTaskOnUiThreadDelay(new AppBrandPageContainer.3.1(this), 50L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.3
 * JD-Core Version:    0.7.0.1
 */