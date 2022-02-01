package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import avtn;
import avub;
import avue;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(avub paramavub) {}
  
  public void run()
  {
    try
    {
      avub.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      avue.a("3228166");
      avtn.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      avub.a(this.this$0).removeCallbacks(avub.a(this.this$0));
      avub.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */