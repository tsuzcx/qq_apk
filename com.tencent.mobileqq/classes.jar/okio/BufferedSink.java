package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "emit", "emitCompleteSegments", "flush", "", "outputStream", "Ljava/io/OutputStream;", "write", "source", "", "offset", "", "byteCount", "byteString", "Lokio/ByteString;", "Lokio/Source;", "", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 1, 16})
public abstract interface BufferedSink
  extends WritableByteChannel, Sink
{
  @Deprecated(level=DeprecationLevel.WARNING, message="moved to val: use getBuffer() instead", replaceWith=@ReplaceWith(expression="buffer", imports={}))
  @NotNull
  public abstract Buffer buffer();
  
  @NotNull
  public abstract BufferedSink emit();
  
  @NotNull
  public abstract BufferedSink emitCompleteSegments();
  
  public abstract void flush();
  
  @NotNull
  public abstract Buffer getBuffer();
  
  @NotNull
  public abstract OutputStream outputStream();
  
  @NotNull
  public abstract BufferedSink write(@NotNull ByteString paramByteString);
  
  @NotNull
  public abstract BufferedSink write(@NotNull ByteString paramByteString, int paramInt1, int paramInt2);
  
  @NotNull
  public abstract BufferedSink write(@NotNull Source paramSource, long paramLong);
  
  @NotNull
  public abstract BufferedSink write(@NotNull byte[] paramArrayOfByte);
  
  @NotNull
  public abstract BufferedSink write(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract long writeAll(@NotNull Source paramSource);
  
  @NotNull
  public abstract BufferedSink writeByte(int paramInt);
  
  @NotNull
  public abstract BufferedSink writeDecimalLong(long paramLong);
  
  @NotNull
  public abstract BufferedSink writeHexadecimalUnsignedLong(long paramLong);
  
  @NotNull
  public abstract BufferedSink writeInt(int paramInt);
  
  @NotNull
  public abstract BufferedSink writeIntLe(int paramInt);
  
  @NotNull
  public abstract BufferedSink writeLong(long paramLong);
  
  @NotNull
  public abstract BufferedSink writeLongLe(long paramLong);
  
  @NotNull
  public abstract BufferedSink writeShort(int paramInt);
  
  @NotNull
  public abstract BufferedSink writeShortLe(int paramInt);
  
  @NotNull
  public abstract BufferedSink writeString(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Charset paramCharset);
  
  @NotNull
  public abstract BufferedSink writeString(@NotNull String paramString, @NotNull Charset paramCharset);
  
  @NotNull
  public abstract BufferedSink writeUtf8(@NotNull String paramString);
  
  @NotNull
  public abstract BufferedSink writeUtf8(@NotNull String paramString, int paramInt1, int paramInt2);
  
  @NotNull
  public abstract BufferedSink writeUtf8CodePoint(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.BufferedSink
 * JD-Core Version:    0.7.0.1
 */