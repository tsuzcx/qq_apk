package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import auns;
import auog;
import auoj;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(auog paramauog) {}
  
  public void run()
  {
    try
    {
      auog.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      auoj.a("3228166");
      auns.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      auog.a(this.this$0).removeCallbacks(auog.a(this.this$0));
      auog.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */