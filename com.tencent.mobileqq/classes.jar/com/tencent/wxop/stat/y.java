package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.c;
import java.util.Map;

final class y
  implements Runnable
{
  y(String paramString, c paramc, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      if (StatServiceImpl.a(this.a))
      {
        StatServiceImpl.f().error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        return;
      }
      if (StatConfig.isDebugEnable()) {
        StatServiceImpl.f().i("add begin key:" + this.b);
      }
      if (StatServiceImpl.k().containsKey(this.b))
      {
        StatServiceImpl.f().warn("Duplicate CustomEvent key: " + this.b.toString() + ", trackCustomBeginKVEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.c, localThrowable);
      return;
    }
    if (StatServiceImpl.k().size() <= StatConfig.getMaxParallelTimmingEvents())
    {
      StatServiceImpl.k().put(this.b, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    StatServiceImpl.f().error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.y
 * JD-Core Version:    0.7.0.1
 */