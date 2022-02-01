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
    if (paramSource != null)
    {
      this.source = paramSource;
      return;
    }
    throw new NullPointerException("source == null");
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
    if (!this.closed) {
      return (this.buffer.exhausted()) && (this.source.read(this.buffer, 8192L) == -1L);
    }
    throw new IllegalStateException("closed");
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
    if (!this.closed)
    {
      if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.buffer.indexOf(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          l = this.buffer.size;
          if (l >= paramLong2) {
            break;
          }
          if (this.source.read(this.buffer, 8192L) == -1L) {
            return -1L;
          }
          paramLong1 = Math.max(paramLong1, l);
        }
        return -1L;
      }
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("closed");
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  public long indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
  {
    if (!this.closed) {
      for (;;)
      {
        long l = this.buffer.indexOf(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        l = this.buffer.size;
        if (this.source.read(this.buffer, 8192L) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l - paramByteString.size() + 1L);
      }
    }
    paramByteString = new IllegalStateException("closed");
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    if (!this.closed) {
      for (;;)
      {
        long l = this.buffer.indexOfElement(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        l = this.buffer.size;
        if (this.source.read(this.buffer, 8192L) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l);
      }
    }
    paramByteString = new IllegalStateException("closed");
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public InputStream inputStream()
  {
    return new RealBufferedSource.1(this);
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if (!this.closed)
    {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0))
      {
        if (paramByteString.size() - paramInt1 < paramInt2) {
          return false;
        }
        int i = 0;
        while (i < paramInt2)
        {
          long l = i + paramLong;
          if (!request(1L + l)) {
            return false;
          }
          if (this.buffer.getByte(l) != paramByteString.getByte(paramInt1 + i)) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    paramByteString = new IllegalStateException("closed");
    for (;;)
    {
      throw paramByteString;
    }
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
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    Util.checkOffsetAndCount(l1, l2, l3);
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(l3, this.buffer.size);
    return this.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer != null)
    {
      if (paramLong >= 0L)
      {
        if (!this.closed)
        {
          if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
            return -1L;
          }
          paramLong = Math.min(paramLong, this.buffer.size);
          return this.buffer.read(paramBuffer, paramLong);
        }
        throw new IllegalStateException("closed");
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw new IllegalArgumentException(paramBuffer.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public long readAll(Sink paramSink)
  {
    if (paramSink != null)
    {
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
        Buffer localBuffer = this.buffer;
        paramSink.write(localBuffer, localBuffer.size());
      }
      return l2;
    }
    paramSink = new IllegalArgumentException("sink == null");
    for (;;)
    {
      throw paramSink;
    }
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
    int j;
    byte b;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!request(j)) {
        break label91;
      }
      b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((i != 0) || (b != 45))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[] { Byte.valueOf(b) }));
    }
    label91:
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
        Buffer localBuffer = this.buffer;
        int j = localBuffer.read(paramArrayOfByte, i, (int)localBuffer.size);
        if (j != -1) {
          i += j;
        } else {
          throw new AssertionError();
        }
      }
    }
    for (;;)
    {
      throw localEOFException;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    require(1L);
    int j;
    byte b;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!request(j)) {
        break label105;
      }
      b = this.buffer.getByte(i);
      if (((b < 48) || (b > 57)) && ((b < 97) || (b > 102)) && ((b < 65) || (b > 70))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b) }));
    }
    label105:
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
    if (paramCharset != null) {
      return this.buffer.readString(paramLong, paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public String readString(Charset paramCharset)
  {
    if (paramCharset != null)
    {
      this.buffer.writeAll(this.source);
      return this.buffer.readString(paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
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
    } else if ((i & 0xF0) == 224) {
      require(3L);
    } else if ((i & 0xF8) == 240) {
      require(4L);
    }
    return this.buffer.readUtf8CodePoint();
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
    if (paramLong >= 0L)
    {
      long l1;
      if (paramLong == 9223372036854775807L) {
        l1 = 9223372036854775807L;
      } else {
        l1 = paramLong + 1L;
      }
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 != -1L) {
        return this.buffer.readUtf8Line(l2);
      }
      if ((l1 < 9223372036854775807L) && (request(l1)) && (this.buffer.getByte(l1 - 1L) == 13) && (request(1L + l1)) && (this.buffer.getByte(l1) == 10)) {
        return this.buffer.readUtf8Line(l1);
      }
      localObject1 = new Buffer();
      Object localObject2 = this.buffer;
      ((Buffer)localObject2).copyTo((Buffer)localObject1, 0L, Math.min(32L, ((Buffer)localObject2).size()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\\n not found: limit=");
      ((StringBuilder)localObject2).append(Math.min(this.buffer.size(), paramLong));
      ((StringBuilder)localObject2).append(" content=");
      ((StringBuilder)localObject2).append(((Buffer)localObject1).readByteString().hex());
      ((StringBuilder)localObject2).append('…');
      throw new EOFException(((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limit < 0: ");
    ((StringBuilder)localObject1).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public boolean request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (!this.closed)
      {
        while (this.buffer.size < paramLong) {
          if (this.source.read(this.buffer, 8192L) == -1L) {
            return false;
          }
        }
        return true;
      }
      throw new IllegalStateException("closed");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void require(long paramLong)
  {
    if (request(paramLong)) {
      return;
    }
    throw new EOFException();
  }
  
  public int select(Options paramOptions)
  {
    if (!this.closed)
    {
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
    paramOptions = new IllegalStateException("closed");
    for (;;)
    {
      throw paramOptions;
    }
  }
  
  public void skip(long paramLong)
  {
    if (!this.closed)
    {
      while (paramLong > 0L)
      {
        if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.buffer.size());
        this.buffer.skip(l);
        paramLong -= l;
      }
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("closed");
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.source);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.RealBufferedSource
 * JD-Core Version:    0.7.0.1
 */