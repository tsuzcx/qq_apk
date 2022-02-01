package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "offset", "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k=2, mv={1, 1, 16})
public final class SegmentedByteStringKt
{
  public static final int binarySearch(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    paramInt3 -= 1;
    while (paramInt2 <= paramInt3)
    {
      int i = paramInt2 + paramInt3 >>> 1;
      int j = paramArrayOfInt[i];
      if (j < paramInt1) {
        paramInt2 = i + 1;
      } else if (j > paramInt1) {
        paramInt3 = i - 1;
      } else {
        return i;
      }
    }
    return -paramInt2 - 1;
  }
  
  public static final boolean commonEquals(@NotNull SegmentedByteString paramSegmentedByteString, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonEquals");
    if (paramObject == paramSegmentedByteString) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((paramObject.size() == paramSegmentedByteString.size()) && (paramSegmentedByteString.rangeEquals(0, paramObject, 0, paramSegmentedByteString.size()))) {
        return true;
      }
    }
    return false;
  }
  
  public static final int commonGetSize(@NotNull SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonGetSize");
    return paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length - 1)];
  }
  
  public static final int commonHashCode(@NotNull SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonHashCode");
    int i = paramSegmentedByteString.getHashCode$okio();
    if (i != 0) {
      return i;
    }
    int i2 = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      int i1 = paramSegmentedByteString.getDirectory$okio()[(i2 + k)];
      n = paramSegmentedByteString.getDirectory$okio()[k];
      byte[] arrayOfByte = paramSegmentedByteString.getSegments$okio()[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    paramSegmentedByteString.setHashCode$okio(m);
    return m;
  }
  
  public static final byte commonInternalGet(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonInternalGet");
    -Util.checkOffsetAndCount(paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length - 1)], paramInt, 1L);
    int j = segment(paramSegmentedByteString, paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = paramSegmentedByteString.getDirectory$okio()[(j - 1)];
    }
    int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + j)];
    return paramSegmentedByteString.getSegments$okio()[j][(paramInt - i + k)];
  }
  
  public static final boolean commonRangeEquals(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt1, @NotNull ByteString paramByteString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    if (paramInt1 >= 0)
    {
      if (paramInt1 > paramSegmentedByteString.size() - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = segment(paramSegmentedByteString, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
        }
        int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
        int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!paramByteString.rangeEquals(paramInt3, paramSegmentedByteString.getSegments$okio()[paramInt1], k + (paramInt2 - i), m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final boolean commonRangeEquals(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    if ((paramInt1 >= 0) && (paramInt1 <= paramSegmentedByteString.size() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = segment(paramSegmentedByteString, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
        }
        int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
        int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!-Util.arrayRangeEquals(paramSegmentedByteString.getSegments$okio()[paramInt1], k + (paramInt2 - i), paramArrayOfByte, paramInt3, m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  @NotNull
  public static final ByteString commonSubstring(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonSubstring");
    int j = 0;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= paramSegmentedByteString.size()) {
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
          if ((paramInt1 == 0) && (paramInt2 == paramSegmentedByteString.size())) {
            return (ByteString)paramSegmentedByteString;
          }
          if (paramInt1 == paramInt2) {
            return ByteString.EMPTY;
          }
          int k = segment(paramSegmentedByteString, paramInt1);
          int n = segment(paramSegmentedByteString, paramInt2 - 1);
          localObject = (byte[][])ArraysKt.copyOfRange((Object[])paramSegmentedByteString.getSegments$okio(), k, n + 1);
          Object[] arrayOfObject = (Object[])localObject;
          int[] arrayOfInt = new int[arrayOfObject.length * 2];
          if (k <= n)
          {
            i = k;
            paramInt2 = 0;
            for (;;)
            {
              arrayOfInt[paramInt2] = Math.min(paramSegmentedByteString.getDirectory$okio()[i] - paramInt1, m);
              arrayOfInt[(paramInt2 + arrayOfObject.length)] = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + i)];
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
            paramInt2 = paramSegmentedByteString.getDirectory$okio()[(k - 1)];
          }
          i = arrayOfObject.length;
          arrayOfInt[i] += paramInt1 - paramInt2;
          return (ByteString)new SegmentedByteString((byte[][])localObject, arrayOfInt);
        }
        paramSegmentedByteString = new StringBuilder();
        paramSegmentedByteString.append("endIndex=");
        paramSegmentedByteString.append(paramInt2);
        paramSegmentedByteString.append(" < beginIndex=");
        paramSegmentedByteString.append(paramInt1);
        throw ((Throwable)new IllegalArgumentException(paramSegmentedByteString.toString().toString()));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" > length(");
      ((StringBuilder)localObject).append(paramSegmentedByteString.size());
      ((StringBuilder)localObject).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    paramSegmentedByteString = new StringBuilder();
    paramSegmentedByteString.append("beginIndex=");
    paramSegmentedByteString.append(paramInt1);
    paramSegmentedByteString.append(" < 0");
    paramSegmentedByteString = (Throwable)new IllegalArgumentException(paramSegmentedByteString.toString().toString());
    for (;;)
    {
      throw paramSegmentedByteString;
    }
  }
  
  @NotNull
  public static final byte[] commonToByteArray(@NotNull SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonToByteArray");
    byte[] arrayOfByte1 = new byte[paramSegmentedByteString.size()];
    int n = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < n)
    {
      int i1 = paramSegmentedByteString.getDirectory$okio()[(n + i)];
      int m = paramSegmentedByteString.getDirectory$okio()[i];
      byte[] arrayOfByte2 = paramSegmentedByteString.getSegments$okio()[i];
      k = m - k;
      ArraysKt.copyInto(arrayOfByte2, arrayOfByte1, j, i1, i1 + k);
      j += k;
      i += 1;
      k = m;
    }
    return arrayOfByte1;
  }
  
  public static final void commonWrite(@NotNull SegmentedByteString paramSegmentedByteString, @NotNull Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    int j = paramInt2 + paramInt1;
    int i = segment(paramSegmentedByteString, paramInt1);
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 < j)
    {
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
      }
      int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
      int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
      m = Math.min(j, m - i + i) - paramInt2;
      i = k + (paramInt2 - i);
      Segment localSegment1 = new Segment(paramSegmentedByteString.getSegments$okio()[paramInt1], i, i + m, true, false);
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
    paramBuffer.setSize$okio(paramBuffer.size() + paramSegmentedByteString.size());
  }
  
  private static final void forEachSegment(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt1, int paramInt2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> paramFunction3)
  {
    int j = segment(paramSegmentedByteString, paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      if (paramInt1 == 0) {
        j = 0;
      } else {
        j = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
      }
      int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
      int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
      m = Math.min(paramInt2, m - j + j) - i;
      paramFunction3.invoke(paramSegmentedByteString.getSegments$okio()[paramInt1], Integer.valueOf(k + (i - j)), Integer.valueOf(m));
      i += m;
      paramInt1 += 1;
    }
  }
  
  public static final void forEachSegment(@NotNull SegmentedByteString paramSegmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$forEachSegment");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "action");
    int m = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = paramSegmentedByteString.getDirectory$okio()[(m + i)];
      k = paramSegmentedByteString.getDirectory$okio()[i];
      paramFunction3.invoke(paramSegmentedByteString.getSegments$okio()[i], Integer.valueOf(n), Integer.valueOf(k - j));
      i += 1;
    }
  }
  
  public static final int segment(@NotNull SegmentedByteString paramSegmentedByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$segment");
    paramInt = binarySearch(paramSegmentedByteString.getDirectory$okio(), paramInt + 1, 0, ((Object[])paramSegmentedByteString.getSegments$okio()).length);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.internal.SegmentedByteStringKt
 * JD-Core Version:    0.7.0.1
 */