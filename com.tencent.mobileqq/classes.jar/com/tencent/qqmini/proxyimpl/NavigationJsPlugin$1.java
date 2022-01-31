package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.qqmini.sdk.log.QMLog;

class NavigationJsPlugin$1
  implements Runnable
{
  NavigationJsPlugin$1(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
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
      QMLog.e("NavigationJsPlugin", "Failed to moveTaskBack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */