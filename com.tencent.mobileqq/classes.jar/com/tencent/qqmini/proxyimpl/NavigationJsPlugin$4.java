package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NavigationJsPlugin$4
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationJsPlugin$4(NavigationJsPlugin paramNavigationJsPlugin, boolean paramBoolean, Activity paramActivity, RequestEvent paramRequestEvent) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (this.a) {
        NavigationJsPlugin.a(this.d, this.b);
      }
    }
    else {
      this.c.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */