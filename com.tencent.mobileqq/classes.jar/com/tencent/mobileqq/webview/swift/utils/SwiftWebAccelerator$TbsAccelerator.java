package com.tencent.mobileqq.webview.swift.utils;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class SwiftWebAccelerator$TbsAccelerator
{
  static final AtomicBoolean a = new AtomicBoolean(false);
  public static long b = 0L;
  
  public static boolean a()
  {
    return a.get();
  }
  
  public static boolean b()
  {
    if (a.compareAndSet(false, true))
    {
      long l = System.currentTimeMillis();
      Object localObject = new HashMap();
      ((HashMap)localObject).put("use_speedy_classloader", Boolean.valueOf(true));
      ((HashMap)localObject).put("use_dexloader_service", Boolean.valueOf(false));
      QbSdk.initTbsSettings((Map)localObject);
      WebAccelerator.initTbsEnvironment(MobileQQ.sMobileQQ.getApplicationContext(), 2);
      if (MobileQQ.sProcessId == 1) {
        CaughtExceptionReport.a(new RuntimeException("Webview init. "));
      }
      com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.I = SystemClock.elapsedRealtime();
      b = System.currentTimeMillis() - l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WebAccelerator.initTbsEnvironment, cost=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator
 * JD-Core Version:    0.7.0.1
 */