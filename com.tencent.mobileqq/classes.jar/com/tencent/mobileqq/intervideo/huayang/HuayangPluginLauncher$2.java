package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import android.os.Message;
import anvx;
import avty;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(avty paramavty, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (avty.a(this.this$0) == null)
    {
      avty.a(this.this$0, avty.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - avty.a(this.this$0));
        if (l > 0L) {
          avty.a(this.this$0, "HuayangPluginLauncher", anvx.a(2131705131) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((avty.a(this.this$0) != null) && (avty.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(avty.a(this.this$0), 2);
          avty.a(this.this$0).sendMessage(localMessage);
          avty.a(this.this$0, avty.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        avty.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        avty.b(this.this$0, avty.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */