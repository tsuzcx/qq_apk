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
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    Object localObject = DownloadInfoDB.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">reportDownloadError ");
      localStringBuilder.append(((DownloadInfo)localObject).w);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      LogUtility.b("AppCenterReporter", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
    }
    localObject = BaseApplicationImpl.getApplication().getQQProcessName();
    boolean bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">reportDownloadError ");
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportDownloadError] errorCode=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(",errorMsg=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    LogUtility.b("AppCenterReporter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppCenterReporter.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(AppCenterReporter.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo));
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    AppCenterReporter.a(3006, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */