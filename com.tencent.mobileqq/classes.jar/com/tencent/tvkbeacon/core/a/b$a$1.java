package com.tencent.tvkbeacon.core.a;

import com.tencent.tvkbeacon.core.c.h;

final class b$a$1
  implements Runnable
{
  b$a$1(b.a parama, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      h.a(localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */