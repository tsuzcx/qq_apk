package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class RealBufferedSink
  implements BufferedSink
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Sink sink;
  
  RealBufferedSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      this.sink = paramSink;
      return;
    }
    throw new NullPointerException("sink == null");
  }
  
  public Buffer buffer()
  {
    return this.buffer;
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.buffer.size > 0L)
      {
        this.sink.write(this.buffer, this.buffer.size);
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable1) {}
    try
    {
      this.sink.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    this.closed = true;
    if (localObject2 != null) {
      Util.sneakyRethrow(localObject2);
    }
  }
  
  public BufferedSink emit()
  {
    if (!this.closed)
    {
      long l = this.buffer.size();
      if (l > 0L) {
        this.sink.write(this.buffer, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink emitCompleteSegments()
  {
    if (!this.closed)
    {
      long l = this.buffer.completeSegmentByteCount();
      if (l > 0L) {
        this.sink.write(this.buffer, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public void flush()
  {
    if (!this.closed)
    {
      if (this.buffer.size > 0L)
      {
        Sink localSink = this.sink;
        Buffer localBuffer = this.buffer;
        localSink.write(localBuffer, localBuffer.size);
      }
      this.sink.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  public OutputStream outputStream()
  {
    return new RealBufferedSink.1(this);
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (!this.closed)
    {
      int i = this.buffer.write(paramByteBuffer);
      emitCompleteSegments();
      return i;
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(ByteString paramByteString)
  {
    if (!this.closed)
    {
      this.buffer.write(paramByteString);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
  {
    while (paramLong > 0L)
    {
      long l = paramSource.read(this.buffer, paramLong);
      if (l != -1L)
      {
        paramLong -= l;
        emitCompleteSegments();
      }
      else
      {
        throw new EOFException();
      }
    }
    return this;
  }
  
  public BufferedSink write(byte[] paramArrayOfByte)
  {
    if (!this.closed)
    {
      this.buffer.write(paramArrayOfByte);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.closed)
    {
      this.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (!this.closed)
    {
      this.buffer.write(paramBuffer, paramLong);
      emitCompleteSegments();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public long writeAll(Source paramSource)
  {
    if (paramSource != null)
    {
      long l1 = 0L;
      for (;;)
      {
        long l2 = paramSource.read(this.buffer, 8192L);
        if (l2 == -1L) {
          break;
        }
        l1 += l2;
        emitCompleteSegments();
      }
      return l1;
    }
    paramSource = new IllegalArgumentException("source == null");
    for (;;)
    {
      throw paramSource;
    }
  }
  
  public BufferedSink writeByte(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeByte(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeDecimalLong(long paramLong)
  {
    if (!this.closed)
    {
      this.buffer.writeDecimalLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeHexadecimalUnsignedLong(long paramLong)
  {
    if (!this.closed)
    {
      this.buffer.writeHexadecimalUnsignedLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeInt(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeInt(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeIntLe(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeIntLe(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeLong(long paramLong)
  {
    if (!this.closed)
    {
      this.buffer.writeLong(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeLongLe(long paramLong)
  {
    if (!this.closed)
    {
      this.buffer.writeLongLe(paramLong);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeShort(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeShort(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeShortLe(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeShortLe(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (!this.closed)
    {
      this.buffer.writeString(paramString, paramInt1, paramInt2, paramCharset);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeString(String paramString, Charset paramCharset)
  {
    if (!this.closed)
    {
      this.buffer.writeString(paramString, paramCharset);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8(String paramString)
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8(paramString);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8(paramString, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
  
  public BufferedSink writeUtf8CodePoint(int paramInt)
  {
    if (!this.closed)
    {
      this.buffer.writeUtf8CodePoint(paramInt);
      return emitCompleteSegments();
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.RealBufferedSink
 * JD-Core Version:    0.7.0.1
 */