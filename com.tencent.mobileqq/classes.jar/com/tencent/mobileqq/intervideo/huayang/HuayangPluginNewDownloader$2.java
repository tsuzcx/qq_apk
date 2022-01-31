package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import aqlm;
import aqma;
import aqmd;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(aqma paramaqma) {}
  
  public void run()
  {
    try
    {
      aqma.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      aqmd.a("3228166");
      aqlm.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      aqma.a(this.this$0).removeCallbacks(aqma.a(this.this$0));
      aqma.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */