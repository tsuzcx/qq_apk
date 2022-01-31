package com.tencent.open.appstore.dl;

import bccu;
import bcds;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$14
  implements Runnable
{
  public DownloadManagerV2$14(bccu parambccu, String paramString) {}
  
  public void run()
  {
    try
    {
      bccu.a(this.this$0).pauseDownloadTask(this.a);
      return;
    }
    catch (Exception localException)
    {
      bcds.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.14
 * JD-Core Version:    0.7.0.1
 */