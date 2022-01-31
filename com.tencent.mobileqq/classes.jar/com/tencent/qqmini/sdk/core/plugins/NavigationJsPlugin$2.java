package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bgkd;

class NavigationJsPlugin$2
  extends ResultReceiver
{
  NavigationJsPlugin$2(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, bgkd parambgkd)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 0) {
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */