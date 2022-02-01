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
    if (HuayangPluginLauncher.access$400(this.this$0) == null)
    {
      HuayangPluginLauncher localHuayangPluginLauncher = this.this$0;
      HuayangPluginLauncher.access$402(localHuayangPluginLauncher, HuayangPluginLauncher.access$500(localHuayangPluginLauncher));
      if (this.a)
      {
        long l = 1000L - (System.currentTimeMillis() - HuayangPluginLauncher.access$600(this.this$0));
        if (l > 0L)
        {
          localHuayangPluginLauncher = this.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131903625));
          localStringBuilder.append(l);
          HuayangPluginLauncher.access$700(localHuayangPluginLauncher, "HuayangPluginLauncher", localStringBuilder.toString());
          try
          {
            Thread.sleep(l);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if ((HuayangPluginLauncher.access$400(this.this$0) != null) && (HuayangPluginLauncher.access$800(this.this$0)))
    {
      Object localObject;
      if (this.a)
      {
        localObject = Message.obtain(HuayangPluginLauncher.access$900(this.this$0), 2);
        HuayangPluginLauncher.access$900(this.this$0).sendMessage((Message)localObject);
        localObject = this.this$0;
        HuayangPluginLauncher.access$1000((HuayangPluginLauncher)localObject, HuayangPluginLauncher.access$400((HuayangPluginLauncher)localObject));
        this.this$0.mStartActivityCalled = true;
      }
      else
      {
        localObject = this.this$0;
        HuayangPluginLauncher.access$1100((HuayangPluginLauncher)localObject, HuayangPluginLauncher.access$400((HuayangPluginLauncher)localObject));
      }
    }
    HuayangPluginLauncher.access$1202(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */