package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import avik;
import aviy;
import avjb;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(aviy paramaviy) {}
  
  public void run()
  {
    try
    {
      aviy.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      avjb.a("3228166");
      avik.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      aviy.a(this.this$0).removeCallbacks(aviy.a(this.this$0));
      aviy.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */