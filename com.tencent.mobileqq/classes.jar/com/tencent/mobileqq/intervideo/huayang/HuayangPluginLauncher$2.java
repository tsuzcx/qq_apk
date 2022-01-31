package com.tencent.mobileqq.intervideo.huayang;

import ajjy;
import android.os.Handler;
import android.os.Message;
import aqlx;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(aqlx paramaqlx, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (aqlx.a(this.this$0) == null)
    {
      aqlx.a(this.this$0, aqlx.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - aqlx.a(this.this$0));
        if (l > 0L) {
          aqlx.a(this.this$0, "HuayangPluginLauncher", ajjy.a(2131639862) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((aqlx.a(this.this$0) != null) && (aqlx.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(aqlx.a(this.this$0), 2);
          aqlx.a(this.this$0).sendMessage(localMessage);
          aqlx.a(this.this$0, aqlx.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        aqlx.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        aqlx.b(this.this$0, aqlx.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */