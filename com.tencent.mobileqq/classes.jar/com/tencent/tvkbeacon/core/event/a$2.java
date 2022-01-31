package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    c.f(a.a(this.a, "[event] -> do max size upload task."), new Object[0]);
    try
    {
      a.a(this.a).b(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.a.2
 * JD-Core Version:    0.7.0.1
 */