package shark.internal.aosp;

import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/aosp/ByteArrayTimSort$Companion;", "", "()V", "DEBUG", "", "INITIAL_TMP_STORAGE_LENGTH", "", "MIN_GALLOP", "MIN_MERGE", "binarySort", "", "a", "", "lo", "hi", "start", "entrySize", "c", "Lshark/internal/aosp/ByteArrayComparator;", "checkStartAndEnd", "len", "end", "countRunAndMakeAscending", "gallopLeft", "keyArray", "keyIndex", "base", "hint", "gallopRight", "minRunLength", "n", "reverseRange", "sort", "shark-graph"}, k=1, mv={1, 4, 1})
public final class ByteArrayTimSort$Companion
{
  private final int a(int paramInt)
  {
    boolean bool = ByteArrayTimSort.b();
    int m = 0;
    int i = m;
    int j = paramInt;
    if (bool)
    {
      int k;
      if (paramInt >= 0) {
        k = 1;
      } else {
        k = 0;
      }
      i = m;
      j = paramInt;
      if (_Assertions.ENABLED) {
        if (k != 0)
        {
          i = m;
          j = paramInt;
        }
        else
        {
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
    }
    while (j >= ByteArrayTimSort.a())
    {
      i |= j & 0x1;
      j >>= 1;
    }
    return j + i;
  }
  
  private final int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ByteArrayComparator paramByteArrayComparator)
  {
    boolean bool = ByteArrayTimSort.b();
    int n = 0;
    int i;
    if (bool)
    {
      if ((paramInt3 > 0) && (paramInt4 >= 0) && (paramInt4 < paramInt3)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    int i1 = paramInt2 + paramInt4;
    int k;
    int j;
    int m;
    if (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1) > 0)
    {
      k = paramInt3 - paramInt4;
      i = 1;
      for (j = 0; (i < k) && (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1 + i) > 0); j = m)
      {
        m = i * 2 + 1;
        j = m;
        if (m <= 0) {
          j = k;
        }
        m = i;
        i = j;
      }
      m = i;
      if (i > k) {
        m = k;
      }
      i = j + paramInt4;
      paramInt4 = m + paramInt4;
    }
    else
    {
      k = paramInt4 + 1;
      i = 1;
      for (j = 0; (i < k) && (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1 - i) <= 0); j = m)
      {
        m = i * 2 + 1;
        j = m;
        if (m <= 0) {
          j = k;
        }
        m = i;
        i = j;
      }
      m = i;
      if (i > k) {
        m = k;
      }
      j = paramInt4 - j;
      i = paramInt4 - m;
      paramInt4 = j;
    }
    if (ByteArrayTimSort.b())
    {
      if ((-1 <= i) && (i < paramInt4) && (paramInt4 <= paramInt3)) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt3 == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    paramInt3 = i + 1;
    while (paramInt3 < paramInt4)
    {
      i = (paramInt4 - paramInt3 >>> 1) + paramInt3;
      if (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2 + i) > 0) {
        paramInt3 = i + 1;
      } else {
        paramInt4 = i;
      }
    }
    if (ByteArrayTimSort.b())
    {
      paramInt1 = n;
      if (paramInt3 == paramInt4) {
        paramInt1 = 1;
      }
      if (_Assertions.ENABLED)
      {
        if (paramInt1 != 0) {
          return paramInt4;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    return paramInt4;
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 >= 0) && (paramInt3 <= paramInt1))
    {
      if (paramInt2 <= paramInt3) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start > end: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" > ");
      localStringBuilder.append(paramInt3);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start < 0 || end > len. start=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", end=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", len=");
    localStringBuilder.append(paramInt1);
    throw ((Throwable)new ArrayIndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      int j = paramInt2 - 1;
      if (paramInt1 >= j) {
        break;
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt3)
      {
        int k = paramInt1 * paramInt3 + paramInt2;
        int i = paramArrayOfByte[k];
        int m = j * paramInt3 + paramInt2;
        paramArrayOfByte[k] = paramArrayOfByte[m];
        paramArrayOfByte[m] = i;
        paramInt2 += 1;
      }
      paramInt1 += 1;
      paramInt2 = j;
    }
  }
  
  private final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteArrayComparator paramByteArrayComparator)
  {
    int i = paramInt3;
    if (ByteArrayTimSort.b())
    {
      if ((paramInt1 <= i) && (i <= paramInt2)) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt3 == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    paramInt3 = i;
    if (i == paramInt1) {
      paramInt3 = i + 1;
    }
    byte[] arrayOfByte = new byte[paramInt4];
    while (paramInt3 < paramInt2)
    {
      i = 0;
      while (i < paramInt4)
      {
        arrayOfByte[i] = paramArrayOfByte[(paramInt3 * paramInt4 + i)];
        i += 1;
      }
      if (ByteArrayTimSort.b())
      {
        if (paramInt1 <= paramInt3) {
          i = 1;
        } else {
          i = 0;
        }
        if ((_Assertions.ENABLED) && (i == 0)) {
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
      int j = paramInt1;
      i = paramInt3;
      int k;
      while (j < i)
      {
        k = j + i >>> 1;
        if (paramByteArrayComparator.a(paramInt4, arrayOfByte, 0, paramArrayOfByte, k) < 0) {
          i = k;
        } else {
          j = k + 1;
        }
      }
      if (ByteArrayTimSort.b())
      {
        if (j == i) {
          i = 1;
        } else {
          i = 0;
        }
        if ((_Assertions.ENABLED) && (i == 0)) {
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
      i = paramInt3 - j;
      if (i != 1)
      {
        if (i != 2)
        {
          System.arraycopy(paramArrayOfByte, j * paramInt4, paramArrayOfByte, (j + 1) * paramInt4, i * paramInt4);
        }
        else
        {
          k = (j + 1) * paramInt4;
          i = 0;
          while (i < paramInt4)
          {
            paramArrayOfByte[((j + 2) * paramInt4 + i)] = paramArrayOfByte[(k + i)];
            i += 1;
          }
          i = 0;
          while (i < paramInt4)
          {
            paramArrayOfByte[(k + i)] = paramArrayOfByte[(j * paramInt4 + i)];
            i += 1;
          }
        }
      }
      else
      {
        i = 0;
        while (i < paramInt4)
        {
          paramArrayOfByte[((j + 1) * paramInt4 + i)] = paramArrayOfByte[(j * paramInt4 + i)];
          i += 1;
        }
      }
      i = 0;
      while (i < paramInt4)
      {
        paramArrayOfByte[(j * paramInt4 + i)] = arrayOfByte[i];
        i += 1;
      }
      paramInt3 += 1;
    }
  }
  
  private final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ByteArrayComparator paramByteArrayComparator)
  {
    if (ByteArrayTimSort.b())
    {
      if (paramInt1 < paramInt2) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    int i = paramInt1 + 1;
    if (i == paramInt2) {
      return 1;
    }
    int k = paramByteArrayComparator.a(paramInt3, paramArrayOfByte, i, paramArrayOfByte, paramInt1);
    int j = i + 1;
    i = j;
    if (k < 0)
    {
      i = j;
      while ((i < paramInt2) && (paramByteArrayComparator.a(paramInt3, paramArrayOfByte, i, paramArrayOfByte, i - 1) < 0)) {
        i += 1;
      }
      ((Companion)this).a(paramArrayOfByte, paramInt1, i, paramInt3);
      j = i;
    }
    else
    {
      for (;;)
      {
        j = i;
        if (i >= paramInt2) {
          break;
        }
        j = i;
        if (paramByteArrayComparator.a(paramInt3, paramArrayOfByte, i, paramArrayOfByte, i - 1) < 0) {
          break;
        }
        i += 1;
      }
    }
    return j - paramInt1;
  }
  
  private final int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ByteArrayComparator paramByteArrayComparator)
  {
    boolean bool = ByteArrayTimSort.b();
    int n = 0;
    int i;
    if (bool)
    {
      if ((paramInt3 > 0) && (paramInt4 >= 0) && (paramInt4 < paramInt3)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    int i1 = paramInt2 + paramInt4;
    int k;
    int j;
    int m;
    if (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1) < 0)
    {
      k = paramInt4 + 1;
      i = 1;
      for (j = 0; (i < k) && (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1 - i) < 0); j = m)
      {
        m = i * 2 + 1;
        j = m;
        if (m <= 0) {
          j = k;
        }
        m = i;
        i = j;
      }
      m = i;
      if (i > k) {
        m = k;
      }
      i = paramInt4 - m;
      paramInt4 -= j;
    }
    else
    {
      k = paramInt3 - paramInt4;
      i = 1;
      for (j = 0; (i < k) && (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, i1 + i) >= 0); j = m)
      {
        m = i * 2 + 1;
        j = m;
        if (m <= 0) {
          j = k;
        }
        m = i;
        i = j;
      }
      m = i;
      if (i > k) {
        m = k;
      }
      i = j + paramInt4;
      paramInt4 += m;
    }
    if (ByteArrayTimSort.b())
    {
      if ((-1 <= i) && (i < paramInt4) && (paramInt4 <= paramInt3)) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt3 == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    paramInt3 = i + 1;
    while (paramInt3 < paramInt4)
    {
      i = (paramInt4 - paramInt3 >>> 1) + paramInt3;
      if (paramByteArrayComparator.a(paramInt5, paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2 + i) < 0) {
        paramInt4 = i;
      } else {
        paramInt3 = i + 1;
      }
    }
    if (ByteArrayTimSort.b())
    {
      paramInt1 = n;
      if (paramInt3 == paramInt4) {
        paramInt1 = 1;
      }
      if (_Assertions.ENABLED)
      {
        if (paramInt1 != 0) {
          return paramInt4;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    return paramInt4;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @NotNull ByteArrayComparator paramByteArrayComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "a");
    Intrinsics.checkParameterIsNotNull(paramByteArrayComparator, "c");
    Companion localCompanion = (Companion)this;
    localCompanion.a(paramArrayOfByte.length / paramInt3, paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if (i < 2) {
      return;
    }
    if (i < ByteArrayTimSort.a())
    {
      localCompanion.a(paramArrayOfByte, paramInt1, paramInt2, paramInt1 + localCompanion.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramByteArrayComparator), paramInt3, paramByteArrayComparator);
      return;
    }
    ByteArrayTimSort localByteArrayTimSort = new ByteArrayTimSort(paramArrayOfByte, paramByteArrayComparator, paramInt3, null);
    int k = localCompanion.a(i);
    int j = paramInt1;
    paramInt1 = i;
    int m;
    do
    {
      m = localCompanion.b(paramArrayOfByte, j, paramInt2, paramInt3, paramByteArrayComparator);
      i = m;
      if (m < k)
      {
        if (paramInt1 <= k) {
          i = paramInt1;
        } else {
          i = k;
        }
        localCompanion.a(paramArrayOfByte, j, j + i, j + m, paramInt3, paramByteArrayComparator);
      }
      ByteArrayTimSort.a(localByteArrayTimSort, j, i);
      ByteArrayTimSort.a(localByteArrayTimSort);
      m = j + i;
      i = paramInt1 - i;
      j = m;
      paramInt1 = i;
    } while (i != 0);
    boolean bool = ByteArrayTimSort.b();
    paramInt3 = 0;
    if (bool)
    {
      if (m == paramInt2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    ByteArrayTimSort.b(localByteArrayTimSort);
    if (ByteArrayTimSort.b())
    {
      paramInt1 = paramInt3;
      if (ByteArrayTimSort.c(localByteArrayTimSort) == 1) {
        paramInt1 = 1;
      }
      if (_Assertions.ENABLED)
      {
        if (paramInt1 != 0) {
          return;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.aosp.ByteArrayTimSort.Companion
 * JD-Core Version:    0.7.0.1
 */