package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bdgu;
import bdht;
import bdkp;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

public class DownloadManager$11
  implements Runnable
{
  public DownloadManager$11(bdkp parambdkp, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2, DownloadInfo paramDownloadInfo3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bdht.a("DownloadManager_", "startDownload download file, url = " + this.jdField_a_of_type_JavaLangString + "params = " + this.jdField_a_of_type_JavaUtilMap);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive", this.jdField_a_of_type_JavaUtilMap);
          bdht.a("DownloadManager_", "startDownloadTask downloadSDKClient result=" + i + " url=" + this.jdField_a_of_type_JavaLangString);
          if (i == 0) {
            break label282;
          }
          this.this$0.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
          bdgu.a(1, this.jdField_a_of_type_JavaLangString, i, this.c);
          return;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
          i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff", this.jdField_a_of_type_JavaUtilMap);
          continue;
        }
        bdht.a("DownloadManager_", "startDownload download unapk file, url = " + this.jdField_a_of_type_JavaLangString + ",filename = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_e_of_type_JavaLangString);
        int i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, 0, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f, this.jdField_a_of_type_JavaUtilMap);
        continue;
        i = 3;
      }
      catch (Exception localException)
      {
        bdht.c("DownloadManager_", "downloadSDKClient>>>", localException);
      }
      continue;
      label282:
      if ((this.b == this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_e_of_type_Int == 20)) {
        this.this$0.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.11
 * JD-Core Version:    0.7.0.1
 */