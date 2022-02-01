package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public abstract interface BufferedSink
  extends WritableByteChannel, Sink
{
  public abstract Buffer buffer();
  
  public abstract BufferedSink emit();
  
  public abstract BufferedSink emitCompleteSegments();
  
  public abstract void flush();
  
  public abstract OutputStream outputStream();
  
  public abstract BufferedSink write(ByteString paramByteString);
  
  public abstract BufferedSink write(Source paramSource, long paramLong);
  
  public abstract BufferedSink write(byte[] paramArrayOfByte);
  
  public abstract BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract long writeAll(Source paramSource);
  
  public abstract BufferedSink writeByte(int paramInt);
  
  public abstract BufferedSink writeDecimalLong(long paramLong);
  
  public abstract BufferedSink writeHexadecimalUnsignedLong(long paramLong);
  
  public abstract BufferedSink writeInt(int paramInt);
  
  public abstract BufferedSink writeIntLe(int paramInt);
  
  public abstract BufferedSink writeLong(long paramLong);
  
  public abstract BufferedSink writeLongLe(long paramLong);
  
  public abstract BufferedSink writeShort(int paramInt);
  
  public abstract BufferedSink writeShortLe(int paramInt);
  
  public abstract BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset);
  
  public abstract BufferedSink writeString(String paramString, Charset paramCharset);
  
  public abstract BufferedSink writeUtf8(String paramString);
  
  public abstract BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2);
  
  public abstract BufferedSink writeUtf8CodePoint(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.BufferedSink
 * JD-Core Version:    0.7.0.1
 */