package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;

class j$c$a
  implements Runnable
{
  AtomicLong a = new AtomicLong();
  
  j$c$a(j.c paramc) {}
  
  a a(int paramInt)
  {
    this.a.getAndAdd(paramInt);
    return this;
  }
  
  public void run()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "[", j.c.a(this.b), "] <=== read ", String.valueOf(this.a.getAndSet(0L)), " bytes" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.c.a
 * JD-Core Version:    0.7.0.1
 */