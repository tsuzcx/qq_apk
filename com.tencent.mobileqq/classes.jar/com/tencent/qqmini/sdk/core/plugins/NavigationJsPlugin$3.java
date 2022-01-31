package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import begz;
import besl;

class NavigationJsPlugin$3
  extends ResultReceiver
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      if ((this.this$0.mMiniAppContext.a() != null) && (!this.this$0.mMiniAppContext.a().isFinishing())) {
        this.this$0.mMiniAppContext.a().finish();
      }
      return;
    }
    besl.d("NavigationJsPlugin", "navigateBackMiniApp failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */