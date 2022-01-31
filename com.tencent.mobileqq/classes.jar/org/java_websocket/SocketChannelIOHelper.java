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
    if (paramWebSocketImpl == null) {
      return false;
    }
    Object localObject2 = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (!(paramByteChannel instanceof WrappedByteChannel)) {
        break label184;
      }
      localObject2 = (WrappedByteChannel)paramByteChannel;
      localObject1 = localObject2;
      if (((WrappedByteChannel)localObject2).isNeedWrite())
      {
        ((WrappedByteChannel)localObject2).writeMore();
        localObject1 = localObject2;
      }
      label64:
      if ((paramWebSocketImpl.outQueue.isEmpty()) && (paramWebSocketImpl.isFlushAndClose()) && (paramWebSocketImpl.getDraft() != null) && (paramWebSocketImpl.getDraft().getRole() != null) && (paramWebSocketImpl.getDraft().getRole() == Role.SERVER)) {
        paramWebSocketImpl.closeConnection();
      }
      if ((localObject1 != null) && (((WrappedByteChannel)paramByteChannel).isNeedWrite())) {
        break label189;
      }
    }
    label184:
    label189:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      do
      {
        paramByteChannel.write(localObject1);
        if (localObject1.remaining() > 0) {
          break;
        }
        paramWebSocketImpl.outQueue.poll();
        localObject2 = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = null;
      break label64;
    }
  }
  
  public static boolean read(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
  {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1) {
      paramWebSocketImpl.eot();
    }
    while (i == 0) {
      return false;
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.SocketChannelIOHelper
 * JD-Core Version:    0.7.0.1
 */