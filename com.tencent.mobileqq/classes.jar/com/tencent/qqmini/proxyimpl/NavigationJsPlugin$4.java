package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class NavigationJsPlugin$4
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$4(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.val$activity.finish();
      }
      return;
    }
    QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */