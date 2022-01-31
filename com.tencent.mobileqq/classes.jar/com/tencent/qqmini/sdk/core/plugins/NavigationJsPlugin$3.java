package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bglv;
import bgok;

class NavigationJsPlugin$3
  extends ResultReceiver
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, bgok parambgok)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      this.val$req.a();
      if ((this.this$0.mMiniAppContext.a() != null) && (!this.this$0.mMiniAppContext.a().isFinishing())) {
        this.this$0.mMiniAppContext.a().finish();
      }
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */