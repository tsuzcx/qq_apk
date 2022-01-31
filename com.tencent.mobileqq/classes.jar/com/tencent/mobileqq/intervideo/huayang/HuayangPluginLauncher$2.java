package com.tencent.mobileqq.intervideo.huayang;

import ajya;
import android.os.Handler;
import android.os.Message;
import arge;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(arge paramarge, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (arge.a(this.this$0) == null)
    {
      arge.a(this.this$0, arge.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - arge.a(this.this$0));
        if (l > 0L) {
          arge.a(this.this$0, "HuayangPluginLauncher", ajya.a(2131705658) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((arge.a(this.this$0) != null) && (arge.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(arge.a(this.this$0), 2);
          arge.a(this.this$0).sendMessage(localMessage);
          arge.a(this.this$0, arge.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        arge.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        arge.b(this.this$0, arge.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */