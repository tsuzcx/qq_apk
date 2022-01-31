package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;

class TrafficIOStreamHandlerManager$DefaultTrafficInputStreamHandler$DumpInputStreamTask
  implements Runnable
{
  AtomicLong atomicLong = new AtomicLong();
  
  TrafficIOStreamHandlerManager$DefaultTrafficInputStreamHandler$DumpInputStreamTask(TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler paramDefaultTrafficInputStreamHandler) {}
  
  DumpInputStreamTask acquire(int paramInt)
  {
    this.atomicLong.getAndAdd(paramInt);
    return this;
  }
  
  public void run()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "[", TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler.access$200(this.this$0), "] <=== read ", String.valueOf(this.atomicLong.getAndSet(0L)), " bytes" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler.DumpInputStreamTask
 * JD-Core Version:    0.7.0.1
 */