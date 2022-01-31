package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Handler;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateObserver;

class AppBrandFragment$6
  extends MiniAppStateManager.MiniAppStateObserver
{
  AppBrandFragment$6(AppBrandFragment paramAppBrandFragment) {}
  
  public void onStateChange(MiniAppStateManager.MiniAppStateMsg paramMiniAppStateMsg)
  {
    super.onStateChange(paramMiniAppStateMsg);
    AppBrandFragment.access$300(this.this$0).post(new AppBrandFragment.6.1(this, paramMiniAppStateMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.6
 * JD-Core Version:    0.7.0.1
 */