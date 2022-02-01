package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "exhausted", "", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "okio"}, k=1, mv={1, 1, 16})
public abstract interface BufferedSource
  extends ReadableByteChannel, Source
{
  @Deprecated(level=DeprecationLevel.WARNING, message="moved to val: use getBuffer() instead", replaceWith=@ReplaceWith(expression="buffer", imports={}))
  @NotNull
  public abstract Buffer buffer();
  
  public abstract boolean exhausted();
  
  @NotNull
  public abstract Buffer getBuffer();
  
  public abstract long indexOf(byte paramByte);
  
  public abstract long indexOf(byte paramByte, long paramLong);
  
  public abstract long indexOf(byte paramByte, long paramLong1, long paramLong2);
  
  public abstract long indexOf(@NotNull ByteString paramByteString);
  
  public abstract long indexOf(@NotNull ByteString paramByteString, long paramLong);
  
  public abstract long indexOfElement(@NotNull ByteString paramByteString);
  
  public abstract long indexOfElement(@NotNull ByteString paramByteString, long paramLong);
  
  @NotNull
  public abstract InputStream inputStream();
  
  @NotNull
  public abstract BufferedSource peek();
  
  public abstract boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString);
  
  public abstract boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString, int paramInt1, int paramInt2);
  
  public abstract int read(@NotNull byte[] paramArrayOfByte);
  
  public abstract int read(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract long readAll(@NotNull Sink paramSink);
  
  public abstract byte readByte();
  
  @NotNull
  public abstract byte[] readByteArray();
  
  @NotNull
  public abstract byte[] readByteArray(long paramLong);
  
  @NotNull
  public abstract ByteString readByteString();
  
  @NotNull
  public abstract ByteString readByteString(long paramLong);
  
  public abstract long readDecimalLong();
  
  public abstract void readFully(@NotNull Buffer paramBuffer, long paramLong);
  
  public abstract void readFully(@NotNull byte[] paramArrayOfByte);
  
  public abstract long readHexadecimalUnsignedLong();
  
  public abstract int readInt();
  
  public abstract int readIntLe();
  
  public abstract long readLong();
  
  public abstract long readLongLe();
  
  public abstract short readShort();
  
  public abstract short readShortLe();
  
  @NotNull
  public abstract String readString(long paramLong, @NotNull Charset paramCharset);
  
  @NotNull
  public abstract String readString(@NotNull Charset paramCharset);
  
  @NotNull
  public abstract String readUtf8();
  
  @NotNull
  public abstract String readUtf8(long paramLong);
  
  public abstract int readUtf8CodePoint();
  
  @Nullable
  public abstract String readUtf8Line();
  
  @NotNull
  public abstract String readUtf8LineStrict();
  
  @NotNull
  public abstract String readUtf8LineStrict(long paramLong);
  
  public abstract boolean request(long paramLong);
  
  public abstract void require(long paramLong);
  
  public abstract int select(@NotNull Options paramOptions);
  
  public abstract void skip(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.BufferedSource
 * JD-Core Version:    0.7.0.1
 */