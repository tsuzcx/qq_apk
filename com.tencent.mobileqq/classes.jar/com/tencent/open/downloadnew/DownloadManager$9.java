package com.tencent.open.downloadnew;

import bflp;
import bfok;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$9
  implements Runnable
{
  public DownloadManager$9(bfok parambfok, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.this$0.a().deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.this$0.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      bflp.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.9
 * JD-Core Version:    0.7.0.1
 */