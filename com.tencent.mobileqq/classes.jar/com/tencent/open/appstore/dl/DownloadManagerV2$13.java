package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bdhk;
import bdii;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

public class DownloadManagerV2$13
  implements Runnable
{
  public DownloadManagerV2$13(bdhk parambdhk, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bdii.b("DownloadManagerV2", "startDownload download file, url = " + this.jdField_a_of_type_JavaLangString + "params = " + this.jdField_a_of_type_JavaUtilMap);
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
            i = bdhk.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive", this.jdField_a_of_type_JavaUtilMap);
            bdii.b("DownloadManagerV2", "startDownloadTask downloadSDKClient result=" + i + " url=" + this.jdField_a_of_type_JavaLangString);
            if (i == 0) {
              break;
            }
            bdhk.a(this.this$0, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
            return;
          }
          if (this.jdField_a_of_type_Int == 1)
          {
            this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
            i = bdhk.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff", this.jdField_a_of_type_JavaUtilMap);
          }
          else
          {
            bdii.a("DownloadManagerV2", "startDownload download unapk file, url = " + this.jdField_a_of_type_JavaLangString + ",filename = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e);
            i = bdhk.a(this.this$0).startDownloadTask(this.jdField_a_of_type_JavaLangString, 0, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f, this.jdField_a_of_type_JavaUtilMap);
            continue;
            i = 3;
          }
        }
        catch (Exception localException)
        {
          bdii.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
        }
      }
    } while ((this.b != this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 20));
    this.this$0.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.13
 * JD-Core Version:    0.7.0.1
 */