package com.tencent.mobileqq.webview.swift.utils;

import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class SwiftWebAccelerator$7
  implements Runnable
{
  SwiftWebAccelerator$7(long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("doThreadedStep_InitEngine.run cost ");
    ((StringBuilder)???).append(l - this.a);
    ((StringBuilder)???).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)???).toString());
    l = System.currentTimeMillis();
    synchronized (SwiftWebAccelerator.a)
    {
      if (WebViewPluginEngine.a == null)
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localAppRuntime != null)
        {
          localAppRuntime = localAppRuntime.getAppRuntime("modular_web");
          WebViewPluginEngine.a = WebAccelerateHelper.getInstance().createWebViewPluginEngine(localAppRuntime, null, null, null);
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("doThreadedStep_InitEngine:init plugin engine, cost ");
      ((StringBuilder)???).append(System.currentTimeMillis() - l);
      ((StringBuilder)???).append("ms.");
      QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)???).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.7
 * JD-Core Version:    0.7.0.1
 */