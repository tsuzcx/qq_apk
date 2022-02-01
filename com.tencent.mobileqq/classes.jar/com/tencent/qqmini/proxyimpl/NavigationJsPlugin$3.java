package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NavigationJsPlugin$3
  extends ResultReceiver
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, boolean paramBoolean, Activity paramActivity, RequestEvent paramRequestEvent)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
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
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */