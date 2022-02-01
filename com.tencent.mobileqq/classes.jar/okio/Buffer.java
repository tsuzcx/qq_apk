package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer
  implements Cloneable, ByteChannel, BufferedSink, BufferedSource
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  @Nullable
  Segment head;
  long size;
  
  private ByteString digest(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      if (this.head != null)
      {
        localMessageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        paramString = this.head;
        for (;;)
        {
          paramString = paramString.next;
          if (paramString == this.head) {
            break;
          }
          localMessageDigest.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        }
      }
      paramString = ByteString.of(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label97:
      break label97;
    }
    paramString = new AssertionError();
    for (;;)
    {
      throw paramString;
    }
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      if (this.head != null)
      {
        localMac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        paramString = this.head;
        for (;;)
        {
          paramString = paramString.next;
          if (paramString == this.head) {
            break;
          }
          localMac.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        }
      }
      paramString = ByteString.of(localMac.doFinal());
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
      paramString = new AssertionError();
      for (;;)
      {
        throw paramString;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label123:
      break label123;
    }
  }
  
  private boolean rangeEquals(Segment paramSegment, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    int i = paramSegment.limit;
    Object localObject = paramSegment.data;
    while (paramInt2 < paramInt3)
    {
      int j = i;
      Segment localSegment = paramSegment;
      int k = paramInt1;
      if (paramInt1 == i)
      {
        localSegment = paramSegment.next;
        paramSegment = localSegment.data;
        k = localSegment.pos;
        j = localSegment.limit;
        localObject = paramSegment;
      }
      if (localObject[k] != paramByteString.getByte(paramInt2)) {
        return false;
      }
      paramInt1 = k + 1;
      paramInt2 += 1;
      i = j;
      paramSegment = localSegment;
    }
    return true;
  }
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
  {
    if (paramInputStream != null) {
      for (;;)
      {
        if ((paramLong <= 0L) && (!paramBoolean)) {
          return;
        }
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
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 + l2);
        paramLong -= l2;
      }
    }
    paramInputStream = new IllegalArgumentException("in == null");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
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
    localBuffer.head = this.head.sharedCopy();
    Segment localSegment = localBuffer.head;
    localSegment.prev = localSegment;
    localSegment.next = localSegment;
    localSegment = this.head;
    for (;;)
    {
      localSegment = localSegment.next;
      if (localSegment == this.head) {
        break;
      }
      localBuffer.head.prev.push(localSegment.sharedCopy());
    }
    localBuffer.size = this.size;
    return localBuffer;
  }
  
  public void close() {}
  
  public final long completeSegmentByteCount()
  {
    long l2 = this.size;
    if (l2 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head.prev;
    long l1 = l2;
    if (localSegment.limit < 8192)
    {
      l1 = l2;
      if (localSegment.owner) {
        l1 = l2 - (localSegment.limit - localSegment.pos);
      }
    }
    return l1;
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream)
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
  {
    if (paramOutputStream != null)
    {
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localSegment1.limit - localSegment1.pos) {
          break;
        }
        paramLong1 -= localSegment1.limit - localSegment1.pos;
      }
      while (l2 > 0L)
      {
        int i = (int)(localSegment2.pos + l1);
        int j = (int)Math.min(localSegment2.limit - i, l2);
        paramOutputStream.write(localSegment2.data, i, j);
        l2 -= j;
        localSegment2 = localSegment2.next;
        l1 = 0L;
      }
      return this;
    }
    paramOutputStream = new IllegalArgumentException("out == null");
    for (;;)
    {
      throw paramOutputStream;
    }
  }
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer != null)
    {
      Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      paramBuffer.size += paramLong2;
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localSegment1.limit - localSegment1.pos) {
          break;
        }
        paramLong1 -= localSegment1.limit - localSegment1.pos;
      }
      while (l2 > 0L)
      {
        localSegment1 = localSegment2.sharedCopy();
        localSegment1.pos = ((int)(localSegment1.pos + l1));
        localSegment1.limit = Math.min(localSegment1.pos + (int)l2, localSegment1.limit);
        Segment localSegment3 = paramBuffer.head;
        if (localSegment3 == null)
        {
          localSegment1.prev = localSegment1;
          localSegment1.next = localSegment1;
          paramBuffer.head = localSegment1;
        }
        else
        {
          localSegment3.prev.push(localSegment1);
        }
        l2 -= localSegment1.limit - localSegment1.pos;
        localSegment2 = localSegment2.next;
        l1 = 0L;
      }
      return this;
    }
    paramBuffer = new IllegalArgumentException("out == null");
    for (;;)
    {
      throw paramBuffer;
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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    long l2 = this.size;
    if (l2 != paramObject.size) {
      return false;
    }
    long l1 = 0L;
    if (l2 == 0L) {
      return true;
    }
    Segment localSegment = this.head;
    paramObject = paramObject.head;
    int j = localSegment.pos;
    int i = paramObject.pos;
    while (l1 < this.size)
    {
      l2 = Math.min(localSegment.limit - j, paramObject.limit - i);
      int k = 0;
      while (k < l2)
      {
        if (localSegment.data[j] != paramObject.data[i]) {
          return false;
        }
        k += 1;
        j += 1;
        i += 1;
      }
      if (j == localSegment.limit)
      {
        localSegment = localSegment.next;
        j = localSegment.pos;
      }
      if (i == paramObject.limit)
      {
        paramObject = paramObject.next;
        i = paramObject.pos;
      }
      l1 += l2;
    }
    return true;
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public final byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    long l = this.size;
    if (l - paramLong > paramLong) {
      for (localObject = this.head;; localObject = ((Segment)localObject).next)
      {
        l = ((Segment)localObject).limit - ((Segment)localObject).pos;
        if (paramLong < l) {
          return localObject.data[(localObject.pos + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= l;
    Object localObject = this.head;
    Segment localSegment;
    do
    {
      localSegment = ((Segment)localObject).prev;
      l = paramLong + (localSegment.limit - localSegment.pos);
      localObject = localSegment;
      paramLong = l;
    } while (l < 0L);
    return localSegment.data[(localSegment.pos + (int)l)];
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int j;
    Segment localSegment;
    do
    {
      int k = ((Segment)localObject).pos;
      int m = ((Segment)localObject).limit;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.data[k];
        k += 1;
      }
      localSegment = ((Segment)localObject).next;
      localObject = localSegment;
      i = j;
    } while (localSegment != this.head);
    return j;
  }
  
  public final ByteString hmacSha1(ByteString paramByteString)
  {
    return hmac("HmacSHA1", paramByteString);
  }
  
  public final ByteString hmacSha256(ByteString paramByteString)
  {
    return hmac("HmacSHA256", paramByteString);
  }
  
  public final ByteString hmacSha512(ByteString paramByteString)
  {
    return hmac("HmacSHA512", paramByteString);
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
    long l1 = 0L;
    if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
    {
      long l2 = this.size;
      if (paramLong2 <= l2) {
        l2 = paramLong2;
      }
      if (paramLong1 == l2) {
        return -1L;
      }
      Object localObject2 = this.head;
      if (localObject2 == null) {
        return -1L;
      }
      long l3 = this.size;
      paramLong2 = l1;
      localObject1 = localObject2;
      if (l3 - paramLong1 < paramLong1)
      {
        l1 = l3;
        localObject1 = localObject2;
        for (;;)
        {
          localObject2 = localObject1;
          paramLong2 = l1;
          if (l1 <= paramLong1) {
            break;
          }
          localObject1 = ((Segment)localObject1).prev;
          l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
        }
      }
      for (;;)
      {
        l1 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
        localObject2 = localObject1;
        if (l1 >= paramLong1) {
          break;
        }
        localObject1 = ((Segment)localObject1).next;
        paramLong2 = l1;
      }
      while (paramLong2 < l2)
      {
        localObject1 = ((Segment)localObject2).data;
        int j = (int)Math.min(((Segment)localObject2).limit, ((Segment)localObject2).pos + l2 - paramLong2);
        int i = (int)(((Segment)localObject2).pos + paramLong1 - paramLong2);
        while (i < j)
        {
          if (localObject1[i] == paramByte) {
            return i - ((Segment)localObject2).pos + paramLong2;
          }
          i += 1;
        }
        paramLong1 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + paramLong2;
        localObject2 = ((Segment)localObject2).next;
        paramLong2 = paramLong1;
      }
      return -1L;
    }
    Object localObject1 = new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.size), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public long indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
  {
    if (paramByteString.size() != 0)
    {
      long l1 = 0L;
      if (paramLong >= 0L)
      {
        Object localObject2 = this.head;
        if (localObject2 == null) {
          return -1L;
        }
        long l2 = this.size;
        Object localObject1 = localObject2;
        if (l2 - paramLong < paramLong)
        {
          localObject1 = localObject2;
          for (;;)
          {
            localObject2 = localObject1;
            l1 = l2;
            if (l2 <= paramLong) {
              break;
            }
            localObject1 = ((Segment)localObject1).prev;
            l2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
        }
        for (;;)
        {
          l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
          localObject2 = localObject1;
          if (l2 >= paramLong) {
            break;
          }
          localObject1 = ((Segment)localObject1).next;
          l1 = l2;
        }
        int j = paramByteString.getByte(0);
        int k = paramByteString.size();
        l2 = 1L + (this.size - k);
        localObject1 = localObject2;
        while (l1 < l2)
        {
          byte[] arrayOfByte = ((Segment)localObject1).data;
          int m = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l2 - l1);
          int i = (int)(((Segment)localObject1).pos + paramLong - l1);
          localObject2 = localObject1;
          localObject1 = arrayOfByte;
          while (i < m)
          {
            if ((localObject1[i] == j) && (rangeEquals((Segment)localObject2, i + 1, paramByteString, 1, k))) {
              return i - ((Segment)localObject2).pos + l1;
            }
            i += 1;
          }
          paramLong = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
          localObject1 = ((Segment)localObject2).next;
          l1 = paramLong;
        }
        return -1L;
      }
      throw new IllegalArgumentException("fromIndex < 0");
    }
    paramByteString = new IllegalArgumentException("bytes is empty");
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
    long l1 = 0L;
    if (paramLong >= 0L)
    {
      Object localObject1 = this.head;
      if (localObject1 == null) {
        return -1L;
      }
      long l2 = this.size;
      Object localObject2 = localObject1;
      if (l2 - paramLong < paramLong)
      {
        localObject2 = localObject1;
        for (;;)
        {
          localObject1 = localObject2;
          l1 = l2;
          if (l2 <= paramLong) {
            break;
          }
          localObject2 = ((Segment)localObject2).prev;
          l2 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
        }
      }
      for (;;)
      {
        l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
        localObject1 = localObject2;
        if (l2 >= paramLong) {
          break;
        }
        localObject2 = ((Segment)localObject2).next;
        l1 = l2;
      }
      int j;
      int k;
      int i;
      int m;
      int n;
      if (paramByteString.size() == 2)
      {
        j = paramByteString.getByte(0);
        k = paramByteString.getByte(1);
        while (l1 < this.size)
        {
          paramByteString = ((Segment)localObject1).data;
          i = (int)(((Segment)localObject1).pos + paramLong - l1);
          m = ((Segment)localObject1).limit;
          while (i < m)
          {
            n = paramByteString[i];
            if ((n != j) && (n != k))
            {
              i += 1;
            }
            else
            {
              j = ((Segment)localObject1).pos;
              return i - j + l1;
            }
          }
          paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
          localObject1 = ((Segment)localObject1).next;
          l1 = paramLong;
        }
      }
      paramByteString = paramByteString.internalArray();
      for (;;)
      {
        if (l1 >= this.size) {
          break label412;
        }
        localObject2 = ((Segment)localObject1).data;
        i = (int)(((Segment)localObject1).pos + paramLong - l1);
        k = ((Segment)localObject1).limit;
        for (;;)
        {
          if (i >= k) {
            break label383;
          }
          m = localObject2[i];
          n = paramByteString.length;
          j = 0;
          for (;;)
          {
            if (j >= n) {
              break label374;
            }
            if (m == paramByteString[j])
            {
              j = ((Segment)localObject1).pos;
              break;
            }
            j += 1;
          }
          label374:
          i += 1;
        }
        label383:
        paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
        localObject1 = ((Segment)localObject1).next;
        l1 = paramLong;
      }
      label412:
      return -1L;
    }
    paramByteString = new IllegalArgumentException("fromIndex < 0");
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public InputStream inputStream()
  {
    return new Buffer.2(this);
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public final ByteString md5()
  {
    return digest("MD5");
  }
  
  public OutputStream outputStream()
  {
    return new Buffer.1(this);
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0) && (this.size - paramLong >= paramInt2))
    {
      if (paramByteString.size() - paramInt1 < paramInt2) {
        return false;
      }
      int i = 0;
      while (i < paramInt2)
      {
        if (getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    Segment localSegment = this.head;
    if (localSegment == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localSegment.limit - localSegment.pos);
    paramByteBuffer.put(localSegment.data, localSegment.pos, i);
    localSegment.pos += i;
    this.size -= i;
    if (localSegment.pos == localSegment.limit)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    return i;
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
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
    System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
    localSegment.pos += paramInt2;
    this.size -= paramInt2;
    if (localSegment.pos == localSegment.limit)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer != null)
    {
      if (paramLong >= 0L)
      {
        long l2 = this.size;
        if (l2 == 0L) {
          return -1L;
        }
        long l1 = paramLong;
        if (paramLong > l2) {
          l1 = l2;
        }
        paramBuffer.write(this, l1);
        return l1;
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
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public final Buffer.UnsafeCursor readAndWriteUnsafe()
  {
    return readAndWriteUnsafe(new Buffer.UnsafeCursor());
  }
  
  public final Buffer.UnsafeCursor readAndWriteUnsafe(Buffer.UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer == null)
    {
      paramUnsafeCursor.buffer = this;
      paramUnsafeCursor.readWrite = true;
      return paramUnsafeCursor;
    }
    throw new IllegalStateException("already attached to a buffer");
  }
  
  public byte readByte()
  {
    if (this.size != 0L)
    {
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
    throw new IllegalStateException("size == 0");
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
    if (paramLong <= 2147483647L)
    {
      localObject = new byte[(int)paramLong];
      readFully((byte[])localObject);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount > Integer.MAX_VALUE: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
    long l1 = this.size;
    long l3 = 0L;
    if (l1 != 0L)
    {
      int n = 0;
      long l2 = -7L;
      int i1 = 0;
      int i = 0;
      int j;
      int k;
      label304:
      do
      {
        localObject1 = this.head;
        Object localObject2 = ((Segment)localObject1).data;
        int m = ((Segment)localObject1).pos;
        int i2 = ((Segment)localObject1).limit;
        j = n;
        k = i1;
        l1 = l3;
        for (;;)
        {
          n = i;
          if (m >= i2) {
            break label304;
          }
          n = localObject2[m];
          if ((n >= 48) && (n <= 57))
          {
            i1 = 48 - n;
            if ((l1 >= -922337203685477580L) && ((l1 != -922337203685477580L) || (i1 >= l2)))
            {
              l1 = l1 * 10L + i1;
            }
            else
            {
              localObject1 = new Buffer().writeDecimalLong(l1).writeByte(n);
              if (k == 0) {
                ((Buffer)localObject1).readByte();
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Number too large: ");
              ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
              throw new NumberFormatException(((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if ((n != 45) || (j != 0)) {
              break;
            }
            l2 -= 1L;
            k = 1;
          }
          m += 1;
          j += 1;
        }
        if (j != 0)
        {
          n = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9] or '-' character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(n));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (m == i2)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = m;
        }
        if (n != 0) {
          break;
        }
        l3 = l1;
        i1 = k;
        i = n;
        n = j;
      } while (this.head != null);
      this.size -= j;
      if (k != 0) {
        return l1;
      }
      return -l1;
    }
    Object localObject1 = new IllegalStateException("size == 0");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public final Buffer readFrom(InputStream paramInputStream)
  {
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }
  
  public final Buffer readFrom(InputStream paramInputStream, long paramLong)
  {
    if (paramLong >= 0L)
    {
      readFrom(paramInputStream, paramLong, false);
      return this;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("byteCount < 0: ");
    paramInputStream.append(paramLong);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
  {
    long l = this.size;
    if (l >= paramLong)
    {
      paramBuffer.write(this, paramLong);
      return;
    }
    paramBuffer.write(this, l);
    throw new EOFException();
  }
  
  public void readFully(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (this.size != 0L)
    {
      int i = 0;
      long l1 = 0L;
      int m = 0;
      long l2;
      int j;
      label237:
      do
      {
        localObject1 = this.head;
        Object localObject2 = ((Segment)localObject1).data;
        int k = ((Segment)localObject1).pos;
        int n = ((Segment)localObject1).limit;
        l2 = l1;
        j = m;
        int i1;
        for (;;)
        {
          m = i;
          if (k >= n) {
            break label289;
          }
          i1 = localObject2[k];
          if ((i1 >= 48) && (i1 <= 57))
          {
            m = i1 - 48;
          }
          else
          {
            if ((i1 >= 97) && (i1 <= 102)) {}
            for (m = i1 - 97;; m = i1 - 65)
            {
              m += 10;
              break;
              if ((i1 < 65) || (i1 > 70)) {
                break label237;
              }
            }
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | m;
          k += 1;
          j += 1;
        }
        localObject1 = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
        throw new NumberFormatException(((StringBuilder)localObject2).toString());
        if (j != 0)
        {
          m = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(i1));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (k == n)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = k;
        }
        if (m != 0) {
          break;
        }
        i = m;
        m = j;
        l1 = l2;
      } while (this.head != null);
      label289:
      this.size -= j;
      return l2;
    }
    Object localObject1 = new IllegalStateException("size == 0");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public int readInt()
  {
    if (this.size >= 4L)
    {
      localObject = this.head;
      int j = ((Segment)localObject).pos;
      int i = ((Segment)localObject).limit;
      if (i - j < 4) {
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
      }
      byte[] arrayOfByte = ((Segment)localObject).data;
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
        this.head = ((Segment)localObject).pop();
        SegmentPool.recycle((Segment)localObject);
        return j;
      }
      ((Segment)localObject).pos = n;
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 4: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    if (this.size >= 8L)
    {
      localObject = this.head;
      int k = ((Segment)localObject).pos;
      int i = ((Segment)localObject).limit;
      if (i - k < 8) {
        return (readInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & readInt();
      }
      byte[] arrayOfByte = ((Segment)localObject).data;
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
      l1 = arrayOfByte[j] & 0xFF | (l7 & 0xFF) << 8 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16;
      this.size -= 8L;
      if (k == i)
      {
        this.head = ((Segment)localObject).pop();
        SegmentPool.recycle((Segment)localObject);
        return l1;
      }
      ((Segment)localObject).pos = k;
      return l1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 8: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    if (this.size >= 2L)
    {
      localObject = this.head;
      int k = ((Segment)localObject).pos;
      int i = ((Segment)localObject).limit;
      if (i - k < 2) {
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      }
      byte[] arrayOfByte = ((Segment)localObject).data;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.size -= 2L;
      if (m == i)
      {
        this.head = ((Segment)localObject).pop();
        SegmentPool.recycle((Segment)localObject);
      }
      else
      {
        ((Segment)localObject).pos = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 2: ");
    ((StringBuilder)localObject).append(this.size);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        Segment localSegment = this.head;
        if (localSegment.pos + paramLong > localSegment.limit) {
          return new String(readByteArray(paramLong), paramCharset);
        }
        paramCharset = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
        localSegment.pos = ((int)(localSegment.pos + paramLong));
        this.size -= paramLong;
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.recycle(localSegment);
        }
        return paramCharset;
      }
      paramCharset = new StringBuilder();
      paramCharset.append("byteCount > Integer.MAX_VALUE: ");
      paramCharset.append(paramLong);
      throw new IllegalArgumentException(paramCharset.toString());
    }
    throw new IllegalArgumentException("charset == null");
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
  
  public final Buffer.UnsafeCursor readUnsafe()
  {
    return readUnsafe(new Buffer.UnsafeCursor());
  }
  
  public final Buffer.UnsafeCursor readUnsafe(Buffer.UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer == null)
    {
      paramUnsafeCursor.buffer = this;
      paramUnsafeCursor.readWrite = false;
      return paramUnsafeCursor;
    }
    throw new IllegalStateException("already attached to a buffer");
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
    if (this.size != 0L)
    {
      int n = getByte(0L);
      int m = 1;
      int i;
      int j;
      int k;
      if ((n & 0x80) == 0)
      {
        i = n & 0x7F;
        j = 1;
        k = 0;
      }
      else if ((n & 0xE0) == 192)
      {
        i = n & 0x1F;
        j = 2;
        k = 128;
      }
      else if ((n & 0xF0) == 224)
      {
        i = n & 0xF;
        j = 3;
        k = 2048;
      }
      else
      {
        if ((n & 0xF8) != 240) {
          break label326;
        }
        i = n & 0x7;
        j = 4;
        k = 65536;
      }
      long l2 = this.size;
      long l1 = j;
      if (l2 >= l1)
      {
        while (m < j)
        {
          l2 = m;
          n = getByte(l2);
          if ((n & 0xC0) == 128)
          {
            i = i << 6 | n & 0x3F;
            m += 1;
          }
          else
          {
            skip(l2);
            return 65533;
          }
        }
        skip(l1);
        if (i > 1114111) {
          return 65533;
        }
        if ((i >= 55296) && (i <= 57343)) {
          return 65533;
        }
        if (i < k) {
          return 65533;
        }
        return i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size < ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(this.size);
      ((StringBuilder)localObject).append(" (to read code point prefixed 0x");
      ((StringBuilder)localObject).append(Integer.toHexString(n));
      ((StringBuilder)localObject).append(")");
      throw new EOFException(((StringBuilder)localObject).toString());
      label326:
      skip(1L);
      return 65533;
    }
    Object localObject = new EOFException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public String readUtf8Line()
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      l = this.size;
      if (l != 0L) {
        return readUtf8(l);
      }
      return null;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (getByte(l) == 13)
      {
        str = readUtf8(l);
        skip(2L);
        return str;
      }
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
  {
    return readUtf8LineStrict(9223372036854775807L);
  }
  
  public String readUtf8LineStrict(long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 != -1L) {
        return readUtf8Line(l2);
      }
      if ((l1 < size()) && (getByte(l1 - 1L) == 13) && (getByte(l1) == 10)) {
        return readUtf8Line(l1);
      }
      localObject = new Buffer();
      copyTo((Buffer)localObject, 0L, Math.min(32L, size()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(size(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(((Buffer)localObject).readByteString().hex());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
  {
    if (this.size >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  List<Integer> segmentSizes()
  {
    if (this.head == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    Segment localSegment = this.head;
    for (;;)
    {
      localSegment = localSegment.next;
      if (localSegment == this.head) {
        break;
      }
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
    return localArrayList;
  }
  
  public int select(Options paramOptions)
  {
    int i = selectPrefix(paramOptions, false);
    if (i == -1) {
      return -1;
    }
    long l = paramOptions.byteStrings[i].size();
    try
    {
      skip(l);
      return i;
    }
    catch (EOFException paramOptions)
    {
      label32:
      break label32;
    }
    throw new AssertionError();
  }
  
  int selectPrefix(Options paramOptions, boolean paramBoolean)
  {
    Segment localSegment = this.head;
    if (localSegment == null)
    {
      if (paramBoolean) {
        return -2;
      }
      return paramOptions.indexOf(ByteString.EMPTY);
    }
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.pos;
    int i = localSegment.limit;
    int[] arrayOfInt = paramOptions.trie;
    int m = -1;
    paramOptions = localSegment;
    int k = 0;
    int i1 = k + 1;
    int i4 = arrayOfInt[k];
    int n = i1 + 1;
    k = arrayOfInt[i1];
    if (k != -1) {
      m = k;
    }
    Options localOptions;
    if (paramOptions != null)
    {
      if (i4 < 0)
      {
        k = n;
        i1 = i;
        localOptions = paramOptions;
      }
    }
    else {
      for (;;)
      {
        int i3 = j + 1;
        i = arrayOfByte[j];
        int i2 = k + 1;
        if ((i & 0xFF) != arrayOfInt[k]) {
          return m;
        }
        if (i2 == n + i4 * -1) {
          j = 1;
        } else {
          j = 0;
        }
        i = i3;
        paramOptions = localOptions;
        k = i1;
        if (i3 == i1)
        {
          paramOptions = localOptions.next;
          i = paramOptions.pos;
          arrayOfByte = paramOptions.data;
          k = paramOptions.limit;
          if (paramOptions == localSegment)
          {
            if (j == 0)
            {
              if (paramBoolean) {
                return -2;
              }
              return m;
            }
            paramOptions = null;
          }
        }
        if (j != 0)
        {
          n = arrayOfInt[i2];
          j = i;
          i = k;
          break;
        }
        j = i;
        i = i2;
        localOptions = paramOptions;
        i1 = k;
        k = i;
      }
    }
    k = j + 1;
    i1 = arrayOfByte[j];
    j = n;
    for (;;)
    {
      if (j == n + i4) {
        return m;
      }
      if ((i1 & 0xFF) == arrayOfInt[j])
      {
        n = arrayOfInt[(j + i4)];
        if (k == i)
        {
          paramOptions = paramOptions.next;
          j = paramOptions.pos;
          arrayOfByte = paramOptions.data;
          i = paramOptions.limit;
          if (paramOptions == localSegment) {
            paramOptions = null;
          }
        }
        else
        {
          j = k;
        }
        if (n >= 0) {
          return n;
        }
        k = -n;
        break;
      }
      j += 1;
    }
  }
  
  public final ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public final ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public final ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  public final long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
  {
    while (paramLong > 0L)
    {
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        int i = (int)Math.min(paramLong, localSegment.limit - this.head.pos);
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 - l2);
        l1 = paramLong - l2;
        localSegment = this.head;
        localSegment.pos += i;
        paramLong = l1;
        if (this.head.pos == this.head.limit)
        {
          localSegment = this.head;
          this.head = localSegment.pop();
          SegmentPool.recycle(localSegment);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public final ByteString snapshot()
  {
    long l = this.size;
    if (l <= 2147483647L) {
      return snapshot((int)l);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Integer.MAX_VALUE: ");
    localStringBuilder.append(this.size);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final ByteString snapshot(int paramInt)
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
  
  public String toString()
  {
    return snapshot().toString();
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 8192))
    {
      Object localObject = this.head;
      if (localObject == null)
      {
        this.head = SegmentPool.take();
        localObject = this.head;
        ((Segment)localObject).prev = ((Segment)localObject);
        ((Segment)localObject).next = ((Segment)localObject);
        return localObject;
      }
      Segment localSegment = ((Segment)localObject).prev;
      if (localSegment.limit + paramInt <= 8192)
      {
        localObject = localSegment;
        if (localSegment.owner) {}
      }
      else
      {
        localObject = localSegment.push(SegmentPool.take());
      }
      return localObject;
    }
    throw new IllegalArgumentException();
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      int j = paramByteBuffer.remaining();
      int i = j;
      while (i > 0)
      {
        Segment localSegment = writableSegment(1);
        int k = Math.min(i, 8192 - localSegment.limit);
        paramByteBuffer.get(localSegment.data, localSegment.limit, k);
        i -= k;
        localSegment.limit += k;
      }
      this.size += j;
      return j;
    }
    paramByteBuffer = new IllegalArgumentException("source == null");
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      paramByteString.write(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      Util.checkOffsetAndCount(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        Segment localSegment = writableSegment(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localSegment.limit);
        System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, i);
        paramInt1 += i;
        localSegment.limit += i;
      }
      this.size += l3;
      return this;
    }
    paramArrayOfByte = new IllegalArgumentException("source == null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
  {
    while (paramLong > 0L)
    {
      long l = paramSource.read(this, paramLong);
      if (l != -1L) {
        paramLong -= l;
      } else {
        throw new EOFException();
      }
    }
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer != null)
    {
      if (paramBuffer != this)
      {
        Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
        while (paramLong > 0L)
        {
          if (paramLong < paramBuffer.head.limit - paramBuffer.head.pos)
          {
            localSegment1 = this.head;
            if (localSegment1 != null) {
              localSegment1 = localSegment1.prev;
            } else {
              localSegment1 = null;
            }
            if ((localSegment1 != null) && (localSegment1.owner))
            {
              l = localSegment1.limit;
              int i;
              if (localSegment1.shared) {
                i = 0;
              } else {
                i = localSegment1.pos;
              }
              if (l + paramLong - i <= 8192L)
              {
                paramBuffer.head.writeTo(localSegment1, (int)paramLong);
                paramBuffer.size -= paramLong;
                this.size += paramLong;
                return;
              }
            }
            paramBuffer.head = paramBuffer.head.split((int)paramLong);
          }
          Segment localSegment1 = paramBuffer.head;
          long l = localSegment1.limit - localSegment1.pos;
          paramBuffer.head = localSegment1.pop();
          Segment localSegment2 = this.head;
          if (localSegment2 == null)
          {
            this.head = localSegment1;
            localSegment1 = this.head;
            localSegment1.prev = localSegment1;
            localSegment1.next = localSegment1;
          }
          else
          {
            localSegment2.prev.push(localSegment1).compact();
          }
          paramBuffer.size -= l;
          this.size += l;
          paramLong -= l;
        }
        return;
      }
      throw new IllegalArgumentException("source == this");
    }
    paramBuffer = new IllegalArgumentException("source == null");
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public long writeAll(Source paramSource)
  {
    if (paramSource != null)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        l2 = paramSource.read(this, 8192L);
        if (l2 == -1L) {
          break;
        }
      }
      return l1;
    }
    paramSource = new IllegalArgumentException("source == null");
    for (;;)
    {
      throw paramSource;
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
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    int k = i;
    if (j != 0) {
      k = i + 1;
    }
    Segment localSegment = writableSegment(k);
    byte[] arrayOfByte = localSegment.data;
    i = localSegment.limit + k;
    while (l != 0L)
    {
      int m = (int)(l % 10L);
      i -= 1;
      arrayOfByte[i] = DIGITS[m];
      l /= 10L;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = 45;
    }
    localSegment.limit += k;
    this.size += k;
    return this;
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
    while (i >= k)
    {
      arrayOfByte[i] = DIGITS[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.limit += j;
    this.size += j;
    return this;
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
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            if (paramCharset != null)
            {
              if (paramCharset.equals(Util.UTF_8)) {
                return writeUtf8(paramString, paramInt1, paramInt2);
              }
              paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return write(paramString, 0, paramString.length);
            }
            throw new IllegalArgumentException("charset == null");
          }
          paramCharset = new StringBuilder();
          paramCharset.append("endIndex > string.length: ");
          paramCharset.append(paramInt2);
          paramCharset.append(" > ");
          paramCharset.append(paramString.length());
          throw new IllegalArgumentException(paramCharset.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalAccessError(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream)
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream, long paramLong)
  {
    if (paramOutputStream != null)
    {
      Util.checkOffsetAndCount(this.size, 0L, paramLong);
      Object localObject = this.head;
      while (paramLong > 0L)
      {
        int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
        paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
        ((Segment)localObject).pos += i;
        long l1 = this.size;
        long l2 = i;
        this.size = (l1 - l2);
        l1 = paramLong - l2;
        paramLong = l1;
        if (((Segment)localObject).pos == ((Segment)localObject).limit)
        {
          Segment localSegment = ((Segment)localObject).pop();
          this.head = localSegment;
          SegmentPool.recycle((Segment)localObject);
          localObject = localSegment;
          paramLong = l1;
        }
      }
      return this;
    }
    paramOutputStream = new IllegalArgumentException("out == null");
    for (;;)
    {
      throw paramOutputStream;
    }
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            while (paramInt1 < paramInt2)
            {
              int k = paramString.charAt(paramInt1);
              int j;
              int i;
              if (k < 128)
              {
                localObject = writableSegment(1);
                byte[] arrayOfByte = ((Segment)localObject).data;
                j = ((Segment)localObject).limit - paramInt1;
                int m = Math.min(paramInt2, 8192 - j);
                i = paramInt1 + 1;
                arrayOfByte[(paramInt1 + j)] = ((byte)k);
                paramInt1 = i;
                while (paramInt1 < m)
                {
                  i = paramString.charAt(paramInt1);
                  if (i >= 128) {
                    break;
                  }
                  arrayOfByte[(paramInt1 + j)] = ((byte)i);
                  paramInt1 += 1;
                }
                i = j + paramInt1 - ((Segment)localObject).limit;
                ((Segment)localObject).limit += i;
                this.size += i;
              }
              else
              {
                if (k < 2048)
                {
                  writeByte(k >> 6 | 0xC0);
                  writeByte(k & 0x3F | 0x80);
                }
                for (;;)
                {
                  paramInt1 += 1;
                  break;
                  if ((k >= 55296) && (k <= 57343))
                  {
                    j = paramInt1 + 1;
                    if (j < paramInt2) {
                      i = paramString.charAt(j);
                    } else {
                      i = 0;
                    }
                    if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                    {
                      i = ((k & 0xFFFF27FF) << 10 | 0xFFFF23FF & i) + 65536;
                      writeByte(i >> 18 | 0xF0);
                      writeByte(i >> 12 & 0x3F | 0x80);
                      writeByte(i >> 6 & 0x3F | 0x80);
                      writeByte(i & 0x3F | 0x80);
                      paramInt1 += 2;
                      break;
                    }
                    writeByte(63);
                    paramInt1 = j;
                    break;
                  }
                  writeByte(k >> 12 | 0xE0);
                  writeByte(k >> 6 & 0x3F | 0x80);
                  writeByte(k & 0x3F | 0x80);
                }
              }
            }
            return this;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("endIndex > string.length: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(paramString.length());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    paramString = new IllegalArgumentException("string == null");
    for (;;)
    {
      throw paramString;
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
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        writeByte(63);
        return this;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected code point: ");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.7.0.1
 */