package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "offset", "otherOffset", "byteCount", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k=1, mv={1, 1, 16})
public final class SegmentedByteString
  extends ByteString
{
  @NotNull
  private final transient int[] directory;
  @NotNull
  private final transient byte[][] segments;
  
  public SegmentedByteString(@NotNull byte[][] paramArrayOfByte, @NotNull int[] paramArrayOfInt)
  {
    super(ByteString.EMPTY.getData$okio());
    this.segments = paramArrayOfByte;
    this.directory = paramArrayOfInt;
  }
  
  private final ByteString toByteString()
  {
    return new ByteString(toByteArray());
  }
  
  private final Object writeReplace()
  {
    ByteString localByteString = toByteString();
    if (localByteString != null) {
      return (Object)localByteString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
  }
  
  @NotNull
  public ByteBuffer asByteBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
    return localByteBuffer;
  }
  
  @NotNull
  public String base64()
  {
    return toByteString().base64();
  }
  
  @NotNull
  public String base64Url()
  {
    return toByteString().base64Url();
  }
  
  @NotNull
  public ByteString digest$okio(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString);
    int m = ((Object[])getSegments$okio()).length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = getDirectory$okio()[(m + i)];
      k = getDirectory$okio()[i];
      paramString.update(getSegments$okio()[i], n, k - j);
      i += 1;
    }
    paramString = paramString.digest();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "digest.digest()");
    return new ByteString(paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
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
  
  @NotNull
  public final int[] getDirectory$okio()
  {
    return this.directory;
  }
  
  @NotNull
  public final byte[][] getSegments$okio()
  {
    return this.segments;
  }
  
  public int getSize$okio()
  {
    return getDirectory$okio()[(((Object[])getSegments$okio()).length - 1)];
  }
  
  public int hashCode()
  {
    int i = getHashCode$okio();
    if (i != 0) {
      return i;
    }
    int i2 = ((Object[])getSegments$okio()).length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      int i1 = getDirectory$okio()[(i2 + k)];
      n = getDirectory$okio()[k];
      byte[] arrayOfByte = getSegments$okio()[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    setHashCode$okio(m);
    return m;
  }
  
  @NotNull
  public String hex()
  {
    return toByteString().hex();
  }
  
  @NotNull
  public ByteString hmac$okio(@NotNull String paramString, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      int m = ((Object[])getSegments$okio()).length;
      int j = 0;
      int k;
      for (int i = 0; j < m; i = k)
      {
        int n = getDirectory$okio()[(m + j)];
        k = getDirectory$okio()[j];
        localMac.update(getSegments$okio()[j], n, k - i);
        j += 1;
      }
      paramString = localMac.doFinal();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "mac.doFinal()");
      paramString = new ByteString(paramString);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      paramString = (Throwable)new IllegalArgumentException((Throwable)paramString);
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public int indexOf(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    return toByteString().indexOf(paramArrayOfByte, paramInt);
  }
  
  @NotNull
  public byte[] internalArray$okio()
  {
    return toByteArray();
  }
  
  public byte internalGet$okio(int paramInt)
  {
    -Util.checkOffsetAndCount(getDirectory$okio()[(((Object[])getSegments$okio()).length - 1)], paramInt, 1L);
    int j = SegmentedByteStringKt.segment(this, paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = getDirectory$okio()[(j - 1)];
    }
    int k = getDirectory$okio()[(((Object[])getSegments$okio()).length + j)];
    return getSegments$okio()[j][(paramInt - i + k)];
  }
  
  public int lastIndexOf(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    return toByteString().lastIndexOf(paramArrayOfByte, paramInt);
  }
  
  public boolean rangeEquals(int paramInt1, @NotNull ByteString paramByteString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    boolean bool = false;
    if (paramInt1 >= 0)
    {
      if (paramInt1 > size() - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = SegmentedByteStringKt.segment(this, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = getDirectory$okio()[(paramInt1 - 1)];
        }
        int m = getDirectory$okio()[paramInt1];
        int k = getDirectory$okio()[(((Object[])getSegments$okio()).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!paramByteString.rangeEquals(paramInt3, getSegments$okio()[paramInt1], k + (paramInt2 - i), m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean rangeEquals(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 <= size() - paramInt3)
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 > paramArrayOfByte.length - paramInt3) {
            return false;
          }
          int j = paramInt3 + paramInt1;
          int i = SegmentedByteStringKt.segment(this, paramInt1);
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = i;
          while (paramInt2 < j)
          {
            if (paramInt1 == 0) {
              i = 0;
            } else {
              i = getDirectory$okio()[(paramInt1 - 1)];
            }
            int m = getDirectory$okio()[paramInt1];
            int k = getDirectory$okio()[(((Object[])getSegments$okio()).length + paramInt1)];
            m = Math.min(j, m - i + i) - paramInt2;
            if (!-Util.arrayRangeEquals(getSegments$okio()[paramInt1], k + (paramInt2 - i), paramArrayOfByte, paramInt3, m)) {
              return false;
            }
            paramInt3 += m;
            paramInt2 += m;
            paramInt1 += 1;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @NotNull
  public String string(@NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return toByteString().string(paramCharset);
  }
  
  @NotNull
  public ByteString substring(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= size()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        int m = paramInt2 - paramInt1;
        if (m >= 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == size())) {
            return (ByteString)this;
          }
          if (paramInt1 == paramInt2) {
            return ByteString.EMPTY;
          }
          int k = SegmentedByteStringKt.segment(this, paramInt1);
          int n = SegmentedByteStringKt.segment(this, paramInt2 - 1);
          localObject = (byte[][])ArraysKt.copyOfRange((Object[])getSegments$okio(), k, n + 1);
          Object[] arrayOfObject = (Object[])localObject;
          int[] arrayOfInt = new int[arrayOfObject.length * 2];
          if (k <= n)
          {
            i = k;
            paramInt2 = 0;
            for (;;)
            {
              arrayOfInt[paramInt2] = Math.min(getDirectory$okio()[i] - paramInt1, m);
              arrayOfInt[(paramInt2 + arrayOfObject.length)] = getDirectory$okio()[(((Object[])getSegments$okio()).length + i)];
              if (i == n) {
                break;
              }
              i += 1;
              paramInt2 += 1;
            }
          }
          if (k == 0) {
            paramInt2 = j;
          } else {
            paramInt2 = getDirectory$okio()[(k - 1)];
          }
          i = arrayOfObject.length;
          arrayOfInt[i] += paramInt1 - paramInt2;
          return (ByteString)new SegmentedByteString((byte[][])localObject, arrayOfInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("endIndex=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" < beginIndex=");
        ((StringBuilder)localObject).append(paramInt1);
        throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" > length(");
      ((StringBuilder)localObject).append(size());
      ((StringBuilder)localObject).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("beginIndex=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" < 0");
    localObject = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public ByteString toAsciiLowercase()
  {
    return toByteString().toAsciiLowercase();
  }
  
  @NotNull
  public ByteString toAsciiUppercase()
  {
    return toByteString().toAsciiUppercase();
  }
  
  @NotNull
  public byte[] toByteArray()
  {
    byte[] arrayOfByte1 = new byte[size()];
    int n = ((Object[])getSegments$okio()).length;
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < n)
    {
      int i1 = getDirectory$okio()[(n + i)];
      int m = getDirectory$okio()[i];
      byte[] arrayOfByte2 = getSegments$okio()[i];
      k = m - k;
      ArraysKt.copyInto(arrayOfByte2, arrayOfByte1, j, i1, i1 + k);
      j += k;
      i += 1;
      k = m;
    }
    return arrayOfByte1;
  }
  
  @NotNull
  public String toString()
  {
    return toByteString().toString();
  }
  
  public void write(@NotNull OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    int m = ((Object[])getSegments$okio()).length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = getDirectory$okio()[(m + i)];
      k = getDirectory$okio()[i];
      paramOutputStream.write(getSegments$okio()[i], n, k - j);
      i += 1;
    }
  }
  
  public void write$okio(@NotNull Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    int j = paramInt2 + paramInt1;
    int i = SegmentedByteStringKt.segment(this, paramInt1);
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 < j)
    {
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = getDirectory$okio()[(paramInt1 - 1)];
      }
      int m = getDirectory$okio()[paramInt1];
      int k = getDirectory$okio()[(((Object[])getSegments$okio()).length + paramInt1)];
      m = Math.min(j, m - i + i) - paramInt2;
      i = k + (paramInt2 - i);
      Segment localSegment1 = new Segment(getSegments$okio()[paramInt1], i, i + m, true, false);
      if (paramBuffer.head == null)
      {
        localSegment1.prev = localSegment1;
        localSegment1.next = localSegment1.prev;
        paramBuffer.head = localSegment1.next;
      }
      else
      {
        Segment localSegment2 = paramBuffer.head;
        if (localSegment2 == null) {
          Intrinsics.throwNpe();
        }
        localSegment2 = localSegment2.prev;
        if (localSegment2 == null) {
          Intrinsics.throwNpe();
        }
        localSegment2.push(localSegment1);
      }
      paramInt2 += m;
      paramInt1 += 1;
    }
    paramBuffer.setSize$okio(paramBuffer.size() + size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.SegmentedByteString
 * JD-Core Version:    0.7.0.1
 */