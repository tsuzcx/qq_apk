package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class NavigationJsPlugin$6
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$6(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = this.a;
      if ((paramBundle != null) && (!paramBundle.isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.a.finish();
      }
    }
    else
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */