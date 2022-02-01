package com.tencent.open.appstore.dl;

import bjsz;
import bjtx;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$14
  implements Runnable
{
  public DownloadManagerV2$14(bjsz parambjsz, String paramString) {}
  
  public void run()
  {
    try
    {
      bjsz.a(this.this$0).pauseDownloadTask(this.a);
      return;
    }
    catch (Exception localException)
    {
      bjtx.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.14
 * JD-Core Version:    0.7.0.1
 */