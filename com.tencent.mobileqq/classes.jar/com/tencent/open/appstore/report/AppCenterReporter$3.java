package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

final class AppCenterReporter$3
  implements Runnable
{
  AppCenterReporter$3(DownloadInfo paramDownloadInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().b(this.a.b);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportDownloadError ");
      localStringBuilder.append(((DownloadInfo)localObject).R);
      localStringBuilder.append("|");
      localStringBuilder.append(this.a.R);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.a.R = ((DownloadInfo)localObject).R;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.a.R);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportDownloadError ");
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportDownloadError] errorCode=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",errorMsg=");
    ((StringBuilder)localObject).append(this.c);
    LogUtility.b("AppCenterReporter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.h(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.i(this.a));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.c);
    AppCenterReporter.a(3006, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */