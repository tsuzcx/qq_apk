package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.g.1
 * JD-Core Version:    0.7.0.1
 */