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
    Object localObject = DownloadInfoDB.a().a(this.a.jdField_b_of_type_JavaLangString);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportDownloadSucc ");
      localStringBuilder.append(((DownloadInfo)localObject).w);
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.w);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.a.w = ((DownloadInfo)localObject).w;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.a.w);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportDownloadSucc ");
    localStringBuilder.append(bool);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a.w);
    localStringBuilder.append("|");
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    if (!bool) {
      return;
    }
    LogUtility.b("AppCenterReporter", "[reportDownloadSucc]");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.b(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(new File(this.a.l).length());
    AppCenterReporter.a(3005, ((StringBuilder)localObject).toString());
    localObject = new DownloadFinishLog();
    ((DownloadFinishLog)localObject).packageName = this.a.e;
    ((DownloadFinishLog)localObject).versionCode = this.a.jdField_b_of_type_Int;
    ((DownloadFinishLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((DownloadFinishLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((DownloadFinishLog)localObject).yybApkId = Long.parseLong(this.a.k);
      label336:
      ((DownloadFinishLog)localObject).traceId = this.a.x;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.2
 * JD-Core Version:    0.7.0.1
 */