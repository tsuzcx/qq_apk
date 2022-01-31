package com.tencent.open.appstore.report;

import android.text.TextUtils;
import bdhi;
import bdhz;
import bdii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.DownloadFinishLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$2
  implements Runnable
{
  public AppCenterReporter$2(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    boolean bool;
    do
    {
      return;
      localObject = bdhi.a().a(this.a.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        bdii.b("AppCenterReporter", ">reportDownloadSucc " + ((DownloadInfo)localObject).w + "|" + this.a.w);
        this.a.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.a.w);
      bdii.b("AppCenterReporter", ">reportDownloadSucc " + bool + "|" + (String)localObject + "|" + this.a.w + "|");
    } while (!bool);
    bdii.b("AppCenterReporter", "[reportDownloadSucc]");
    bdhz.a(3005, bdhz.a(this.a) + "|" + bdhz.b(this.a) + "|" + new File(this.a.l).length());
    Object localObject = new DownloadFinishLog();
    ((DownloadFinishLog)localObject).packageName = this.a.e;
    ((DownloadFinishLog)localObject).versionCode = this.a.jdField_b_of_type_Int;
    ((DownloadFinishLog)localObject).downloadUrl = this.a.d;
    try
    {
      ((DownloadFinishLog)localObject).yybAppId = Long.parseLong(this.a.c);
      ((DownloadFinishLog)localObject).yybApkId = Long.parseLong(this.a.k);
      label297:
      ((DownloadFinishLog)localObject).traceId = this.a.x;
      ((DownloadFinishLog)localObject).downloadFinishTime = System.currentTimeMillis();
      ((DownloadFinishLog)localObject).externalParams = new HashMap();
      ((DownloadFinishLog)localObject).externalParams.put("via", this.a.h);
      ((DownloadFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label297;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.2
 * JD-Core Version:    0.7.0.1
 */