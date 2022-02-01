package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

final class RealBufferedSource
  implements BufferedSource
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Source source;
  
  RealBufferedSource(Source paramSource)
  {
    if (paramSource == null) {
      throw new NullPointerException("source == null");
    }
    this.source = paramSource;
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
    this.closed = true;
    this.source.close();
    this.buffer.clear();
  }
  
  public boolean exhausted()
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    return (this.buffer.exhausted()) && (this.source.read(this.buffer, 8192L) == -1L);
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return indexOf(paramByte, paramLong, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1))
    {
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      Object localObject;
      paramLong1 = Math.max(paramLong1, localObject);
    }
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        long l = this.buffer.indexOf(paramByte, paramLong1, paramLong2);
        if (l != -1L) {
          return l;
        }
        l = this.buffer.size;
        if ((l < paramLong2) && (this.source.read(this.buffer, 8192L) != -1L)) {
          break;
        }
        return -1L;
      }
      return -1L;
    }
  }
  
  public long indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    do
    {
      Object localObject;
      paramLong = Math.max(paramLong, localObject - paramByteString.size() + 1L);
      long l = this.buffer.indexOf(paramByteString, paramLong);
      if (l != -1L) {
        return l;
      }
      l = this.buffer.size;
    } while (this.source.read(this.buffer, 8192L) != -1L);
    return -1L;
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    do
    {
      Object localObject;
      paramLong = Math.max(paramLong, localObject);
      long l = this.buffer.indexOfElement(paramByteString, paramLong);
      if (l != -1L) {
        return l;
      }
      l = this.buffer.size;
    } while (this.source.read(this.buffer, 8192L) != -1L);
    return -1L;
  }
  
  public InputStream inputStream()
  {
    return new RealBufferedSource.1(this);
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 < 0) || (paramByteString.size() - paramInt1 < paramInt2)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        break label105;
      }
      long l = i + paramLong;
      if ((!request(1L + l)) || (this.buffer.getByte(l) != paramByteString.getByte(paramInt1 + i))) {
        break;
      }
      i += 1;
    }
    label105:
    return true;
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
      return -1;
    }
    return this.buffer.read(paramByteBuffer);
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, this.buffer.size);
    return this.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.buffer.size);
    return this.buffer.read(paramBuffer, paramLong);
  }
  
  public long readAll(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    long l1 = 0L;
    while (this.source.read(this.buffer, 8192L) != -1L)
    {
      l2 = this.buffer.completeSegmentByteCount();
      if (l2 > 0L)
      {
        l1 += l2;
        paramSink.write(this.buffer, l2);
      }
    }
    long l2 = l1;
    if (this.buffer.size() > 0L)
    {
      l2 = l1 + this.buffer.size();
      paramSink.write(this.buffer, this.buffer.size());
    }
    return l2;
  }
  
  public byte readByte()
  {
    require(1L);
    return this.buffer.readByte();
  }
  
  public byte[] readByteArray()
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteArray();
  }
  
  public byte[] readByteArray(long paramLong)
  {
    require(paramLong);
    return this.buffer.readByteArray(paramLong);
  }
  
  public ByteString readByteString()
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteString();
  }
  
  public ByteString readByteString(long paramLong)
  {
    require(paramLong);
    return this.buffer.readByteString(paramLong);
  }
  
  public long readDecimalLong()
  {
    require(1L);
    int i = 0;
    while (request(i + 1))
    {
      byte b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((i != 0) || (b != 45)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[] { Byte.valueOf(b) }));
      }
      i += 1;
    }
    return this.buffer.readDecimalLong();
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
  {
    try
    {
      require(paramLong);
      this.buffer.readFully(paramBuffer, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramBuffer.writeAll(this.buffer);
      throw localEOFException;
    }
  }
  
  public void readFully(byte[] paramArrayOfByte)
  {
    try
    {
      require(paramArrayOfByte.length);
      this.buffer.readFully(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.buffer.size > 0L)
      {
        int j = this.buffer.read(paramArrayOfByte, i, (int)this.buffer.size);
        if (j == -1) {
          throw new AssertionError();
        }
        i += j;
      }
      throw localEOFException;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    require(1L);
    int i = 0;
    while (request(i + 1))
    {
      byte b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((b < 97) || (b > 102)) && ((b < 65) || (b > 70)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b) }));
      }
      i += 1;
    }
    return this.buffer.readHexadecimalUnsignedLong();
  }
  
  public int readInt()
  {
    require(4L);
    return this.buffer.readInt();
  }
  
  public int readIntLe()
  {
    require(4L);
    return this.buffer.readIntLe();
  }
  
  public long readLong()
  {
    require(8L);
    return this.buffer.readLong();
  }
  
  public long readLongLe()
  {
    require(8L);
    return this.buffer.readLongLe();
  }
  
  public short readShort()
  {
    require(2L);
    return this.buffer.readShort();
  }
  
  public short readShortLe()
  {
    require(2L);
    return this.buffer.readShortLe();
  }
  
  public String readString(long paramLong, Charset paramCharset)
  {
    require(paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    return this.buffer.readString(paramLong, paramCharset);
  }
  
  public String readString(Charset paramCharset)
  {
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    this.buffer.writeAll(this.source);
    return this.buffer.readString(paramCharset);
  }
  
  public String readUtf8()
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readUtf8();
  }
  
  public String readUtf8(long paramLong)
  {
    require(paramLong);
    return this.buffer.readUtf8(paramLong);
  }
  
  public int readUtf8CodePoint()
  {
    require(1L);
    int i = this.buffer.getByte(0L);
    if ((i & 0xE0) == 192) {
      require(2L);
    }
    for (;;)
    {
      return this.buffer.readUtf8CodePoint();
      if ((i & 0xF0) == 224) {
        require(3L);
      } else if ((i & 0xF8) == 240) {
        require(4L);
      }
    }
  }
  
  @Nullable
  public String readUtf8Line()
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.buffer.size != 0L) {
        return readUtf8(this.buffer.size);
      }
      return null;
    }
    return this.buffer.readUtf8Line(l);
  }
  
  public String readUtf8LineStrict()
  {
    return readUtf8LineStrict(9223372036854775807L);
  }
  
  public String readUtf8LineStrict(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    }
    if (paramLong == 9223372036854775807L) {}
    for (long l1 = 9223372036854775807L;; l1 = paramLong + 1L)
    {
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      return this.buffer.readUtf8Line(l2);
    }
    if ((l1 < 9223372036854775807L) && (request(l1)) && (this.buffer.getByte(l1 - 1L) == 13) && (request(1L + l1)) && (this.buffer.getByte(l1) == 10)) {
      return this.buffer.readUtf8Line(l1);
    }
    Buffer localBuffer = new Buffer();
    this.buffer.copyTo(localBuffer, 0L, Math.min(32L, this.buffer.size()));
    throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), paramLong) + " content=" + localBuffer.readByteString().hex() + '…');
  }
  
  public boolean request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    while (this.buffer.size < paramLong) {
      if (this.source.read(this.buffer, 8192L) == -1L) {
        return false;
      }
    }
    return true;
  }
  
  public void require(long paramLong)
  {
    if (!request(paramLong)) {
      throw new EOFException();
    }
  }
  
  public int select(Options paramOptions)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    int i;
    do
    {
      i = this.buffer.selectPrefix(paramOptions, true);
      if (i == -1) {
        return -1;
      }
      if (i != -2) {
        break;
      }
    } while (this.source.read(this.buffer, 8192L) != -1L);
    return -1;
    int j = paramOptions.byteStrings[i].size();
    this.buffer.skip(j);
    return i;
  }
  
  public void skip(long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.buffer.size());
      this.buffer.skip(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.buffer.size != 0L) || (this.source.read(this.buffer, 8192L) != -1L));
    throw new EOFException();
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  public String toString()
  {
    return "buffer(" + this.source + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okio.RealBufferedSource
 * JD-Core Version:    0.7.0.1
 */