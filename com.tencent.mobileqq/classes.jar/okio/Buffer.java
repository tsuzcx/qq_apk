package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer
  implements Cloneable, BufferedSink, BufferedSource
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  Segment head;
  long size;
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    while ((paramLong > 0L) || (paramBoolean))
    {
      Segment localSegment = writableSegment(1);
      int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
      if (i == -1)
      {
        if (paramBoolean) {
          return;
        }
        throw new EOFException();
      }
      localSegment.limit += i;
      this.size += i;
      paramLong -= i;
    }
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public void clear()
  {
    try
    {
      skip(this.size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L) {
      return localBuffer;
    }
    localBuffer.head = new Segment(this.head);
    Segment localSegment1 = localBuffer.head;
    Segment localSegment2 = localBuffer.head;
    Segment localSegment3 = localBuffer.head;
    localSegment2.prev = localSegment3;
    localSegment1.next = localSegment3;
    for (localSegment1 = this.head.next;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == this.head)
      {
        localBuffer.size = this.size;
        return localBuffer;
      }
      localBuffer.head.prev.push(new Segment(localSegment1));
    }
  }
  
  public void close() {}
  
  public long completeSegmentByteCount()
  {
    long l2 = this.size;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    Segment localSegment;
    do
    {
      do
      {
        return l1;
        localSegment = this.head.prev;
        l1 = l2;
      } while (localSegment.limit >= 8192);
      l1 = l2;
    } while (!localSegment.owner);
    return l2 - (localSegment.limit - localSegment.pos);
  }
  
  public Buffer copyTo(OutputStream paramOutputStream)
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    for (Segment localSegment = this.head;; localSegment = localSegment.next)
    {
      if (paramLong1 < localSegment.limit - localSegment.pos)
      {
        while (paramLong2 > 0L)
        {
          int i = (int)(localSegment.pos + paramLong1);
          int j = (int)Math.min(localSegment.limit - i, paramLong2);
          paramOutputStream.write(localSegment.data, i, j);
          paramLong2 -= j;
          localSegment = localSegment.next;
          paramLong1 = 0L;
        }
        break;
      }
      paramLong1 -= localSegment.limit - localSegment.pos;
    }
  }
  
  public Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.size += paramLong2;
    Segment localSegment1 = this.head;
    label50:
    label67:
    Segment localSegment2;
    if (paramLong1 < localSegment1.limit - localSegment1.pos) {
      if (paramLong2 > 0L)
      {
        localSegment2 = new Segment(localSegment1);
        localSegment2.pos = ((int)(localSegment2.pos + paramLong1));
        localSegment2.limit = Math.min(localSegment2.pos + (int)paramLong2, localSegment2.limit);
        if (paramBuffer.head != null) {
          break label202;
        }
        localSegment2.prev = localSegment2;
        localSegment2.next = localSegment2;
        paramBuffer.head = localSegment2;
      }
    }
    for (;;)
    {
      paramLong2 -= localSegment2.limit - localSegment2.pos;
      localSegment1 = localSegment1.next;
      paramLong1 = 0L;
      break label67;
      break;
      paramLong1 -= localSegment1.limit - localSegment1.pos;
      localSegment1 = localSegment1.next;
      break label50;
      label202:
      paramBuffer.head.prev.push(localSegment2);
    }
  }
  
  public BufferedSink emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (this.size != paramObject.size) {
      return false;
    }
    if (this.size == 0L) {
      return true;
    }
    Object localObject2 = this.head;
    paramObject = paramObject.head;
    int j = ((Segment)localObject2).pos;
    int i = paramObject.pos;
    if (l1 >= this.size) {
      return true;
    }
    long l2 = Math.min(((Segment)localObject2).limit - j, paramObject.limit - i);
    int k = 0;
    for (;;)
    {
      if (k >= l2)
      {
        k = j;
        Object localObject1 = localObject2;
        if (j == ((Segment)localObject2).limit)
        {
          localObject1 = ((Segment)localObject2).next;
          k = ((Segment)localObject1).pos;
        }
        j = i;
        localObject2 = paramObject;
        if (i == paramObject.limit)
        {
          localObject2 = paramObject.next;
          j = ((Segment)localObject2).pos;
        }
        l1 += l2;
        i = j;
        j = k;
        paramObject = localObject2;
        localObject2 = localObject1;
        break;
      }
      if (localObject2.data[j] != paramObject.data[i]) {
        return false;
      }
      k += 1;
      i += 1;
      j += 1;
    }
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    for (Segment localSegment = this.head;; localSegment = localSegment.next)
    {
      int i = localSegment.limit - localSegment.pos;
      if (paramLong < i) {
        return localSegment.data[(localSegment.pos + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int k = ((Segment)localObject).pos;
    int m = ((Segment)localObject).limit;
    for (int i = j;; i = j + i * 31)
    {
      if (k >= m)
      {
        Segment localSegment = ((Segment)localObject).next;
        j = i;
        localObject = localSegment;
        if (localSegment != this.head) {
          break;
        }
        return i;
      }
      j = localObject.data[k];
      k += 1;
    }
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    long l = 0L;
    do
    {
      int j = ((Segment)localObject1).limit - ((Segment)localObject1).pos;
      if (paramLong < j) {
        break;
      }
      paramLong -= j;
      l += j;
      localObject2 = ((Segment)localObject1).next;
      localObject1 = localObject2;
    } while (localObject2 != this.head);
    return -1L;
    Object localObject2 = ((Segment)localObject1).data;
    int i = (int)(((Segment)localObject1).pos + paramLong);
    int k = ((Segment)localObject1).limit;
    for (;;)
    {
      if (i >= k)
      {
        paramLong = 0L;
        break;
      }
      if (localObject2[i] == paramByte) {
        return l + i - ((Segment)localObject1).pos;
      }
      i += 1;
    }
  }
  
  public long indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
  {
    if (paramByteString.size() == 0) {
      throw new IllegalArgumentException("bytes is empty");
    }
    do
    {
      paramLong += 1L;
      paramLong = indexOf(paramByteString.getByte(0), paramLong);
      if (paramLong == -1L) {
        return -1L;
      }
    } while (!rangeEquals(paramLong, paramByteString));
    return paramLong;
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject = this.head;
    if (localObject == null) {
      return -1L;
    }
    long l1 = 0L;
    byte[] arrayOfByte = paramByteString.toByteArray();
    paramByteString = (ByteString)localObject;
    int j = paramByteString.limit - paramByteString.pos;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l1 += j;
      localObject = paramByteString.next;
      paramByteString = (ByteString)localObject;
      if (localObject != this.head) {
        break;
      }
      return -1L;
      localObject = paramByteString.data;
      paramLong = paramByteString.pos + paramLong;
      long l2 = paramByteString.limit;
      if (paramLong < l2) {
        break label131;
      }
    }
    label131:
    int k = localObject[((int)paramLong)];
    int m = arrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= m)
      {
        paramLong += 1L;
        break;
      }
      if (k == arrayOfByte[i]) {
        return l1 + paramLong - paramByteString.pos;
      }
      i += 1;
    }
  }
  
  public InputStream inputStream()
  {
    return new Buffer.2(this);
  }
  
  public OutputStream outputStream()
  {
    return new Buffer.1(this);
  }
  
  boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    int j = paramByteString.size();
    if (this.size - paramLong < j) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      if (getByte(i + paramLong) != paramByteString.getByte(i)) {
        break;
      }
      i += 1;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
      localSegment.pos += paramInt2;
      this.size -= paramInt2;
      paramInt1 = paramInt2;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.size == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.size) {
      l = this.size;
    }
    paramBuffer.write(this, l);
    return l;
  }
  
  public long readAll(Sink paramSink)
  {
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public byte readByte()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return b;
    }
    localSegment.pos = k;
    return b;
  }
  
  public byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(this.size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public byte[] readByteArray(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong)
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public long readDecimalLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int n = 0;
    int i1 = 0;
    int i = 0;
    long l3 = -7L;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int m = ((Segment)localObject).pos;
    int i2 = ((Segment)localObject).limit;
    long l1 = l2;
    int j = n;
    int k = i1;
    l2 = l3;
    if (m >= i2)
    {
      label83:
      if (m != i2) {
        break label345;
      }
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        l3 = l2;
        i1 = k;
        n = j;
        l2 = l1;
        if (this.head != null) {
          break;
        }
      }
      this.size -= j;
      if (k == 0) {
        break label355;
      }
      return l1;
      n = arrayOfByte[m];
      if ((n >= 48) && (n <= 57))
      {
        i1 = 48 - n;
        if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (i1 < l2)))
        {
          localObject = new Buffer().writeDecimalLong(l1).writeByte(n);
          if (k == 0) {
            ((Buffer)localObject).readByte();
          }
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        }
        l1 = l1 * 10L + i1;
      }
      for (;;)
      {
        m += 1;
        j += 1;
        break;
        if ((n != 45) || (j != 0)) {
          break label307;
        }
        k = 1;
        l2 -= 1L;
      }
      label307:
      if (j == 0) {
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(n));
      }
      i = 1;
      break label83;
      label345:
      ((Segment)localObject).pos = m;
    }
    label355:
    return -l1;
  }
  
  public Buffer readFrom(InputStream paramInputStream)
  {
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }
  
  public Buffer readFrom(InputStream paramInputStream, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    readFrom(paramInputStream, paramLong, false);
    return this;
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
  {
    if (this.size < paramLong)
    {
      paramBuffer.write(this, this.size);
      throw new EOFException();
    }
    paramBuffer.write(this, paramLong);
  }
  
  public void readFully(byte[] paramArrayOfByte)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return;
      }
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int m = ((Segment)localObject).pos;
    int n = ((Segment)localObject).limit;
    long l1 = l2;
    int k = i;
    label59:
    if (m >= n)
    {
      if (m != n) {
        break label320;
      }
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (j == 0)
      {
        i = k;
        l2 = l1;
        if (this.head != null) {
          break;
        }
      }
      this.size -= k;
      return l1;
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0x0 & l1) != 0L)
        {
          localObject = new Buffer().writeHexadecimalUnsignedLong(l1).writeByte(i1);
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
          if ((i1 >= 97) && (i1 <= 102))
          {
            i = i1 - 97 + 10;
          }
          else if ((i1 >= 65) && (i1 <= 70))
          {
            i = i1 - 65 + 10;
          }
          else
          {
            if (k == 0) {
              throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
            }
            j = 1;
            break;
          }
        }
      }
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label59;
      label320:
      ((Segment)localObject).pos = m;
    }
  }
  
  public int readInt()
  {
    if (this.size < 4L) {
      throw new IllegalStateException("size < 4: " + this.size);
    }
    Segment localSegment = this.head;
    int j = localSegment.pos;
    int i = localSegment.limit;
    if (i - j < 4) {
      return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.size -= 4L;
    if (n == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return j;
    }
    localSegment.pos = n;
    return j;
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    if (this.size < 8L) {
      throw new IllegalStateException("size < 8: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 8) {
      return (readInt() & 0xFFFFFFFF) << 32 | readInt() & 0xFFFFFFFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    long l1 = arrayOfByte[k];
    k = j + 1;
    long l2 = arrayOfByte[j];
    j = k + 1;
    long l3 = arrayOfByte[k];
    k = j + 1;
    long l4 = arrayOfByte[j];
    j = k + 1;
    long l5 = arrayOfByte[k];
    k = j + 1;
    long l6 = arrayOfByte[j];
    j = k + 1;
    long l7 = arrayOfByte[k];
    k = j + 1;
    l1 = arrayOfByte[j] & 0xFF | (l2 & 0xFF) << 48 | (l1 & 0xFF) << 56 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
    this.size -= 8L;
    if (k == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return l1;
    }
    localSegment.pos = k;
    return l1;
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    if (this.size < 2L) {
      throw new IllegalStateException("size < 2: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 2) {
      return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.size -= 2L;
    if (m == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localSegment.pos = m;
    }
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = this.head;
      if (localSegment.pos + paramLong > localSegment.limit) {
        return new String(readByteArray(paramLong), paramCharset);
      }
      str = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
      localSegment.pos = ((int)(localSegment.pos + paramLong));
      this.size -= paramLong;
      paramCharset = str;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return str;
  }
  
  public String readString(Charset paramCharset)
  {
    try
    {
      paramCharset = readString(this.size, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public String readUtf8()
  {
    try
    {
      String str = readString(this.size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String readUtf8(long paramLong)
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint()
  {
    if (this.size == 0L) {
      throw new EOFException();
    }
    int m = getByte(0L);
    int j;
    int i;
    int k;
    if ((m & 0x80) == 0)
    {
      j = 0;
      i = m & 0x7F;
      k = 1;
    }
    while (this.size < k)
    {
      throw new EOFException("size < " + k + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(m) + ")");
      if ((m & 0xE0) == 192)
      {
        i = m & 0x1F;
        k = 2;
        j = 128;
      }
      else if ((m & 0xF0) == 224)
      {
        i = m & 0xF;
        k = 3;
        j = 2048;
      }
      else if ((m & 0xF8) == 240)
      {
        i = m & 0x7;
        k = 4;
        j = 65536;
      }
      else
      {
        skip(1L);
        return 65533;
      }
    }
    m = 1;
    for (;;)
    {
      if (m >= k)
      {
        skip(k);
        if (i <= 1114111) {
          break label276;
        }
        return 65533;
      }
      int n = getByte(m);
      if ((n & 0xC0) != 128) {
        break;
      }
      m += 1;
      i = n & 0x3F | i << 6;
    }
    skip(m);
    return 65533;
    label276:
    if ((i >= 55296) && (i <= 57343)) {
      return 65533;
    }
    if (i < j) {
      return 65533;
    }
    return i;
  }
  
  public String readUtf8Line()
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.size != 0L) {
        return readUtf8(this.size);
      }
      return null;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      str = readUtf8(paramLong - 1L);
      skip(2L);
      return str;
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      Buffer localBuffer = new Buffer();
      copyTo(localBuffer, 0L, Math.min(32L, this.size));
      throw new EOFException("\\n not found: size=" + size() + " content=" + localBuffer.readByteString().hex() + "...");
    }
    return readUtf8Line(l);
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
  {
    if (this.size < paramLong) {
      throw new EOFException();
    }
  }
  
  List<Integer> segmentSizes()
  {
    if (this.head == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    for (Segment localSegment = this.head.next;; localSegment = localSegment.next)
    {
      if (localSegment == this.head) {
        return localArrayList;
      }
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
  }
  
  public long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
  {
    for (;;)
    {
      if (paramLong <= 0L) {
        return;
      }
      if (this.head == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.head.limit - this.head.pos);
      this.size -= i;
      long l = paramLong - i;
      Segment localSegment = this.head;
      localSegment.pos = (i + localSegment.pos);
      paramLong = l;
      if (this.head.pos == this.head.limit)
      {
        localSegment = this.head;
        this.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
        paramLong = l;
      }
    }
  }
  
  public ByteString snapshot()
  {
    if (this.size > 2147483647L) {
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }
    return snapshot((int)this.size);
  }
  
  public ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    return new SegmentedByteString(this, paramInt);
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	okio/Buffer:size	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +7 -> 13
    //   9: ldc_w 480
    //   12: areturn
    //   13: aload_0
    //   14: getfield 81	okio/Buffer:size	J
    //   17: ldc2_w 481
    //   20: lcmp
    //   21: ifgt +39 -> 60
    //   24: aload_0
    //   25: invokevirtual 97	okio/Buffer:clone	()Lokio/Buffer;
    //   28: invokevirtual 424	okio/Buffer:readByteString	()Lokio/ByteString;
    //   31: astore_1
    //   32: ldc_w 484
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: getfield 81	okio/Buffer:size	J
    //   45: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_1
    //   52: invokevirtual 427	okio/ByteString:hex	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 493	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: areturn
    //   60: ldc_w 495
    //   63: invokestatic 501	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   66: astore_2
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   72: getfield 70	okio/Segment:data	[B
    //   75: aload_0
    //   76: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   79: getfield 123	okio/Segment:pos	I
    //   82: aload_0
    //   83: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   86: getfield 61	okio/Segment:limit	I
    //   89: aload_0
    //   90: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   93: getfield 123	okio/Segment:pos	I
    //   96: isub
    //   97: invokevirtual 504	java/security/MessageDigest:update	([BII)V
    //   100: aload_0
    //   101: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   104: getfield 109	okio/Segment:next	Lokio/Segment;
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 100	okio/Buffer:head	Lokio/Segment;
    //   113: if_acmpne +37 -> 150
    //   116: ldc_w 506
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_0
    //   126: getfield 81	okio/Buffer:size	J
    //   129: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload_2
    //   136: invokevirtual 509	java/security/MessageDigest:digest	()[B
    //   139: invokestatic 513	okio/ByteString:of	([B)Lokio/ByteString;
    //   142: invokevirtual 427	okio/ByteString:hex	()Ljava/lang/String;
    //   145: aastore
    //   146: invokestatic 493	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   149: areturn
    //   150: aload_2
    //   151: aload_1
    //   152: getfield 70	okio/Segment:data	[B
    //   155: aload_1
    //   156: getfield 123	okio/Segment:pos	I
    //   159: aload_1
    //   160: getfield 61	okio/Segment:limit	I
    //   163: aload_1
    //   164: getfield 123	okio/Segment:pos	I
    //   167: isub
    //   168: invokevirtual 504	java/security/MessageDigest:update	([BII)V
    //   171: aload_1
    //   172: getfield 109	okio/Segment:next	Lokio/Segment;
    //   175: astore_1
    //   176: goto -68 -> 108
    //   179: astore_1
    //   180: new 90	java/lang/AssertionError
    //   183: dup
    //   184: invokespecial 514	java/lang/AssertionError:<init>	()V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	Buffer
    //   31	145	1	localObject	Object
    //   179	1	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   66	85	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   60	108	179	java/security/NoSuchAlgorithmException
    //   108	150	179	java/security/NoSuchAlgorithmException
    //   150	176	179	java/security/NoSuchAlgorithmException
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 8192)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (this.head == null)
    {
      this.head = SegmentPool.take();
      localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment1 = this.head;
      localSegment3.prev = localSegment1;
      localSegment2.next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = this.head.prev;
      if (localSegment2.limit + paramInt > 8192) {
        break;
      }
      localSegment1 = localSegment2;
    } while (localSegment2.owner);
    return localSegment2.push(SegmentPool.take());
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.write(this);
    return this;
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    for (;;)
    {
      if (paramInt1 >= i)
      {
        this.size += paramInt2;
        return this;
      }
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, j);
      paramInt1 += j;
      localSegment.limit = (j + localSegment.limit);
    }
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
  {
    for (;;)
    {
      if (paramLong <= 0L) {
        return this;
      }
      long l = paramSource.read(this, paramLong);
      if (l == -1L) {
        throw new EOFException();
      }
      paramLong -= l;
    }
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    if (paramLong <= 0L) {
      return;
    }
    if (paramLong < paramBuffer.head.limit - paramBuffer.head.pos)
    {
      if (this.head != null)
      {
        localSegment1 = this.head.prev;
        if ((localSegment1 == null) || (!localSegment1.owner)) {
          break label179;
        }
        l = localSegment1.limit;
        if (!localSegment1.shared) {
          break label169;
        }
      }
      label169:
      for (int i = 0;; i = localSegment1.pos)
      {
        if (l + paramLong - i > 8192L) {
          break label179;
        }
        paramBuffer.head.writeTo(localSegment1, (int)paramLong);
        paramBuffer.size -= paramLong;
        this.size += paramLong;
        return;
        localSegment1 = null;
        break;
      }
      label179:
      paramBuffer.head = paramBuffer.head.split((int)paramLong);
    }
    Segment localSegment1 = paramBuffer.head;
    long l = localSegment1.limit - localSegment1.pos;
    paramBuffer.head = localSegment1.pop();
    if (this.head == null)
    {
      this.head = localSegment1;
      localSegment1 = this.head;
      Segment localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment2.prev = localSegment3;
      localSegment1.next = localSegment3;
    }
    for (;;)
    {
      paramBuffer.size -= l;
      this.size += l;
      paramLong -= l;
      break;
      this.head.prev.push(localSegment1).compact();
    }
  }
  
  public long writeAll(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 8192L);
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size += 1L;
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L) {
        return writeUtf8("-9223372036854775808");
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      int k;
      Segment localSegment;
      byte[] arrayOfByte;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L)
            {
              i = 1;
              k = i;
              if (j != 0) {
                k = i + 1;
              }
              localSegment = writableSegment(k);
              arrayOfByte = localSegment.data;
              i = localSegment.limit + k;
            }
          }
        }
      }
      for (;;)
      {
        if (paramLong == 0L)
        {
          if (j != 0) {
            arrayOfByte[(i - 1)] = 45;
          }
          localSegment.limit += k;
          paramLong = this.size;
          this.size = (k + paramLong);
          return this;
          i = 2;
          break;
          if (paramLong < 1000L)
          {
            i = 3;
            break;
          }
          i = 4;
          break;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L)
            {
              i = 5;
              break;
            }
            i = 6;
            break;
          }
          if (paramLong < 10000000L)
          {
            i = 7;
            break;
          }
          i = 8;
          break;
          if (paramLong < 1000000000000L)
          {
            if (paramLong < 10000000000L)
            {
              if (paramLong < 1000000000L)
              {
                i = 9;
                break;
              }
              i = 10;
              break;
            }
            if (paramLong < 100000000000L)
            {
              i = 11;
              break;
            }
            i = 12;
            break;
          }
          if (paramLong < 1000000000000000L)
          {
            if (paramLong < 10000000000000L)
            {
              i = 13;
              break;
            }
            if (paramLong < 100000000000000L)
            {
              i = 14;
              break;
            }
            i = 15;
            break;
          }
          if (paramLong < 100000000000000000L)
          {
            if (paramLong < 10000000000000000L)
            {
              i = 16;
              break;
            }
            i = 17;
            break;
          }
          if (paramLong < 1000000000000000000L)
          {
            i = 18;
            break;
          }
          i = 19;
          break;
        }
        int m = (int)(paramLong % 10L);
        i -= 1;
        arrayOfByte[i] = DIGITS[m];
        paramLong /= 10L;
      }
    }
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = writableSegment(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    for (;;)
    {
      if (i < k)
      {
        localSegment.limit += j;
        paramLong = this.size;
        this.size = (j + paramLong);
        return this;
      }
      arrayOfByte[i] = DIGITS[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramCharset.equals(Util.UTF_8)) {
      return writeUtf8(paramString);
    }
    paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
    return write(paramString, 0, paramString.length);
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream)
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream, long paramLong)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject = this.head;
    for (;;)
    {
      if (paramLong <= 0L) {
        return this;
      }
      int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
      paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
      ((Segment)localObject).pos += i;
      this.size -= i;
      long l = paramLong - i;
      paramLong = l;
      if (((Segment)localObject).pos == ((Segment)localObject).limit)
      {
        Segment localSegment = ((Segment)localObject).pop();
        this.head = localSegment;
        SegmentPool.recycle((Segment)localObject);
        localObject = localSegment;
        paramLong = l;
      }
    }
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    label540:
    for (;;)
    {
      int j = paramString.charAt(paramInt1);
      byte[] arrayOfByte;
      int k;
      int i;
      if (j < 128)
      {
        Segment localSegment = writableSegment(1);
        arrayOfByte = localSegment.data;
        k = localSegment.limit - paramInt1;
        int m = Math.min(paramInt2, 8192 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        if (paramInt1 >= m)
        {
          label204:
          i = paramInt1 + k - localSegment.limit;
          localSegment.limit += i;
          this.size += i;
        }
      }
      for (;;)
      {
        if (paramInt1 < paramInt2) {
          break label540;
        }
        return this;
        i = paramString.charAt(paramInt1);
        if (i >= 128) {
          break label204;
        }
        arrayOfByte[(paramInt1 + k)] = ((byte)i);
        paramInt1 += 1;
        break;
        if (j < 2048)
        {
          writeByte(j >> 6 | 0xC0);
          writeByte(j & 0x3F | 0x80);
          paramInt1 += 1;
        }
        else if ((j < 55296) || (j > 57343))
        {
          writeByte(j >> 12 | 0xE0);
          writeByte(j >> 6 & 0x3F | 0x80);
          writeByte(j & 0x3F | 0x80);
          paramInt1 += 1;
        }
        else
        {
          if (paramInt1 + 1 < paramInt2) {}
          for (i = paramString.charAt(paramInt1 + 1);; i = 0)
          {
            if ((j <= 56319) && (i >= 56320) && (i <= 57343)) {
              break label451;
            }
            writeByte(63);
            paramInt1 += 1;
            break;
          }
          label451:
          i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
          writeByte(i >> 18 | 0xF0);
          writeByte(i >> 12 & 0x3F | 0x80);
          writeByte(i >> 6 & 0x3F | 0x80);
          writeByte(i & 0x3F | 0x80);
          paramInt1 += 2;
        }
      }
    }
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      writeByte(paramInt >> 12 | 0xE0);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.7.0.1
 */