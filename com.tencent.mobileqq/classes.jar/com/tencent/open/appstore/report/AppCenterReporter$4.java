package com.tencent.open.appstore.report;

import android.text.TextUtils;
import bfkp;
import bflg;
import bflp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallStartLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$4
  implements Runnable
{
  public AppCenterReporter$4(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    boolean bool;
    do
    {
      return;
      localObject = bfkp.a().a(this.a.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        bflp.b("AppCenterReporter", ">reportInstallStart " + ((DownloadInfo)localObject).w + "|" + this.a.w);
        this.a.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.a.w);
      bflp.b("AppCenterReporter", ">reportInstallStart " + bool + "|" + (String)localObject + "|" + this.a.w + "|");
    } while (!bool);
    bflp.b("AppCenterReporter", "[reportInstallStart]");
    bflg.a(3007, bflg.a(this.a) + "|" + bflg.b(this.a) + "|" + new File(this.a.l).length());
    Object localObject = new InstallStartLog();
    ((InstallStartLog)localObject).packageName = this.a.e;
    ((InstallStartLog)localObject).versionCode = this.a.jdField_b_of_type_Int;
    ((InstallStartLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((InstallStartLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((InstallStartLog)localObject).yybApkId = Long.parseLong(this.a.k);
      label297:
      ((InstallStartLog)localObject).traceId = this.a.x;
      ((InstallStartLog)localObject).installStartTime = System.currentTimeMillis();
      ((InstallStartLog)localObject).externalParams = new HashMap();
      ((InstallStartLog)localObject).externalParams.put("via", this.a.h);
      ((InstallStartLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label297;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.4
 * JD-Core Version:    0.7.0.1
 */