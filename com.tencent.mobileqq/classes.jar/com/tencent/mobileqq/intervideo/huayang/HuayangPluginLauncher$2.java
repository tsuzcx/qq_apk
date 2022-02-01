package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import android.os.Message;
import anzj;
import awbd;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(awbd paramawbd, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (awbd.a(this.this$0) == null)
    {
      awbd.a(this.this$0, awbd.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - awbd.a(this.this$0));
        if (l > 0L) {
          awbd.a(this.this$0, "HuayangPluginLauncher", anzj.a(2131704550) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((awbd.a(this.this$0) != null) && (awbd.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(awbd.a(this.this$0), 2);
          awbd.a(this.this$0).sendMessage(localMessage);
          awbd.a(this.this$0, awbd.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        awbd.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        awbd.b(this.this$0, awbd.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */