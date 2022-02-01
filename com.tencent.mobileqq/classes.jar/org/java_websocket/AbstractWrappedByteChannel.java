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
    if ((this.channel instanceof SocketChannel)) {
      return ((SocketChannel)this.channel).isBlocking();
    }
    if ((this.channel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)this.channel).isBlocking();
    }
    return false;
  }
  
  public boolean isNeedRead()
  {
    return ((this.channel instanceof WrappedByteChannel)) && (((WrappedByteChannel)this.channel).isNeedRead());
  }
  
  public boolean isNeedWrite()
  {
    return ((this.channel instanceof WrappedByteChannel)) && (((WrappedByteChannel)this.channel).isNeedWrite());
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
    if ((this.channel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)this.channel).readMore(paramByteBuffer);
    }
    return 0;
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    return this.channel.write(paramByteBuffer);
  }
  
  public void writeMore()
  {
    if ((this.channel instanceof WrappedByteChannel)) {
      ((WrappedByteChannel)this.channel).writeMore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.AbstractWrappedByteChannel
 * JD-Core Version:    0.7.0.1
 */