package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract interface BufferedSource
  extends ReadableByteChannel, Source
{
  public abstract Buffer buffer();
  
  public abstract boolean exhausted();
  
  public abstract long indexOf(byte paramByte);
  
  public abstract long indexOf(byte paramByte, long paramLong);
  
  public abstract long indexOf(byte paramByte, long paramLong1, long paramLong2);
  
  public abstract long indexOf(ByteString paramByteString);
  
  public abstract long indexOf(ByteString paramByteString, long paramLong);
  
  public abstract long indexOfElement(ByteString paramByteString);
  
  public abstract long indexOfElement(ByteString paramByteString, long paramLong);
  
  public abstract InputStream inputStream();
  
  public abstract boolean rangeEquals(long paramLong, ByteString paramByteString);
  
  public abstract boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2);
  
  public abstract int read(byte[] paramArrayOfByte);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract long readAll(Sink paramSink);
  
  public abstract byte readByte();
  
  public abstract byte[] readByteArray();
  
  public abstract byte[] readByteArray(long paramLong);
  
  public abstract ByteString readByteString();
  
  public abstract ByteString readByteString(long paramLong);
  
  public abstract long readDecimalLong();
  
  public abstract void readFully(Buffer paramBuffer, long paramLong);
  
  public abstract void readFully(byte[] paramArrayOfByte);
  
  public abstract long readHexadecimalUnsignedLong();
  
  public abstract int readInt();
  
  public abstract int readIntLe();
  
  public abstract long readLong();
  
  public abstract long readLongLe();
  
  public abstract short readShort();
  
  public abstract short readShortLe();
  
  public abstract String readString(long paramLong, Charset paramCharset);
  
  public abstract String readString(Charset paramCharset);
  
  public abstract String readUtf8();
  
  public abstract String readUtf8(long paramLong);
  
  public abstract int readUtf8CodePoint();
  
  @Nullable
  public abstract String readUtf8Line();
  
  public abstract String readUtf8LineStrict();
  
  public abstract String readUtf8LineStrict(long paramLong);
  
  public abstract boolean request(long paramLong);
  
  public abstract void require(long paramLong);
  
  public abstract int select(Options paramOptions);
  
  public abstract void skip(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okio.BufferedSource
 * JD-Core Version:    0.7.0.1
 */