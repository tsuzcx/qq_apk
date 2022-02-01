package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NavigationJsPlugin$2
  extends ResultReceiver
{
  NavigationJsPlugin$2(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, RequestEvent paramRequestEvent)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 0) {
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */