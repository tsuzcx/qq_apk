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
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_b_of_type_JavaLangString);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportInstallComplete ");
      localStringBuilder.append(((DownloadInfo)localObject).w);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportInstallComplete ");
    localStringBuilder.append(bool);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
    localStringBuilder.append("|");
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    if (!bool) {
      return;
    }
    LogUtility.b("AppCenterReporter", "[reportInstallComplete]");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    AppCenterReporter.a(3008, ((StringBuilder)localObject).toString());
    localObject = new InstallFinishLog();
    ((InstallFinishLog)localObject).packageName = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e;
    ((InstallFinishLog)localObject).versionCode = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_b_of_type_Int;
    ((InstallFinishLog)localObject).downloadUrl = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d;
    try
    {
      ((InstallFinishLog)localObject).yybAppId = Long.parseLong(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c);
      ((InstallFinishLog)localObject).yybApkId = Long.parseLong(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k);
      label345:
      ((InstallFinishLog)localObject).traceId = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.x;
      ((InstallFinishLog)localObject).installEndTime = System.currentTimeMillis();
      ((InstallFinishLog)localObject).externalParams = new HashMap();
      ((InstallFinishLog)localObject).externalParams.put("via", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h);
      ((InstallFinishLog)localObject).doReport();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label345;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.5
 * JD-Core Version:    0.7.0.1
 */