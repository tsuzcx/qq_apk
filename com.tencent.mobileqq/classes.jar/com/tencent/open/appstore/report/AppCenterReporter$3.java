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
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {}
    boolean bool;
    do
    {
      return;
      Object localObject = DownloadInfoDB.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      if (localObject != null)
      {
        LogUtility.b("AppCenterReporter", ">reportDownloadError " + ((DownloadInfo)localObject).w + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      LogUtility.b("AppCenterReporter", ">reportDownloadError " + bool + "|" + (String)localObject + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w + "|");
    } while (!bool);
    LogUtility.b("AppCenterReporter", "[reportDownloadError] errorCode=" + this.jdField_a_of_type_Int + ",errorMsg=" + this.jdField_a_of_type_JavaLangString);
    AppCenterReporter.a(3006, AppCenterReporter.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + AppCenterReporter.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + this.jdField_a_of_type_Int + "|" + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */