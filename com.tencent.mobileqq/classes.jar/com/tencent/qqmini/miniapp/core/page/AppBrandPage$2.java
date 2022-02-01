package com.tencent.qqmini.miniapp.core.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class AppBrandPage$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBrandPage$2(AppBrandPage paramAppBrandPage, PageWebview paramPageWebview) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ThreadManager.getUIHandler().post(new AppBrandPage.2.1(this, paramValueAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.2
 * JD-Core Version:    0.7.0.1
 */