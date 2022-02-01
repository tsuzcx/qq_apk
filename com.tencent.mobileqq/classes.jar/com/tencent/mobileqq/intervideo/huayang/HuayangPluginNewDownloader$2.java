package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;

class HuayangPluginNewDownloader$2
  implements Runnable
{
  HuayangPluginNewDownloader$2(HuayangPluginNewDownloader paramHuayangPluginNewDownloader) {}
  
  public void run()
  {
    try
    {
      HuayangPluginNewDownloader.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      Monitor.a("3228166");
      HuayangCrashReport.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      HuayangPluginNewDownloader.a(this.this$0).removeCallbacks(HuayangPluginNewDownloader.a(this.this$0));
      HuayangPluginNewDownloader.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */