package com.tencent.mobileqq.intervideo.huayang;

import alud;
import android.os.Handler;
import android.os.Message;
import atbb;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(atbb paramatbb, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (atbb.a(this.this$0) == null)
    {
      atbb.a(this.this$0, atbb.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - atbb.a(this.this$0));
        if (l > 0L) {
          atbb.a(this.this$0, "HuayangPluginLauncher", alud.a(2131706042) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((atbb.a(this.this$0) != null) && (atbb.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(atbb.a(this.this$0), 2);
          atbb.a(this.this$0).sendMessage(localMessage);
          atbb.a(this.this$0, atbb.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        atbb.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        atbb.b(this.this$0, atbb.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */