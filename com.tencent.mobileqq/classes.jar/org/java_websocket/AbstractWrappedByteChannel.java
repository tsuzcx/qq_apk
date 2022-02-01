package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

@Deprecated
public class AbstractWrappedByteChannel
  implements WrappedByteChannel
{
  private final ByteChannel channel;
  
  @Deprecated
  public AbstractWrappedByteChannel(ByteChannel paramByteChannel)
  {
    this.channel = paramByteChannel;
  }
  
  @Deprecated
  public AbstractWrappedByteChannel(WrappedByteChannel paramWrappedByteChannel)
  {
    this.channel = paramWrappedByteChannel;
  }
  
  public void close()
  {
    this.channel.close();
  }
  
  public boolean isBlocking()
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof SocketChannel)) {
      return ((SocketChannel)localByteChannel).isBlocking();
    }
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).isBlocking();
    }
    return false;
  }
  
  public boolean isNeedRead()
  {
    ByteChannel localByteChannel = this.channel;
    return ((localByteChannel instanceof WrappedByteChannel)) && (((WrappedByteChannel)localByteChannel).isNeedRead());
  }
  
  public boolean isNeedWrite()
  {
    ByteChannel localByteChannel = this.channel;
    return ((localByteChannel instanceof WrappedByteChannel)) && (((WrappedByteChannel)localByteChannel).isNeedWrite());
  }
  
  public boolean isOpen()
  {
    return this.channel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    return this.channel.read(paramByteBuffer);
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).readMore(paramByteBuffer);
    }
    return 0;
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    return this.channel.write(paramByteBuffer);
  }
  
  public void writeMore()
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      ((WrappedByteChannel)localByteChannel).writeMore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.AbstractWrappedByteChannel
 * JD-Core Version:    0.7.0.1
 */