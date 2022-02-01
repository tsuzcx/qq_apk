package com.tencent.open.appstore.report;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadStartLog;
import java.util.HashMap;
import java.util.Map;

final class AppCenterReporter$1
  implements Runnable
{
  AppCenterReporter$1(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    LogUtility.b("AppCenterReporter", "[reportDownloadStart]");
    AppCenterReporter.a(3004, AppCenterReporter.a(this.a) + "|" + AppCenterReporter.b(this.a));
    AppCenterReporter.d(this.a);
    DownloadStartLog localDownloadStartLog = new DownloadStartLog();
    localDownloadStartLog.packageName = this.a.e;
    localDownloadStartLog.versionCode = this.a.b;
    localDownloadStartLog.downloadUrl = this.a.d;
    try
    {
      localDownloadStartLog.yybAppId = Long.parseLong(this.a.c);
      localDownloadStartLog.yybApkId = Long.parseLong(this.a.k);
      label124:
      localDownloadStartLog.traceId = this.a.x;
      localDownloadStartLog.downloadStartTime = System.currentTimeMillis();
      localDownloadStartLog.externalParams = new HashMap();
      localDownloadStartLog.externalParams.put("via", this.a.h);
      localDownloadStartLog.doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label124;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.1
 * JD-Core Version:    0.7.0.1
 */