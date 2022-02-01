package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k=2, mv={1, 1, 16})
public final class RealBufferedSinkKt
{
  public static final void commonClose(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonClose");
    if (paramRealBufferedSink.closed) {
      return;
    }
    Object localObject2 = (Throwable)null;
    Object localObject1 = localObject2;
    try
    {
      if (paramRealBufferedSink.bufferField.size() > 0L)
      {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, paramRealBufferedSink.bufferField.size());
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable1) {}
    try
    {
      paramRealBufferedSink.sink.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    paramRealBufferedSink.closed = true;
    if (localObject2 == null) {
      return;
    }
    throw ((Throwable)localObject2);
  }
  
  @NotNull
  public static final BufferedSink commonEmit(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonEmit");
    if ((paramRealBufferedSink.closed ^ true))
    {
      long l = paramRealBufferedSink.bufferField.size();
      if (l > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, l);
      }
      return (BufferedSink)paramRealBufferedSink;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonEmitCompleteSegments");
    if ((paramRealBufferedSink.closed ^ true))
    {
      long l = paramRealBufferedSink.bufferField.completeSegmentByteCount();
      if (l > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, l);
      }
      return (BufferedSink)paramRealBufferedSink;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final void commonFlush(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonFlush");
    if ((paramRealBufferedSink.closed ^ true))
    {
      if (paramRealBufferedSink.bufferField.size() > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, paramRealBufferedSink.bufferField.size());
      }
      paramRealBufferedSink.sink.flush();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final Timeout commonTimeout(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonTimeout");
    return paramRealBufferedSink.sink.timeout();
  }
  
  @NotNull
  public static final String commonToString(@NotNull RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonToString");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(paramRealBufferedSink.sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static final BufferedSink commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramByteString);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramByteString, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull Source paramSource, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(paramRealBufferedSink.bufferField, paramLong);
      if (l != -1L)
      {
        paramLong -= l;
        paramRealBufferedSink.emitCompleteSegments();
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
    return (BufferedSink)paramRealBufferedSink;
  }
  
  @NotNull
  public static final BufferedSink commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramArrayOfByte);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramArrayOfByte, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final void commonWrite(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramBuffer, paramLong);
      paramRealBufferedSink.emitCompleteSegments();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final long commonWriteAll(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteAll");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramSource.read(paramRealBufferedSink.bufferField, 8192);
      if (l2 == -1L) {
        return l1;
      }
      l1 += l2;
      paramRealBufferedSink.emitCompleteSegments();
    }
  }
  
  @NotNull
  public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteByte");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeByte(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteDecimalLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeDecimalLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeHexadecimalUnsignedLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteInt");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeInt(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteIntLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeIntLe(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteLongLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeLongLe(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteShort");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeShort(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteShortLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeShortLe(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8(paramString);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink paramRealBufferedSink, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8(paramString, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8CodePoint");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8CodePoint(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.internal.RealBufferedSinkKt
 * JD-Core Version:    0.7.0.1
 */