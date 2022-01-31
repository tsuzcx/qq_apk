package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import ataq;
import atbe;
import atbh;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(atbe paramatbe) {}
  
  public void run()
  {
    try
    {
      atbe.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      atbh.a("3228166");
      ataq.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      atbe.a(this.this$0).removeCallbacks(atbe.a(this.this$0));
      atbe.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */