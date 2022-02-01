package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class NavigationJsPlugin$1
  extends ResultReceiver
{
  NavigationJsPlugin$1(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, RequestEvent paramRequestEvent)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onReceiveResult resultCode : ");
    paramBundle.append(paramInt);
    QMLog.d("NavigationJsPlugin", paramBundle.toString());
    if (paramInt != 0) {
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */