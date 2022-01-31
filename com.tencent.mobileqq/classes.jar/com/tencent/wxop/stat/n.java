package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;

final class n
  implements Runnable
{
  n(Context paramContext) {}
  
  public final void run()
  {
    if (this.a == null) {
      StatServiceImpl.f().error("The Context of StatService.onStop() can not be null!");
    }
    for (;;)
    {
      return;
      StatServiceImpl.flushDataToDB(this.a);
      if (StatServiceImpl.a()) {
        continue;
      }
      try
      {
        Thread.sleep(100L);
        if (!l.z(this.a)) {
          continue;
        }
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("onStop isBackgroundRunning flushDataToDB");
        }
        StatServiceImpl.commitEvents(this.a, -1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.n
 * JD-Core Version:    0.7.0.1
 */