package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManagerV2$15
  implements Runnable
{
  DownloadManagerV2$15(DownloadManagerV2 paramDownloadManagerV2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        DownloadManagerV2.a(this.this$0).deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      DownloadManagerV2.a(this.this$0).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */