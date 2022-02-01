package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallStartLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class AppCenterReporter$4
  implements Runnable
{
  AppCenterReporter$4(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().b(this.a.b);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportInstallStart ");
      localStringBuilder.append(((DownloadInfo)localObject).R);
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.R);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.a.R = ((DownloadInfo)localObject).R;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.a.R);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportInstallStart ");
    localStringBuilder.append(bool);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a.R);
    localStringBuilder.append("|");
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    if (!bool) {
      return;
    }
    LogUtility.b("AppCenterReporter", "[reportInstallStart]");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.h(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.i(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(new File(this.a.q).length());
    AppCenterReporter.a(3007, ((StringBuilder)localObject).toString());
    localObject = new InstallStartLog();
    ((InstallStartLog)localObject).packageName = this.a.e;
    ((InstallStartLog)localObject).versionCode = this.a.n;
    ((InstallStartLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((InstallStartLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((InstallStartLog)localObject).yybApkId = Long.parseLong(this.a.m);
      label336:
      ((InstallStartLog)localObject).traceId = this.a.S;
      ((InstallStartLog)localObject).installStartTime = System.currentTimeMillis();
      ((InstallStartLog)localObject).externalParams = new HashMap();
      ((InstallStartLog)localObject).externalParams.put("via", this.a.h);
      ((InstallStartLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.4
 * JD-Core Version:    0.7.0.1
 */