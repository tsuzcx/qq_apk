package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.concurrent.BlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.enums.Role;

public class SocketChannelIOHelper
{
  private SocketChannelIOHelper()
  {
    throw new IllegalStateException("Utility class");
  }
  
  public static boolean batch(WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
  {
    boolean bool = false;
    if (paramWebSocketImpl == null) {
      return false;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
    WrappedByteChannel localWrappedByteChannel = null;
    Object localObject = localByteBuffer;
    if (localByteBuffer == null)
    {
      localObject = localWrappedByteChannel;
      if ((paramByteChannel instanceof WrappedByteChannel))
      {
        localWrappedByteChannel = (WrappedByteChannel)paramByteChannel;
        localObject = localWrappedByteChannel;
        if (localWrappedByteChannel.isNeedWrite())
        {
          localWrappedByteChannel.writeMore();
          localObject = localWrappedByteChannel;
        }
      }
    }
    else
    {
      do
      {
        paramByteChannel.write((ByteBuffer)localObject);
        if (((ByteBuffer)localObject).remaining() > 0) {
          return false;
        }
        paramWebSocketImpl.outQueue.poll();
        localByteBuffer = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
        localObject = localByteBuffer;
      } while (localByteBuffer != null);
      localObject = localWrappedByteChannel;
    }
    if ((paramWebSocketImpl.outQueue.isEmpty()) && (paramWebSocketImpl.isFlushAndClose()) && (paramWebSocketImpl.getDraft() != null) && (paramWebSocketImpl.getDraft().getRole() != null) && (paramWebSocketImpl.getDraft().getRole() == Role.SERVER)) {
      paramWebSocketImpl.closeConnection();
    }
    if ((localObject == null) || (!((WrappedByteChannel)paramByteChannel).isNeedWrite())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean read(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
  {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    boolean bool = false;
    if (i == -1)
    {
      paramWebSocketImpl.eot();
      return false;
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean readMore(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, WrappedByteChannel paramWrappedByteChannel)
  {
    paramByteBuffer.clear();
    int i = paramWrappedByteChannel.readMore(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1)
    {
      paramWebSocketImpl.eot();
      return false;
    }
    return paramWrappedByteChannel.isNeedRead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.SocketChannelIOHelper
 * JD-Core Version:    0.7.0.1
 */