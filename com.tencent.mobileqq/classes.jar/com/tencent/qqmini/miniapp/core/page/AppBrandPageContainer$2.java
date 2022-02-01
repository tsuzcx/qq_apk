package com.tencent.qqmini.miniapp.core.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;

class AppBrandPageContainer$2
  implements Animation.AnimationListener
{
  AppBrandPageContainer$2(AppBrandPageContainer paramAppBrandPageContainer, AppBrandPage paramAppBrandPage) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$appBrandPage.setVisibility(8);
    AppBrandTask.runTaskOnUiThreadDelay(new AppBrandPageContainer.2.1(this), 50L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.2
 * JD-Core Version:    0.7.0.1
 */