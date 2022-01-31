package com.tencent.tmdownloader;

import android.os.Handler;
import com.tencent.tmassistantbase.util.r;

class v
  implements Runnable
{
  v(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(10000L);
      TMAssistantDownloadService.access$000(this.a).sendEmptyMessage(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      r.b("TMADownloadSDKService", "exception:", localInterruptedException);
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.v
 * JD-Core Version:    0.7.0.1
 */