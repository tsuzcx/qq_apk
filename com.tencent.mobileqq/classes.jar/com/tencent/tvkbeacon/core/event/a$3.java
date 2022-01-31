package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;

final class a$3
  implements Runnable
{
  a$3(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    c.f(a.a(this.b, "[event] -> do sync db and upload task."), new Object[0]);
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.a.3
 * JD-Core Version:    0.7.0.1
 */