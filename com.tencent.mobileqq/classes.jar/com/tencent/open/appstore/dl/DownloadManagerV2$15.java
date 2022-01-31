package com.tencent.open.appstore.dl;

import bccu;
import bcds;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$15
  implements Runnable
{
  public DownloadManagerV2$15(bccu parambccu, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bccu.a(this.this$0).deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bccu.a(this.this$0).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      bcds.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */