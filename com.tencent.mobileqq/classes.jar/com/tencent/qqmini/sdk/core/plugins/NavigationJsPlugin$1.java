package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class NavigationJsPlugin$1
  extends ResultReceiver
{
  NavigationJsPlugin$1(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, bgok parambgok)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QMLog.d("NavigationJsPlugin", "onReceiveResult resultCode : " + paramInt);
    if (paramInt != 0) {
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */