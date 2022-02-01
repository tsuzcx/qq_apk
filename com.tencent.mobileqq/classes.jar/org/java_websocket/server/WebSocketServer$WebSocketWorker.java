package org.java_websocket.server;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.WebSocketImpl;

public class WebSocketServer$WebSocketWorker
  extends Thread
{
  private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();
  
  public WebSocketServer$WebSocketWorker(WebSocketServer paramWebSocketServer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketWorker-");
    localStringBuilder.append(getId());
    setName(localStringBuilder.toString());
    setUncaughtExceptionHandler(new WebSocketServer.WebSocketWorker.1(this, paramWebSocketServer));
  }
  
  /* Error */
  private void doDecode(WebSocketImpl paramWebSocketImpl, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokevirtual 69	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   5: aload_0
    //   6: getfield 19	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
    //   9: aload_2
    //   10: invokestatic 75	org/java_websocket/server/WebSocketServer:access$200	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
    //   13: return
    //   14: astore_1
    //   15: goto +18 -> 33
    //   18: astore_1
    //   19: invokestatic 79	org/java_websocket/server/WebSocketServer:access$000	()Lorg/slf4j/Logger;
    //   22: ldc 81
    //   24: aload_1
    //   25: invokeinterface 87 3 0
    //   30: goto -25 -> 5
    //   33: aload_0
    //   34: getfield 19	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
    //   37: aload_2
    //   38: invokestatic 75	org/java_websocket/server/WebSocketServer:access$200	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
    //   41: goto +5 -> 46
    //   44: aload_1
    //   45: athrow
    //   46: goto -2 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	WebSocketWorker
    //   0	49	1	paramWebSocketImpl	WebSocketImpl
    //   0	49	2	paramByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	5	14	finally
    //   19	30	14	finally
    //   0	5	18	java/lang/Exception
  }
  
  public void put(WebSocketImpl paramWebSocketImpl)
  {
    this.iqueue.put(paramWebSocketImpl);
  }
  
  public void run()
  {
    try
    {
      try
      {
        WebSocketImpl localWebSocketImpl;
        for (;;)
        {
          localWebSocketImpl = (WebSocketImpl)this.iqueue.take();
          try
          {
            doDecode(localWebSocketImpl, (ByteBuffer)localWebSocketImpl.inQueue.poll());
          }
          catch (RuntimeException localRuntimeException1) {}
        }
        WebSocketServer.access$100(this.this$0, localWebSocketImpl, localRuntimeException2);
      }
      catch (RuntimeException localRuntimeException2)
      {
        localWebSocketImpl = null;
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label50:
      break label50;
    }
    Thread.currentThread().interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer.WebSocketWorker
 * JD-Core Version:    0.7.0.1
 */