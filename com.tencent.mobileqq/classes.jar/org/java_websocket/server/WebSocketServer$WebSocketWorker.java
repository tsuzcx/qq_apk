package org.java_websocket.server;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.WebSocketImpl;
import org.slf4j.Logger;

public class WebSocketServer$WebSocketWorker
  extends Thread
{
  private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();
  
  static
  {
    if (!WebSocketServer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WebSocketServer$WebSocketWorker(WebSocketServer paramWebSocketServer)
  {
    setName("WebSocketWorker-" + getId());
    setUncaughtExceptionHandler(new WebSocketServer.WebSocketWorker.1(this, paramWebSocketServer));
  }
  
  private void doDecode(WebSocketImpl paramWebSocketImpl, ByteBuffer paramByteBuffer)
  {
    try
    {
      paramWebSocketImpl.decode(paramByteBuffer);
      return;
    }
    catch (Exception paramWebSocketImpl)
    {
      WebSocketServer.access$000().error("Error while reading from remote connection", paramWebSocketImpl);
      return;
    }
    finally
    {
      WebSocketServer.access$200(this.this$0, paramByteBuffer);
    }
  }
  
  public void put(WebSocketImpl paramWebSocketImpl)
  {
    this.iqueue.put(paramWebSocketImpl);
  }
  
  public void run()
  {
    try
    {
      localWebSocketImpl = (WebSocketImpl)this.iqueue.take();
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        WebSocketImpl localWebSocketImpl;
        ByteBuffer localByteBuffer = (ByteBuffer)localWebSocketImpl.inQueue.poll();
        if ((!$assertionsDisabled) && (localByteBuffer == null))
        {
          throw new AssertionError();
          localInterruptedException = localInterruptedException;
          Thread.currentThread().interrupt();
          return;
        }
        doDecode(localInterruptedException, localByteBuffer);
      }
      catch (RuntimeException localRuntimeException1) {}
      WebSocketServer.access$100(this.this$0, localInterruptedException, localRuntimeException1);
      return;
    }
    catch (RuntimeException localRuntimeException2)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer.WebSocketWorker
 * JD-Core Version:    0.7.0.1
 */