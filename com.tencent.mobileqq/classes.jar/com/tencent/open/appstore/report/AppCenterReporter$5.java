package com.tencent.open.appstore.report;

import android.text.TextUtils;
import bjjo;
import bjkf;
import bjko;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.st.InstallFinishLog;
import java.util.HashMap;
import java.util.Map;

public final class AppCenterReporter$5
  implements Runnable
{
  public AppCenterReporter$5(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {}
    boolean bool;
    do
    {
      return;
      localObject = bjjo.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        bjko.b("AppCenterReporter", ">reportInstallComplete " + ((DownloadInfo)localObject).w + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      bjko.b("AppCenterReporter", ">reportInstallComplete " + bool + "|" + (String)localObject + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w + "|");
    } while (!bool);
    bjko.b("AppCenterReporter", "[reportInstallComplete]");
    bjkf.a(3008, bjkf.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + bjkf.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + this.jdField_a_of_type_Int + "|" + bjkf.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    Object localObject = new InstallFinishLog();
    ((InstallFinishLog)localObject).packageName = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e;
    ((InstallFinishLog)localObject).versionCode = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_b_of_type_Int;
    ((InstallFinishLog)localObject).downloadUrl = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d;
    try
    {
      ((InstallFinishLog)localObject).yybAppId = Long.parseLong(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c);
      ((InstallFinishLog)localObject).yybApkId = Long.parseLong(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k);
      label302:
      ((InstallFinishLog)localObject).traceId = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.x;
      ((InstallFinishLog)localObject).installEndTime = System.currentTimeMillis();
      ((InstallFinishLog)localObject).externalParams = new HashMap();
      ((InstallFinishLog)localObject).externalParams.put("via", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h);
      ((InstallFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label302;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.5
 * JD-Core Version:    0.7.0.1
 */