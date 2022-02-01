package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class NavigationJsPlugin$5
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$5(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
      {
        QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */