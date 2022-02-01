package org.java_websocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import org.java_websocket.WebSocketImpl;

class WebSocketClient$WebsocketWriteThread
  implements Runnable
{
  private final WebSocketClient webSocketClient;
  
  WebSocketClient$WebsocketWriteThread(WebSocketClient paramWebSocketClient1, WebSocketClient paramWebSocketClient2)
  {
    this.webSocketClient = paramWebSocketClient2;
  }
  
  private void closeSocket()
  {
    try
    {
      if (WebSocketClient.access$400(this.this$0) != null) {
        WebSocketClient.access$400(this.this$0).close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.this$0.onWebsocketError(this.webSocketClient, localIOException);
    }
  }
  
  private void runWriteData()
  {
    try
    {
      while (!Thread.interrupted())
      {
        ByteBuffer localByteBuffer1 = (ByteBuffer)WebSocketClient.access$200(this.this$0).outQueue.take();
        WebSocketClient.access$300(this.this$0).write(localByteBuffer1.array(), 0, localByteBuffer1.limit());
        WebSocketClient.access$300(this.this$0).flush();
      }
      Iterator localIterator;
      ByteBuffer localByteBuffer2;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localIterator = WebSocketClient.access$200(this.this$0).outQueue.iterator();
      while (localIterator.hasNext())
      {
        localByteBuffer2 = (ByteBuffer)localIterator.next();
        WebSocketClient.access$300(this.this$0).write(localByteBuffer2.array(), 0, localByteBuffer2.limit());
        WebSocketClient.access$300(this.this$0).flush();
      }
      Thread.currentThread().interrupt();
    }
  }
  
  public void run()
  {
    Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
    try
    {
      runWriteData();
      return;
    }
    catch (IOException localIOException)
    {
      WebSocketClient.access$000(this.this$0, localIOException);
      return;
    }
    finally
    {
      closeSocket();
      WebSocketClient.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.client.WebSocketClient.WebsocketWriteThread
 * JD-Core Version:    0.7.0.1
 */