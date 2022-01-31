package com.tencent.mobileqq.intervideo.huayang;

import alpo;
import android.os.Handler;
import android.os.Message;
import asws;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(asws paramasws, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (asws.a(this.this$0) == null)
    {
      asws.a(this.this$0, asws.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - asws.a(this.this$0));
        if (l > 0L) {
          asws.a(this.this$0, "HuayangPluginLauncher", alpo.a(2131706030) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((asws.a(this.this$0) != null) && (asws.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(asws.a(this.this$0), 2);
          asws.a(this.this$0).sendMessage(localMessage);
          asws.a(this.this$0, asws.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        asws.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        asws.b(this.this$0, asws.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */