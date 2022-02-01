package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManager$5$1
  implements Runnable
{
  DownloadManager$5$1(DownloadManager.5 param5, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnDownloadStateChanged,clientKey:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient);
    ((StringBuilder)localObject1).append(",state:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append(",url:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    LogUtility.b("DownloadManager_", ((StringBuilder)localObject1).toString());
    int i = DownloadManager.a(this.jdField_a_of_type_Int);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onStateChanged url: +++++loacalState=");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" +++++downloadInfo=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.c(this.jdField_a_of_type_JavaLangString));
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManager_", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
    if (localObject2 != null)
    {
      localObject1 = null;
      try
      {
        localObject2 = ((TMAssistantDownloadClient)localObject2).getDownloadTaskState(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManager_", "getDownloadTaskState>>>", localException);
      }
      if (localObject1 != null)
      {
        l2 = ((TMAssistantDownloadTaskInfo)localObject1).mReceiveDataLen;
        l1 = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        int j = (int)((float)l2 * 100.0F / (float)l1);
        localDownloadInfo.f = j;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OnDownloadSDKTaskStateChanged info progress = ");
        ((StringBuilder)localObject1).append(j);
        LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
        l3 = l1;
        break label299;
      }
    }
    long l1 = 0L;
    long l3 = l1;
    long l2 = l1;
    label299:
    if (i != -2)
    {
      if (i != 10)
      {
        if (i != 20)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(localDownloadInfo, 0L, l3 - localDownloadInfo.b, "complete");
              this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.b(localDownloadInfo);
              return;
            }
            this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(localDownloadInfo, l2, l2 - localDownloadInfo.b, "pause");
            this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(3, localDownloadInfo);
            return;
          }
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(2, localDownloadInfo);
          return;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(20, localDownloadInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(10, localDownloadInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(localDownloadInfo, l2, l3, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager$5.a.a(-2, localDownloadInfo, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */