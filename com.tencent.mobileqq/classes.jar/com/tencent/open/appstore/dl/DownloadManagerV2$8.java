package com.tencent.open.appstore.dl;

import bjjq;
import bjko;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$8
  implements Runnable
{
  public DownloadManagerV2$8(bjjq parambjjq, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bjjq.a(this.this$0).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      bjjq.a(this.this$0, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      return;
    }
    catch (Exception localException)
    {
      bjko.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.8
 * JD-Core Version:    0.7.0.1
 */