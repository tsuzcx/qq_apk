package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

class DownloadManagerV2$13
  implements Runnable
{
  DownloadManagerV2$13(DownloadManagerV2 paramDownloadManagerV2, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      LogUtility.b("DownloadManagerV2", "startDownload download file, url = " + this.jdField_a_of_type_JavaLangString + "params = " + this.jdField_a_of_type_JavaUtilMap);
    }
    do
    {
      for (;;)
      {
        try
        {
          int i;
          if (this.jdField_a_of_type_Int == 0)
          {
            i = DownloadManagerV2.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive", this.jdField_a_of_type_JavaUtilMap);
            LogUtility.b("DownloadManagerV2", "startDownloadTask downloadSDKClient result=" + i + " url=" + this.jdField_a_of_type_JavaLangString);
            if (i == 0) {
              break;
            }
            DownloadManagerV2.a(this.this$0, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
            return;
          }
          if (this.jdField_a_of_type_Int == 1)
          {
            this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
            i = DownloadManagerV2.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff", this.jdField_a_of_type_JavaUtilMap);
          }
          else
          {
            LogUtility.a("DownloadManagerV2", "startDownload download unapk file, url = " + this.jdField_a_of_type_JavaLangString + ",filename = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e);
            i = DownloadManagerV2.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, 0, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f, this.jdField_a_of_type_JavaUtilMap);
            continue;
            i = 3;
          }
        }
        catch (Exception localException)
        {
          LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
        }
      }
    } while ((this.b != this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 20));
    this.this$0.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.13
 * JD-Core Version:    0.7.0.1
 */