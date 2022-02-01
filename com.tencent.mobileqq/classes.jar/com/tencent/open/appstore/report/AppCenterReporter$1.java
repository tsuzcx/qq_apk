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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.b(this.a));
    AppCenterReporter.a(3004, ((StringBuilder)localObject).toString());
    AppCenterReporter.d(this.a);
    localObject = new DownloadStartLog();
    ((DownloadStartLog)localObject).packageName = this.a.e;
    ((DownloadStartLog)localObject).versionCode = this.a.b;
    ((DownloadStartLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((DownloadStartLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((DownloadStartLog)localObject).yybApkId = Long.parseLong(this.a.k);
      label132:
      ((DownloadStartLog)localObject).traceId = this.a.x;
      ((DownloadStartLog)localObject).downloadStartTime = System.currentTimeMillis();
      ((DownloadStartLog)localObject).externalParams = new HashMap();
      ((DownloadStartLog)localObject).externalParams.put("via", this.a.h);
      ((DownloadStartLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.1
 * JD-Core Version:    0.7.0.1
 */