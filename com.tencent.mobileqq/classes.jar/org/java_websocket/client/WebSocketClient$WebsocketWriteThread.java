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
      if (WebSocketClient.access$400(this.this$0) != null)
      {
        WebSocketClient.access$400(this.this$0).close();
        return;
      }
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
        localObject = (ByteBuffer)WebSocketClient.access$200(this.this$0).outQueue.take();
        WebSocketClient.access$300(this.this$0).write(((ByteBuffer)localObject).array(), 0, ((ByteBuffer)localObject).limit());
        WebSocketClient.access$300(this.this$0).flush();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Object localObject;
      label57:
      break label57;
    }
    localObject = WebSocketClient.access$200(this.this$0).outQueue.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ByteBuffer localByteBuffer = (ByteBuffer)((Iterator)localObject).next();
      WebSocketClient.access$300(this.this$0).write(localByteBuffer.array(), 0, localByteBuffer.limit());
      WebSocketClient.access$300(this.this$0).flush();
    }
    Thread.currentThread().interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore_1
    //   4: new 107	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 110
    //   15: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_2
    //   20: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 118	java/lang/Thread:getId	()J
    //   26: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 129	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokespecial 131	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:runWriteData	()V
    //   42: aload_0
    //   43: invokespecial 133	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:closeSocket	()V
    //   46: aload_0
    //   47: getfield 13	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:this$0	Lorg/java_websocket/client/WebSocketClient;
    //   50: aconst_null
    //   51: invokestatic 137	org/java_websocket/client/WebSocketClient:access$102	(Lorg/java_websocket/client/WebSocketClient;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   54: pop
    //   55: return
    //   56: astore_1
    //   57: goto +15 -> 72
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 13	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:this$0	Lorg/java_websocket/client/WebSocketClient;
    //   65: aload_1
    //   66: invokestatic 141	org/java_websocket/client/WebSocketClient:access$000	(Lorg/java_websocket/client/WebSocketClient;Ljava/io/IOException;)V
    //   69: goto -27 -> 42
    //   72: aload_0
    //   73: invokespecial 133	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:closeSocket	()V
    //   76: aload_0
    //   77: getfield 13	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:this$0	Lorg/java_websocket/client/WebSocketClient;
    //   80: aconst_null
    //   81: invokestatic 137	org/java_websocket/client/WebSocketClient:access$102	(Lorg/java_websocket/client/WebSocketClient;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   84: pop
    //   85: goto +5 -> 90
    //   88: aload_1
    //   89: athrow
    //   90: goto -2 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	WebsocketWriteThread
    //   3	28	1	localThread	Thread
    //   56	1	1	localObject	Object
    //   60	29	1	localIOException	IOException
    //   11	21	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	42	56	finally
    //   61	69	56	finally
    //   38	42	60	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.client.WebSocketClient.WebsocketWriteThread
 * JD-Core Version:    0.7.0.1
 */