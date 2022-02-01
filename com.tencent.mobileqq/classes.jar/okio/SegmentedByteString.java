package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(Buffer paramBuffer, int paramInt)
  {
    super(null);
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramInt);
    Object localObject = paramBuffer.head;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (((Segment)localObject).limit != ((Segment)localObject).pos)
      {
        j += ((Segment)localObject).limit - ((Segment)localObject).pos;
        i += 1;
        localObject = ((Segment)localObject).next;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramBuffer = paramBuffer.head;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramBuffer.data;
      k = i + (paramBuffer.limit - paramBuffer.pos);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      localObject = this.directory;
      localObject[j] = i;
      localObject[(this.segments.length + j)] = paramBuffer.pos;
      paramBuffer.shared = true;
      j += 1;
      paramBuffer = paramBuffer.next;
    }
  }
  
  private int segment(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private ByteString toByteString()
  {
    return new ByteString(toByteArray());
  }
  
  private Object writeReplace()
  {
    return toByteString();
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return toByteString().base64();
  }
  
  public String base64Url()
  {
    return toByteString().base64Url();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((paramObject.size() == size()) && (rangeEquals(0, paramObject, 0, size()))) {
        return true;
      }
    }
    return false;
  }
  
  public byte getByte(int paramInt)
  {
    Util.checkOffsetAndCount(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = segment(paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = this.directory[(j - 1)];
    }
    int[] arrayOfInt = this.directory;
    byte[][] arrayOfByte = this.segments;
    int k = arrayOfInt[(arrayOfByte.length + j)];
    return arrayOfByte[j][(paramInt - i + k)];
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    int i2 = this.segments.length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      byte[] arrayOfByte = this.segments[k];
      int[] arrayOfInt = this.directory;
      int i1 = arrayOfInt[(i2 + k)];
      n = arrayOfInt[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    this.hashCode = m;
    return m;
  }
  
  public String hex()
  {
    return toByteString().hex();
  }
  
  public ByteString hmacSha1(ByteString paramByteString)
  {
    return toByteString().hmacSha1(paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString)
  {
    return toByteString().hmacSha256(paramByteString);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return toByteString().indexOf(paramArrayOfByte, paramInt);
  }
  
  byte[] internalArray()
  {
    return toByteArray();
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return toByteString().lastIndexOf(paramArrayOfByte, paramInt);
  }
  
  public ByteString md5()
  {
    return toByteString().md5();
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 > size() - paramInt3) {
        return false;
      }
      int j = segment(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
        if (!paramByteString.rangeEquals(paramInt2, arrayOfByte[paramInt1], i - j + m, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= size() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = segment(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
        if (!Util.arrayRangeEquals(arrayOfByte[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public ByteString sha1()
  {
    return toByteString().sha1();
  }
  
  public ByteString sha256()
  {
    return toByteString().sha256();
  }
  
  public int size()
  {
    return this.directory[(this.segments.length - 1)];
  }
  
  public String string(Charset paramCharset)
  {
    return toByteString().string(paramCharset);
  }
  
  public ByteString substring(int paramInt)
  {
    return toByteString().substring(paramInt);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    return toByteString().substring(paramInt1, paramInt2);
  }
  
  public ByteString toAsciiLowercase()
  {
    return toByteString().toAsciiLowercase();
  }
  
  public ByteString toAsciiUppercase()
  {
    return toByteString().toAsciiUppercase();
  }
  
  public byte[] toByteArray()
  {
    Object localObject2 = this.directory;
    Object localObject1 = this.segments;
    localObject2 = new byte[localObject2[(localObject1.length - 1)]];
    int m = localObject1.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject1 = this.directory;
      int n = localObject1[(m + i)];
      k = localObject1[i];
      System.arraycopy(this.segments[i], n, localObject2, j, k - j);
      i += 1;
    }
    return localObject2;
  }
  
  public String toString()
  {
    return toByteString().toString();
  }
  
  public String utf8()
  {
    return toByteString().utf8();
  }
  
  public void write(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null)
    {
      int m = this.segments.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        int[] arrayOfInt = this.directory;
        int n = arrayOfInt[(m + i)];
        k = arrayOfInt[i];
        paramOutputStream.write(this.segments[i], n, k - j);
        i += 1;
      }
      return;
    }
    paramOutputStream = new IllegalArgumentException("out == null");
    for (;;)
    {
      throw paramOutputStream;
    }
  }
  
  void write(Buffer paramBuffer)
  {
    int m = this.segments.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = this.directory;
      int n = localObject[(m + i)];
      k = localObject[i];
      localObject = new Segment(this.segments[i], n, n + k - j, true, false);
      if (paramBuffer.head == null)
      {
        ((Segment)localObject).prev = ((Segment)localObject);
        ((Segment)localObject).next = ((Segment)localObject);
        paramBuffer.head = ((Segment)localObject);
      }
      else
      {
        paramBuffer.head.prev.push((Segment)localObject);
      }
      i += 1;
    }
    paramBuffer.size += j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.SegmentedByteString
 * JD-Core Version:    0.7.0.1
 */