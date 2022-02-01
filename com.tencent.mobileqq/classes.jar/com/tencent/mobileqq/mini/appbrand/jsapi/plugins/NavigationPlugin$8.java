package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class NavigationPlugin$8
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationPlugin$8(NavigationPlugin paramNavigationPlugin) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if ((this.this$0.jsPluginEngine.appBrandRuntime.activity != null) && (!this.this$0.jsPluginEngine.appBrandRuntime.activity.isFinishing()))
      {
        QLog.d("[mini] NavigationPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.this$0.jsPluginEngine.appBrandRuntime.activity.finish();
      }
      return;
    }
    QLog.e("[mini] NavigationPlugin", 1, "navigateBackMiniApp failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.8
 * JD-Core Version:    0.7.0.1
 */