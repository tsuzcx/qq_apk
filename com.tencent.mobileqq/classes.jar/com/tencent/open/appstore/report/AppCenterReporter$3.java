package com.tencent.open.appstore.report;

import android.text.TextUtils;
import bdhi;
import bdhz;
import bdii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

public final class AppCenterReporter$3
  implements Runnable
{
  public AppCenterReporter$3(DownloadInfo paramDownloadInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {}
    boolean bool;
    do
    {
      return;
      Object localObject = bdhi.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      if (localObject != null)
      {
        bdii.b("AppCenterReporter", ">reportDownloadError " + ((DownloadInfo)localObject).w + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      bdii.b("AppCenterReporter", ">reportDownloadError " + bool + "|" + (String)localObject + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w + "|");
    } while (!bool);
    bdii.b("AppCenterReporter", "[reportDownloadError] errorCode=" + this.jdField_a_of_type_Int + ",errorMsg=" + this.jdField_a_of_type_JavaLangString);
    bdhz.a(3006, bdhz.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + bdhz.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + this.jdField_a_of_type_Int + "|" + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */