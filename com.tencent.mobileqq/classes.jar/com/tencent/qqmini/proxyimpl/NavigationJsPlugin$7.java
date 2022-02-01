package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

class NavigationJsPlugin$7
  extends ResultReceiver
{
  NavigationJsPlugin$7(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onLaunchResult(true, null);
      }
      if ((NavigationJsPlugin.b(this.b).getAttachedActivity() != null) && (!NavigationJsPlugin.c(this.b).getAttachedActivity().isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        NavigationJsPlugin.d(this.b).getAttachedActivity().finish();
      }
    }
    else
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onLaunchResult(false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */