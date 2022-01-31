package com.tencent.mobileqq.webview.swift.utils;

import bdox;
import befo;
import befr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SwiftWebAccelerator$6
  implements Runnable
{
  public SwiftWebAccelerator$6(befo parambefo, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers.run cost " + (l - this.a) + "ms.");
    l = System.currentTimeMillis();
    if (!VipWebViewReportLog.a())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
      VipWebViewReportLog.a(BaseApplicationImpl.sApplication.getApplicationContext(), localAppRuntime);
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load http core data config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    befr.a();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load cdn cache config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    bdox.a(BaseApplicationImpl.sApplication.getRuntime());
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load Individuation url config, cost " + (System.currentTimeMillis() - l) + "ms.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6
 * JD-Core Version:    0.7.0.1
 */