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
    Segment localSegment = paramBuffer.head;
    int i = 0;
    int j = 0;
    while (j < paramInt)
    {
      if (localSegment.limit == localSegment.pos) {
        throw new AssertionError("s.limit == s.pos");
      }
      j += localSegment.limit - localSegment.pos;
      i += 1;
      localSegment = localSegment.next;
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramBuffer = paramBuffer.head;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramBuffer.data;
      k = paramBuffer.limit - paramBuffer.pos + i;
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      this.directory[j] = i;
      this.directory[(this.segments.length + j)] = paramBuffer.pos;
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
    if (((paramObject instanceof ByteString)) && (((ByteString)paramObject).size() == size()) && (rangeEquals(0, (ByteString)paramObject, 0, size()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte getByte(int paramInt)
  {
    Util.checkOffsetAndCount(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = segment(paramInt);
    if (j == 0) {}
    for (int i = 0;; i = this.directory[(j - 1)])
    {
      int k = this.directory[(this.segments.length + j)];
      return this.segments[j][(paramInt - i + k)];
    }
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    i = 1;
    int i2 = this.segments.length;
    int j = 0;
    int n;
    for (int k = 0; j < i2; k = n)
    {
      byte[] arrayOfByte = this.segments[j];
      int i1 = this.directory[(i2 + j)];
      n = this.directory[j];
      int m = i1;
      while (m < n - k + i1)
      {
        i = i * 31 + arrayOfByte[m];
        m += 1;
      }
      j += 1;
    }
    this.hashCode = i;
    return i;
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
    if ((paramInt1 < 0) || (paramInt1 > size() - paramInt3)) {
      return false;
    }
    int j = segment(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label30:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!paramByteString.rangeEquals(paramInt2, this.segments[paramInt1], i - j + m, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label30;
      }
    }
    return true;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > size() - paramInt3) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt3)) {
      return false;
    }
    int j = segment(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label43:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!Util.arrayRangeEquals(this.segments[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label43;
      }
    }
    return true;
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
    int i = 0;
    byte[] arrayOfByte = new byte[this.directory[(this.segments.length - 1)]];
    int m = this.segments.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.directory[(m + i)];
      k = this.directory[i];
      System.arraycopy(this.segments[i], n, arrayOfByte, j, k - j);
      i += 1;
    }
    return arrayOfByte;
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
    int i = 0;
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    int m = this.segments.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.directory[(m + i)];
      k = this.directory[i];
      paramOutputStream.write(this.segments[i], n, k - j);
      i += 1;
    }
  }
  
  void write(Buffer paramBuffer)
  {
    int m = this.segments.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      int n = this.directory[(m + j)];
      int k = this.directory[j];
      Segment localSegment = new Segment(this.segments[j], n, n + k - i, true, false);
      if (paramBuffer.head == null)
      {
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        paramBuffer.head = localSegment;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        paramBuffer.head.prev.push(localSegment);
      }
    }
    paramBuffer.size += i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.SegmentedByteString
 * JD-Core Version:    0.7.0.1
 */