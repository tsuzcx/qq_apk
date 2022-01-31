package com.tencent.open.appstore.dl;

import bfgi;
import bfhg;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$23
  implements Runnable
{
  public DownloadManagerV2$23(bfgi parambfgi, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    bfhg.b("DownloadManagerV2", "OnDownloadStateChanged,clientKey:" + this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient + ",state:" + this.jdField_a_of_type_Int + ",url:" + this.jdField_a_of_type_JavaLangString);
    int i = bfgi.a(this.jdField_a_of_type_Int);
    bfhg.a("DownloadManagerV2", "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.this$0.b(this.jdField_a_of_type_JavaLangString));
    DownloadInfo localDownloadInfo = bfgi.a(this.this$0, this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null)
    {
      bfhg.d("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null) {}
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(this.jdField_a_of_type_JavaLangString);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        long l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        long l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.f = j;
        localDownloadInfo.l = localTMAssistantDownloadTaskInfo.mSavePath;
        bfhg.a("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info progress = " + j + ", " + localTMAssistantDownloadTaskInfo.mReceiveDataLen + "|" + localTMAssistantDownloadTaskInfo.mTotalDataLen);
      }
      switch (i)
      {
      default: 
        return;
      case -2: 
        bfgi.a(this.this$0, -2, localDownloadInfo, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bfhg.c("DownloadManagerV2", "getDownloadTaskState>>>", localException);
        Object localObject = null;
      }
      this.this$0.a(2, localDownloadInfo);
      return;
    }
    this.this$0.a(3, localDownloadInfo);
    return;
    this.this$0.a(localDownloadInfo);
    return;
    this.this$0.a(20, localDownloadInfo);
    return;
    this.this$0.a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.23
 * JD-Core Version:    0.7.0.1
 */