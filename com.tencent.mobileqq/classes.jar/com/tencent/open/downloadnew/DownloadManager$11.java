package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

class DownloadManager$11
  implements Runnable
{
  DownloadManager$11(DownloadManager paramDownloadManager, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2, DownloadInfo paramDownloadInfo3) {}
  
  public void run()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    int j = 3;
    int i = j;
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload download file, url = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("params = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap);
      LogUtility.a("DownloadManager_", localStringBuilder.toString());
      try
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive", this.jdField_a_of_type_JavaUtilMap);
        }
        else if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
          i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff", this.jdField_a_of_type_JavaUtilMap);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDownload download unapk file, url = ");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(",filename = ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_e_of_type_JavaLangString);
          LogUtility.a("DownloadManager_", localStringBuilder.toString());
          i = this.this$0.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, 0, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f, this.jdField_a_of_type_JavaUtilMap);
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
        i = j;
      }
    }
    for (;;)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTask downloadSDKClient result=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" url=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        this.this$0.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
      }
      else
      {
        localObject = this.b;
        DownloadInfo localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
        if ((localObject == localDownloadInfo) && (localDownloadInfo.jdField_e_of_type_Int == 20)) {
          this.this$0.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        }
      }
      DownloadInfoReport.a(1, this.jdField_a_of_type_JavaLangString, i, this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.11
 * JD-Core Version:    0.7.0.1
 */