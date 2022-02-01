package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k=1, mv={1, 1, 16})
public final class RealBufferedSource
  implements BufferedSource
{
  @JvmField
  @NotNull
  public final Buffer bufferField;
  @JvmField
  public boolean closed;
  @JvmField
  @NotNull
  public final Source source;
  
  public RealBufferedSource(@NotNull Source paramSource)
  {
    this.source = paramSource;
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
    this.closed = true;
    this.source.close();
    this.bufferField.clear();
  }
  
  public boolean exhausted()
  {
    if ((this.closed ^ true)) {
      return (this.bufferField.exhausted()) && (this.source.read(this.bufferField, 8192) == -1L);
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  @NotNull
  public Buffer getBuffer()
  {
    return this.bufferField;
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
    boolean bool = this.closed;
    int i = 1;
    if ((bool ^ true))
    {
      if ((0L > paramLong1) || (paramLong2 < paramLong1)) {
        i = 0;
      }
      if (i != 0)
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.bufferField.indexOf(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          l = this.bufferField.size();
          if (l >= paramLong2) {
            break;
          }
          if (this.source.read(this.bufferField, 8192) == -1L) {
            return -1L;
          }
          paramLong1 = Math.max(paramLong1, l);
        }
        return -1L;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromIndex=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" toIndex=");
      ((StringBuilder)localObject).append(paramLong2);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    Object localObject = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public long indexOf(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(@NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    if ((this.closed ^ true)) {
      for (;;)
      {
        long l = this.bufferField.indexOf(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        l = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l - paramByteString.size() + 1L);
      }
    }
    paramByteString = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public long indexOfElement(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(@NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    if ((this.closed ^ true)) {
      for (;;)
      {
        long l = this.bufferField.indexOfElement(paramByteString, paramLong);
        if (l != -1L) {
          return l;
        }
        l = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == -1L) {
          return -1L;
        }
        paramLong = Math.max(paramLong, l);
      }
    }
    paramByteString = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  @NotNull
  public InputStream inputStream()
  {
    return (InputStream)new RealBufferedSource.inputStream.1(this);
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  @NotNull
  public BufferedSource peek()
  {
    return Okio.buffer((Source)new PeekSource((BufferedSource)this));
  }
  
  public boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    if ((this.closed ^ true))
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramLong >= 0L)
      {
        bool1 = bool2;
        if (paramInt1 >= 0)
        {
          bool1 = bool2;
          if (paramInt2 >= 0)
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
              if (this.bufferField.getByte(l) != paramByteString.getByte(paramInt1 + i)) {
                return false;
              }
              i += 1;
            }
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    paramByteString = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public int read(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "sink");
    if ((this.bufferField.size() == 0L) && (this.source.read(this.bufferField, 8192) == -1L)) {
      return -1;
    }
    return this.bufferField.read(paramByteBuffer);
  }
  
  public int read(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    -Util.checkOffsetAndCount(l1, l2, l3);
    if ((this.bufferField.size() == 0L) && (this.source.read(this.bufferField, 8192) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(l3, this.bufferField.size());
    return this.bufferField.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((true ^ this.closed))
      {
        if ((this.bufferField.size() == 0L) && (this.source.read(this.bufferField, 8192) == -1L)) {
          return -1L;
        }
        paramLong = Math.min(paramLong, this.bufferField.size());
        return this.bufferField.read(paramBuffer, paramLong);
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public long readAll(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    long l1 = 0L;
    while (this.source.read(this.bufferField, 8192) != -1L)
    {
      l2 = this.bufferField.completeSegmentByteCount();
      if (l2 > 0L)
      {
        l1 += l2;
        paramSink.write(this.bufferField, l2);
      }
    }
    long l2 = l1;
    if (this.bufferField.size() > 0L)
    {
      l2 = l1 + this.bufferField.size();
      Buffer localBuffer = this.bufferField;
      paramSink.write(localBuffer, localBuffer.size());
    }
    return l2;
  }
  
  public byte readByte()
  {
    require(1L);
    return this.bufferField.readByte();
  }
  
  @NotNull
  public byte[] readByteArray()
  {
    this.bufferField.writeAll(this.source);
    return this.bufferField.readByteArray();
  }
  
  @NotNull
  public byte[] readByteArray(long paramLong)
  {
    require(paramLong);
    return this.bufferField.readByteArray(paramLong);
  }
  
  @NotNull
  public ByteString readByteString()
  {
    this.bufferField.writeAll(this.source);
    return this.bufferField.readByteString();
  }
  
  @NotNull
  public ByteString readByteString(long paramLong)
  {
    require(paramLong);
    return this.bufferField.readByteString(paramLong);
  }
  
  public long readDecimalLong()
  {
    require(1L);
    long l2;
    int i;
    for (long l1 = 0L;; l1 = l2)
    {
      l2 = l1 + 1L;
      if (!request(l2)) {
        break label139;
      }
      i = this.bufferField.getByte(l1);
      if (((i < (byte)48) || (i > (byte)57)) && ((l1 != 0L) || (i != (byte)45))) {
        break;
      }
    }
    if (l1 == 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected leading [0-9] or '-' character but was 0x");
      String str = Integer.toString(i, CharsKt.checkRadix(CharsKt.checkRadix(16)));
      Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      localStringBuilder.append(str);
      throw ((Throwable)new NumberFormatException(localStringBuilder.toString()));
    }
    label139:
    return this.bufferField.readDecimalLong();
  }
  
  public void readFully(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    try
    {
      require(paramLong);
      this.bufferField.readFully(paramBuffer, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramBuffer.writeAll((Source)this.bufferField);
      throw ((Throwable)localEOFException);
    }
  }
  
  public void readFully(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    try
    {
      require(paramArrayOfByte.length);
      this.bufferField.readFully(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.bufferField.size() > 0L)
      {
        Buffer localBuffer = this.bufferField;
        int j = localBuffer.read(paramArrayOfByte, i, (int)localBuffer.size());
        if (j != -1) {
          i += j;
        } else {
          throw ((Throwable)new AssertionError());
        }
      }
      paramArrayOfByte = (Throwable)localEOFException;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    require(1L);
    int j;
    int k;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!request(j)) {
        break label151;
      }
      k = this.bufferField.getByte(i);
      if (((k < (byte)48) || (k > (byte)57)) && ((k < (byte)97) || (k > (byte)102)) && ((k < (byte)65) || (k > (byte)70))) {
        break;
      }
    }
    if (i == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected leading [0-9a-fA-F] character but was 0x");
      String str = Integer.toString(k, CharsKt.checkRadix(CharsKt.checkRadix(16)));
      Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      localStringBuilder.append(str);
      throw ((Throwable)new NumberFormatException(localStringBuilder.toString()));
    }
    label151:
    return this.bufferField.readHexadecimalUnsignedLong();
  }
  
  public int readInt()
  {
    require(4L);
    return this.bufferField.readInt();
  }
  
  public int readIntLe()
  {
    require(4L);
    return this.bufferField.readIntLe();
  }
  
  public long readLong()
  {
    require(8L);
    return this.bufferField.readLong();
  }
  
  public long readLongLe()
  {
    require(8L);
    return this.bufferField.readLongLe();
  }
  
  public short readShort()
  {
    require(2L);
    return this.bufferField.readShort();
  }
  
  public short readShortLe()
  {
    require(2L);
    return this.bufferField.readShortLe();
  }
  
  @NotNull
  public String readString(long paramLong, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    require(paramLong);
    return this.bufferField.readString(paramLong, paramCharset);
  }
  
  @NotNull
  public String readString(@NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    this.bufferField.writeAll(this.source);
    return this.bufferField.readString(paramCharset);
  }
  
  @NotNull
  public String readUtf8()
  {
    this.bufferField.writeAll(this.source);
    return this.bufferField.readUtf8();
  }
  
  @NotNull
  public String readUtf8(long paramLong)
  {
    require(paramLong);
    return this.bufferField.readUtf8(paramLong);
  }
  
  public int readUtf8CodePoint()
  {
    require(1L);
    int i = this.bufferField.getByte(0L);
    if ((i & 0xE0) == 192) {
      require(2L);
    } else if ((i & 0xF0) == 224) {
      require(3L);
    } else if ((i & 0xF8) == 240) {
      require(4L);
    }
    return this.bufferField.readUtf8CodePoint();
  }
  
  @Nullable
  public String readUtf8Line()
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.bufferField.size() != 0L) {
        return readUtf8(this.bufferField.size());
      }
      return null;
    }
    return BufferKt.readUtf8Line(this.bufferField, l);
  }
  
  @NotNull
  public String readUtf8LineStrict()
  {
    return readUtf8LineStrict(9223372036854775807L);
  }
  
  @NotNull
  public String readUtf8LineStrict(long paramLong)
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong == 9223372036854775807L) {
        l1 = 9223372036854775807L;
      } else {
        l1 = paramLong + 1L;
      }
      byte b = (byte)10;
      long l2 = indexOf(b, 0L, l1);
      if (l2 != -1L) {
        return BufferKt.readUtf8Line(this.bufferField, l2);
      }
      if ((l1 < 9223372036854775807L) && (request(l1)) && (this.bufferField.getByte(l1 - 1L) == (byte)13) && (request(1L + l1)) && (this.bufferField.getByte(l1) == b)) {
        return BufferKt.readUtf8Line(this.bufferField, l1);
      }
      localObject1 = new Buffer();
      Object localObject2 = this.bufferField;
      long l1 = ((Buffer)localObject2).size();
      ((Buffer)localObject2).copyTo((Buffer)localObject1, 0L, Math.min(32, l1));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\\n not found: limit=");
      ((StringBuilder)localObject2).append(Math.min(this.bufferField.size(), paramLong));
      ((StringBuilder)localObject2).append(" content=");
      ((StringBuilder)localObject2).append(((Buffer)localObject1).readByteString().hex());
      ((StringBuilder)localObject2).append("…");
      throw ((Throwable)new EOFException(((StringBuilder)localObject2).toString()));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("limit < 0: ");
    ((StringBuilder)localObject1).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
  }
  
  public boolean request(long paramLong)
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((this.closed ^ true))
      {
        while (this.bufferField.size() < paramLong) {
          if (this.source.read(this.bufferField, 8192) == -1L) {
            return false;
          }
        }
        return true;
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
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
    throw ((Throwable)new EOFException());
  }
  
  public int select(@NotNull Options paramOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    if ((this.closed ^ true))
    {
      do
      {
        int i = BufferKt.selectPrefix(this.bufferField, paramOptions, true);
        if (i != -2)
        {
          if (i == -1) {
            break;
          }
          int j = paramOptions.getByteStrings$okio()[i].size();
          this.bufferField.skip(j);
          return i;
        }
      } while (this.source.read(this.bufferField, 8192) != -1L);
      return -1;
    }
    paramOptions = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw paramOptions;
    }
  }
  
  public void skip(long paramLong)
  {
    if ((this.closed ^ true))
    {
      while (paramLong > 0L)
      {
        if ((this.bufferField.size() == 0L) && (this.source.read(this.bufferField, 8192) == -1L)) {
          throw ((Throwable)new EOFException());
        }
        long l = Math.min(paramLong, this.bufferField.size());
        this.bufferField.skip(l);
        paramLong -= l;
      }
      return;
    }
    Throwable localThrowable = (Throwable)new IllegalStateException("closed".toString());
    for (;;)
    {
      throw localThrowable;
    }
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.source);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.RealBufferedSource
 * JD-Core Version:    0.7.0.1
 */