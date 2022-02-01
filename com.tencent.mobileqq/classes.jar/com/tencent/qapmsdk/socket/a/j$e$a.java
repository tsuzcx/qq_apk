package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;

class j$e$a
  implements Runnable
{
  AtomicLong a = new AtomicLong();
  
  j$e$a(j.e parame) {}
  
  a a(int paramInt)
  {
    this.a.getAndAdd(paramInt);
    return this;
  }
  
  public void run()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "[", j.e.a(this.b), "] ===> write ", String.valueOf(this.a.getAndSet(0L)), " bytes" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.e.a
 * JD-Core Version:    0.7.0.1
 */