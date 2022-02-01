package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.statistics.service.ILocalMultiProcConfigService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QQCrashReportManager$3
  implements Runnable
{
  QQCrashReportManager$3(QQCrashReportManager paramQQCrashReportManager) {}
  
  public void run()
  {
    Object localObject1 = ReportControllerServiceHolder.d();
    int i;
    if (localObject1 != null) {
      i = ((ILocalMultiProcConfigService)localObject1).b("version_patchlib_load", 0);
    } else {
      i = 0;
    }
    if (i > 0)
    {
      Object localObject2 = MobileQQ.sMobileQQ;
      if (localObject2 != null)
      {
        localObject1 = null;
        try
        {
          localObject2 = ((Context)localObject2).getPackageManager().getPackageInfo(((Context)localObject2).getPackageName(), 0);
          localObject1 = localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          QLog.w("QQCrashReportManager", 1, "", localNameNotFoundException);
        }
        if ((localObject1 != null) && (((PackageInfo)localObject1).versionName != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((PackageInfo)localObject1).versionName);
          localStringBuilder.append(".");
          localStringBuilder.append(((PackageInfo)localObject1).versionCode + i);
          localObject1 = localStringBuilder.toString();
          CrashReport.setProductVersion(MobileQQ.sMobileQQ, (String)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashReportManager.3
 * JD-Core Version:    0.7.0.1
 */