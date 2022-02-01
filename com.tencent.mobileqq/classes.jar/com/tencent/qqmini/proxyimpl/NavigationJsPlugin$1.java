package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Build.VERSION;
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
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.a.finishAndRemoveTask();
          return;
        }
        this.a.finish();
        return;
      }
      if (this.a.moveTaskToBack(false)) {
        break label61;
      }
      this.a.finish();
      return;
    }
    catch (Throwable localThrowable)
    {
      label53:
      label61:
      break label53;
    }
    QLog.e("NavigationJsPlugin", 1, "Failed to moveTaskBack");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */