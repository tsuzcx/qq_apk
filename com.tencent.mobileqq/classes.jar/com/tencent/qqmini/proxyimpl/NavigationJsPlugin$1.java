package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class NavigationJsPlugin$1
  implements Runnable
{
  NavigationJsPlugin$1(NavigationJsPlugin paramNavigationJsPlugin, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if (NavigationJsPlugin.a(this.this$0))
      {
        this.a.finish();
        return;
      }
      if (!this.a.moveTaskToBack(false))
      {
        this.a.finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("NavigationJsPlugin", 1, "Failed to moveTaskBack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */