package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NavigationJsPlugin$3
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */