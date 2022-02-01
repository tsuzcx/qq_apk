package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallFinishLog;
import java.util.HashMap;
import java.util.Map;

final class AppCenterReporter$5
  implements Runnable
{
  AppCenterReporter$5(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().b(this.a.b);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportInstallComplete ");
      localStringBuilder.append(((DownloadInfo)localObject).R);
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.R);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.a.R = ((DownloadInfo)localObject).R;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.a.R);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportInstallComplete ");
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
    LogUtility.b("AppCenterReporter", "[reportInstallComplete]");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.h(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.i(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.a.e));
    AppCenterReporter.a(3008, ((StringBuilder)localObject).toString());
    localObject = new InstallFinishLog();
    ((InstallFinishLog)localObject).packageName = this.a.e;
    ((InstallFinishLog)localObject).versionCode = this.a.n;
    ((InstallFinishLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((InstallFinishLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((InstallFinishLog)localObject).yybApkId = Long.parseLong(this.a.m);
      label345:
      ((InstallFinishLog)localObject).traceId = this.a.S;
      ((InstallFinishLog)localObject).installEndTime = System.currentTimeMillis();
      ((InstallFinishLog)localObject).externalParams = new HashMap();
      ((InstallFinishLog)localObject).externalParams.put("via", this.a.h);
      ((InstallFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label345;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.5
 * JD-Core Version:    0.7.0.1
 */