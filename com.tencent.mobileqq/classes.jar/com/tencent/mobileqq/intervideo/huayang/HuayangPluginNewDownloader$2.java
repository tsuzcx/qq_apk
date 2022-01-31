package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import arft;
import argh;
import argk;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(argh paramargh) {}
  
  public void run()
  {
    try
    {
      argh.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      argk.a("3228166");
      arft.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      argh.a(this.this$0).removeCallbacks(argh.a(this.this$0));
      argh.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */