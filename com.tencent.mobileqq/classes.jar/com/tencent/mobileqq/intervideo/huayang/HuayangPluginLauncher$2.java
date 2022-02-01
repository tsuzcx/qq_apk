package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;

class HuayangPluginLauncher$2
  implements Runnable
{
  HuayangPluginLauncher$2(HuayangPluginLauncher paramHuayangPluginLauncher, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (HuayangPluginLauncher.a(this.this$0) == null)
    {
      HuayangPluginLauncher.a(this.this$0, HuayangPluginLauncher.b(this.this$0));
      if (this.a)
      {
        l = 1000L - (System.currentTimeMillis() - HuayangPluginLauncher.a(this.this$0));
        if (l > 0L) {
          HuayangPluginLauncher.a(this.this$0, "HuayangPluginLauncher", HardCodeUtil.a(2131705674) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((HuayangPluginLauncher.a(this.this$0) != null) && (HuayangPluginLauncher.a(this.this$0)))
      {
        if (this.a)
        {
          Message localMessage = Message.obtain(HuayangPluginLauncher.a(this.this$0), 2);
          HuayangPluginLauncher.a(this.this$0).sendMessage(localMessage);
          HuayangPluginLauncher.a(this.this$0, HuayangPluginLauncher.a(this.this$0));
          this.this$0.a = true;
        }
      }
      else
      {
        HuayangPluginLauncher.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        HuayangPluginLauncher.b(this.this$0, HuayangPluginLauncher.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */