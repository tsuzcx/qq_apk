package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import arfr;
import argf;
import argi;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(argf paramargf) {}
  
  public void run()
  {
    try
    {
      argf.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      argi.a("3228166");
      arfr.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      argf.a(this.this$0).removeCallbacks(argf.a(this.this$0));
      argf.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */