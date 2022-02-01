package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadFinishLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class AppCenterReporter$2
  implements Runnable
{
  AppCenterReporter$2(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().b(this.a.b);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportDownloadSucc ");
      localStringBuilder.append(((DownloadInfo)localObject).R);
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.R);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.a.R = ((DownloadInfo)localObject).R;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.a.R);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportDownloadSucc ");
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
    LogUtility.b("AppCenterReporter", "[reportDownloadSucc]");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.h(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.i(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(new File(this.a.q).length());
    AppCenterReporter.a(3005, ((StringBuilder)localObject).toString());
    localObject = new DownloadFinishLog();
    ((DownloadFinishLog)localObject).packageName = this.a.e;
    ((DownloadFinishLog)localObject).versionCode = this.a.n;
    ((DownloadFinishLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((DownloadFinishLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((DownloadFinishLog)localObject).yybApkId = Long.parseLong(this.a.m);
      label336:
      ((DownloadFinishLog)localObject).traceId = this.a.S;
      ((DownloadFinishLog)localObject).downloadFinishTime = System.currentTimeMillis();
      ((DownloadFinishLog)localObject).externalParams = new HashMap();
      ((DownloadFinishLog)localObject).externalParams.put("via", this.a.h);
      ((DownloadFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.2
 * JD-Core Version:    0.7.0.1
 */