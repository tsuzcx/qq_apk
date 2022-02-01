package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

class NavigationJsPlugin$6
  extends ResultReceiver
{
  NavigationJsPlugin$6(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
      if (paramBundle != null) {
        paramBundle.onLaunchResult(true, null);
      }
      if ((NavigationJsPlugin.a(this.jdField_a_of_type_ComTencentQqminiProxyimplNavigationJsPlugin).getAttachedActivity() != null) && (!NavigationJsPlugin.b(this.jdField_a_of_type_ComTencentQqminiProxyimplNavigationJsPlugin).getAttachedActivity().isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        NavigationJsPlugin.c(this.jdField_a_of_type_ComTencentQqminiProxyimplNavigationJsPlugin).getAttachedActivity().finish();
      }
    }
    else
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
      if (paramBundle != null) {
        paramBundle.onLaunchResult(false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */