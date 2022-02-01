package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import android.os.Message;
import anni;
import aviv;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(aviv paramaviv, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (aviv.a(this.this$0) == null)
    {
      aviv.a(this.this$0, aviv.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - aviv.a(this.this$0));
        if (l > 0L) {
          aviv.a(this.this$0, "HuayangPluginLauncher", anni.a(2131704443) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((aviv.a(this.this$0) != null) && (aviv.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(aviv.a(this.this$0), 2);
          aviv.a(this.this$0).sendMessage(localMessage);
          aviv.a(this.this$0, aviv.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        aviv.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        aviv.b(this.this$0, aviv.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */