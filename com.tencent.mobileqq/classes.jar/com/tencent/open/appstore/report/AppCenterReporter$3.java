package com.tencent.open.appstore.report;

import android.text.TextUtils;
import bjsx;
import bjto;
import bjtx;
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
      Object localObject = bjsx.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      if (localObject != null)
      {
        bjtx.b("AppCenterReporter", ">reportDownloadError " + ((DownloadInfo)localObject).w + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w = ((DownloadInfo)localObject).w;
      }
      localObject = BaseApplicationImpl.getApplication().getQQProcessName();
      bool = TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w);
      bjtx.b("AppCenterReporter", ">reportDownloadError " + bool + "|" + (String)localObject + "|" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.w + "|");
    } while (!bool);
    bjtx.b("AppCenterReporter", "[reportDownloadError] errorCode=" + this.jdField_a_of_type_Int + ",errorMsg=" + this.jdField_a_of_type_JavaLangString);
    bjto.a(3006, bjto.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + bjto.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) + "|" + this.jdField_a_of_type_Int + "|" + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.3
 * JD-Core Version:    0.7.0.1
 */