package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.webview.swift.injector.ISwiftWebAcceleratorInjector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SwiftWebAccelerator$6
  implements Runnable
{
  SwiftWebAccelerator$6(SwiftWebAccelerator paramSwiftWebAccelerator, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_FireOthers.run cost ");
    ((StringBuilder)localObject).append(l - this.a);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    if (!VipWebViewReportLog.a())
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      VipWebViewReportLog.a(MobileQQ.sMobileQQ.getApplicationContext(), (AppRuntime)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_FireOthers:load http core data config, cost ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    SwiftWebViewUtils.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_FireOthers:load cdn cache config, cost ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    if (SwiftWebAccelerator.d() != null) {
      SwiftWebAccelerator.d().b(this.b);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_FireOthers:load Individuation url config, cost ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6
 * JD-Core Version:    0.7.0.1
 */