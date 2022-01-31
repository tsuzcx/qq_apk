package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    c.f(i.a(this.a, "[realtime event] -> do sync upload task."), new Object[0]);
    try
    {
      this.a.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.i.1
 * JD-Core Version:    0.7.0.1
 */