package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import bekr;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class NavigationJsPlugin$2
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$2(NavigationJsPlugin paramNavigationJsPlugin, bekr parambekr) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */