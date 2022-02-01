package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 1, 16})
public final class RealBufferedSink
  implements BufferedSink
{
  @JvmField
  @NotNull
  public final Buffer bufferField;
  @JvmField
  public boolean closed;
  @JvmField
  @NotNull
  public final Sink sink;
  
  public RealBufferedSink(@NotNull Sink paramSink)
  {
    this.sink = paramSink;
    this.bufferField = new Buffer();
  }
  
  @NotNull
  public Buffer buffer()
  {
    return this.bufferField;
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    Object localObject2 = (Throwable)null;
    Object localObject1 = localObject2;
    try
    {
      if (this.bufferField.size() > 0L)
      {
        this.sink.write(this.bufferField, this.bufferField.size());
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
    if (localObject2 == null) {
      return;
    }
    throw ((Throwable)localObject2);
  }
  
  @NotNull
  public BufferedSink emit()
  {
    if ((this.closed ^ true))
    {
      long l = this.bufferField.size();
      if (l > 0L) {
        this.sink.write(this.bufferField, l);
      }
      return (BufferedSink)this;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink emitCompleteSegments()
  {
    if ((this.closed ^ true))
    {
      long l = this.bufferField.completeSegmentByteCount();
      if (l > 0L) {
        this.sink.write(this.bufferField, l);
      }
      return (BufferedSink)this;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public void flush()
  {
    if ((this.closed ^ true))
    {
      if (this.bufferField.size() > 0L)
      {
        Sink localSink = this.sink;
        Buffer localBuffer = this.bufferField;
        localSink.write(localBuffer, localBuffer.size());
      }
      this.sink.flush();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public Buffer getBuffer()
  {
    return this.bufferField;
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  @NotNull
  public OutputStream outputStream()
  {
    return (OutputStream)new RealBufferedSink.outputStream.1(this);
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public int write(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "source");
    if ((this.closed ^ true))
    {
      int i = this.bufferField.write(paramByteBuffer);
      emitCompleteSegments();
      return i;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink write(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((this.closed ^ true))
    {
      this.bufferField.write(paramByteString);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink write(@NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((this.closed ^ true))
    {
      this.bufferField.write(paramByteString, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink write(@NotNull Source paramSource, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(this.bufferField, paramLong);
      if (l != -1L)
      {
        paramLong -= l;
        emitCompleteSegments();
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
    return (BufferedSink)this;
  }
  
  @NotNull
  public BufferedSink write(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((this.closed ^ true))
    {
      this.bufferField.write(paramArrayOfByte);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink write(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((this.closed ^ true))
    {
      this.bufferField.write(paramArrayOfByte, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    if ((this.closed ^ true))
    {
      this.bufferField.write(paramBuffer, paramLong);
      emitCompleteSegments();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public long writeAll(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramSource.read(this.bufferField, 8192);
      if (l2 == -1L) {
        return l1;
      }
      l1 += l2;
      emitCompleteSegments();
    }
  }
  
  @NotNull
  public BufferedSink writeByte(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeByte(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeDecimalLong(long paramLong)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeDecimalLong(paramLong);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeHexadecimalUnsignedLong(long paramLong)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeHexadecimalUnsignedLong(paramLong);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeInt(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeInt(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeIntLe(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeIntLe(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeLong(long paramLong)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeLong(paramLong);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeLongLe(long paramLong)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeLongLe(paramLong);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeShort(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeShort(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeShortLe(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeShortLe(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeString(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    if ((this.closed ^ true))
    {
      this.bufferField.writeString(paramString, paramInt1, paramInt2, paramCharset);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeString(@NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    if ((this.closed ^ true))
    {
      this.bufferField.writeString(paramString, paramCharset);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeUtf8(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((this.closed ^ true))
    {
      this.bufferField.writeUtf8(paramString);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeUtf8(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((this.closed ^ true))
    {
      this.bufferField.writeUtf8(paramString, paramInt1, paramInt2);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public BufferedSink writeUtf8CodePoint(int paramInt)
  {
    if ((this.closed ^ true))
    {
      this.bufferField.writeUtf8CodePoint(paramInt);
      return emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.RealBufferedSink
 * JD-Core Version:    0.7.0.1
 */