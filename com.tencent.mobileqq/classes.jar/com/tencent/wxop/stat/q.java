package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.d;
import com.tencent.wxop.stat.event.h;

final class q
  implements Runnable
{
  q(Context paramContext, Throwable paramThrowable) {}
  
  public final void run()
  {
    try
    {
      if (!StatConfig.isEnableStatService()) {
        return;
      }
      new aq(new d(this.a, StatServiceImpl.a(this.a, false, null), 99, this.b, h.a)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e("reportSdkSelfException error: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.q
 * JD-Core Version:    0.7.0.1
 */