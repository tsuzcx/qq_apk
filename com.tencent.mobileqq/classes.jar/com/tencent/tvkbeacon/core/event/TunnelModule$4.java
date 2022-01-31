package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;

final class TunnelModule$4
  implements Runnable
{
  TunnelModule$4(TunnelModule paramTunnelModule) {}
  
  public final void run()
  {
    c.b("[net] db events to up on netConnectChange", new Object[0]);
    try
    {
      TunnelModule.doUploadRecentCommonData(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.TunnelModule.4
 * JD-Core Version:    0.7.0.1
 */