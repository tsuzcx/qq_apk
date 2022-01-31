package com.tencent.open.appstore.report;

import bcdj;
import bcds;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadStartLog;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$1
  implements Runnable
{
  public AppCenterReporter$1(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bcds.b("AppCenterReporter", "[reportDownloadStart]");
    bcdj.a(3004, bcdj.a(this.a) + "|" + bcdj.b(this.a));
    bcdj.d(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.1
 * JD-Core Version:    0.7.0.1
 */