package com.tencent.mobileqq.intervideo.huayang;

import amtj;
import android.os.Handler;
import android.os.Message;
import auod;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(auod paramauod, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (auod.a(this.this$0) == null)
    {
      auod.a(this.this$0, auod.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - auod.a(this.this$0));
        if (l > 0L) {
          auod.a(this.this$0, "HuayangPluginLauncher", amtj.a(2131704780) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((auod.a(this.this$0) != null) && (auod.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(auod.a(this.this$0), 2);
          auod.a(this.this$0).sendMessage(localMessage);
          auod.a(this.this$0, auod.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        auod.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        auod.b(this.this$0, auod.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */