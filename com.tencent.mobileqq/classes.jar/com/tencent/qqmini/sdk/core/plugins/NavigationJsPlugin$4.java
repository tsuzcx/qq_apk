package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import betc;

class NavigationJsPlugin$4
  implements Runnable
{
  NavigationJsPlugin$4(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if (!this.val$activity.moveTaskToBack(false)) {
        this.val$activity.finish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("NavigationJsPlugin", "Failed to moveTaskBack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */