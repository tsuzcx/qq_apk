package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;

class TrafficIOStreamHandlerManager$DefaultTrafficOutputStreamHandler$DumpOutputStreamTask
  implements Runnable
{
  AtomicLong atomicLong = new AtomicLong();
  
  TrafficIOStreamHandlerManager$DefaultTrafficOutputStreamHandler$DumpOutputStreamTask(TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler paramDefaultTrafficOutputStreamHandler) {}
  
  DumpOutputStreamTask acquire(int paramInt)
  {
    this.atomicLong.getAndAdd(paramInt);
    return this;
  }
  
  public void run()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "[", TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler.access$400(this.this$0), "] ===> write ", String.valueOf(this.atomicLong.getAndSet(0L)), " bytes" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler.DumpOutputStreamTask
 * JD-Core Version:    0.7.0.1
 */