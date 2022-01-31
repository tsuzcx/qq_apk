package com.tencent.tvkbeacon.event;

import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.event.TunnelModule;

final class UserAction$2
  implements Runnable
{
  public final void run()
  {
    c.b("[core] db events to up on app call", new Object[0]);
    try
    {
      TunnelModule.doUploadAllEventsData();
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.event.UserAction.2
 * JD-Core Version:    0.7.0.1
 */