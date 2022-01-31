package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import aswh;
import aswv;
import aswy;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(aswv paramaswv) {}
  
  public void run()
  {
    try
    {
      aswv.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      aswy.a("3228166");
      aswh.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      aswv.a(this.this$0).removeCallbacks(aswv.a(this.this$0));
      aswv.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */