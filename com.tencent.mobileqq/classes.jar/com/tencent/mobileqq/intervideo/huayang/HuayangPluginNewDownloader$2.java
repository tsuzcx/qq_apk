package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import awas;
import awbg;
import awbj;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(awbg paramawbg) {}
  
  public void run()
  {
    try
    {
      awbg.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      awbj.a("3228166");
      awas.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      awbg.a(this.this$0).removeCallbacks(awbg.a(this.this$0));
      awbg.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */