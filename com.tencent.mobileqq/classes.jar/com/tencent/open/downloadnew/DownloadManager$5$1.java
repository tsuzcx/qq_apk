package com.tencent.open.downloadnew;

import bflp;
import bfok;
import bfoq;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$5$1
  implements Runnable
{
  public DownloadManager$5$1(bfoq parambfoq, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    bflp.b("DownloadManager_", "OnDownloadStateChanged,clientKey:" + this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient + ",state:" + this.jdField_a_of_type_Int + ",url:" + this.jdField_a_of_type_JavaLangString);
    int i = bfok.a(this.jdField_a_of_type_Int);
    bflp.a("DownloadManager_", "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.jdField_a_of_type_Bfoq.a.c(this.jdField_a_of_type_JavaLangString));
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Bfoq.a.a(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null)
    {
      bflp.d("DownloadManager_", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(this.jdField_a_of_type_JavaLangString);
        if (localTMAssistantDownloadTaskInfo == null) {
          break label448;
        }
        l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.f = j;
        bflp.a("DownloadManager_", "OnDownloadSDKTaskStateChanged info progress = " + j);
        switch (i)
        {
        default: 
          return;
        case -2: 
          this.jdField_a_of_type_Bfoq.a.a(localDownloadInfo, l1, l2, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Bfoq.a.a(-2, localDownloadInfo, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        bflp.c("DownloadManager_", "getDownloadTaskState>>>", localException);
        Object localObject = null;
        continue;
        this.jdField_a_of_type_Bfoq.a.a(2, localDownloadInfo);
        return;
      }
      this.jdField_a_of_type_Bfoq.a.a(localDownloadInfo, l1, l1 - localDownloadInfo.b, "pause");
      this.jdField_a_of_type_Bfoq.a.a(3, localDownloadInfo);
      return;
      this.jdField_a_of_type_Bfoq.a.a(localDownloadInfo, 0L, l2 - localDownloadInfo.b, "complete");
      this.jdField_a_of_type_Bfoq.a.b(localDownloadInfo);
      return;
      this.jdField_a_of_type_Bfoq.a.a(20, localDownloadInfo);
      return;
      this.jdField_a_of_type_Bfoq.a.a(10, localDownloadInfo);
      return;
      label448:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */