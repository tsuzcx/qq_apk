package com.tencent.mobileqq.intervideo.huayang;

import ajyc;
import android.os.Handler;
import android.os.Message;
import argc;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(argc paramargc, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (argc.a(this.this$0) == null)
    {
      argc.a(this.this$0, argc.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - argc.a(this.this$0));
        if (l > 0L) {
          argc.a(this.this$0, "HuayangPluginLauncher", ajyc.a(2131705647) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((argc.a(this.this$0) != null) && (argc.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(argc.a(this.this$0), 2);
          argc.a(this.this$0).sendMessage(localMessage);
          argc.a(this.this$0, argc.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        argc.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        argc.b(this.this$0, argc.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */