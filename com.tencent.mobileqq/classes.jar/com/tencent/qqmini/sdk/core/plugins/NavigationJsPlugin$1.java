package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import beka;
import besl;

class NavigationJsPlugin$1
  extends ResultReceiver
{
  NavigationJsPlugin$1(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, beka parambeka)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    besl.a("NavigationJsPlugin", "onReceiveResult resultCode : " + paramInt);
    if (paramInt != 0) {
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */