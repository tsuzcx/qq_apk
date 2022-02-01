package com.tencent.open.appstore.dl;

import bhyo;
import bhzm;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$15
  implements Runnable
{
  public DownloadManagerV2$15(bhyo parambhyo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bhyo.a(this.this$0).deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bhyo.a(this.this$0).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      bhzm.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */