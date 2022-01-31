package com.tencent.open.appstore.dl;

import bdgv;
import bdht;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$15
  implements Runnable
{
  public DownloadManagerV2$15(bdgv parambdgv, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bdgv.a(this.this$0).deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      bdgv.a(this.this$0).cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      bdht.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */