package com.tencent.open.downloadnew;

import bdht;
import bdkp;
import bdme;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$8
  implements Runnable
{
  public DownloadManager$8(bdkp parambdkp, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      this.this$0.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      this.this$0.a.remove(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c);
      bdme.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c);
      return;
    }
    catch (Exception localException)
    {
      bdht.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.8
 * JD-Core Version:    0.7.0.1
 */