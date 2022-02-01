package shark.internal.aosp;

import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/aosp/ByteArrayTimSort;", "", "a", "", "c", "Lshark/internal/aosp/ByteArrayComparator;", "entrySize", "", "([BLshark/internal/aosp/ByteArrayComparator;I)V", "minGallop", "runBase", "", "runLen", "stackSize", "tmp", "ensureCapacity", "minCapacity", "mergeAt", "", "i", "mergeCollapse", "mergeForceCollapse", "mergeHi", "base1", "len1", "base2", "len2", "mergeLo", "pushRun", "Companion", "shark-graph"}, k=1, mv={1, 4, 1})
public final class ByteArrayTimSort
{
  @NotNull
  public static final ByteArrayTimSort.Companion a = new ByteArrayTimSort.Companion(null);
  private static final int j = 32;
  private static final int k = 7;
  private static final int l = 256;
  private static final boolean m = false;
  private int b;
  private byte[] c;
  private int d;
  private final int[] e;
  private final int[] f;
  private final byte[] g;
  private final ByteArrayComparator h;
  private final int i;
  
  private ByteArrayTimSort(byte[] paramArrayOfByte, ByteArrayComparator paramByteArrayComparator, int paramInt)
  {
    this.g = paramArrayOfByte;
    this.h = paramByteArrayComparator;
    this.i = paramInt;
    this.b = k;
    paramInt = this.g.length;
    int i1 = this.i;
    int i2 = paramInt / i1;
    int n = l;
    paramInt = n;
    if (i2 < n * 2) {
      paramInt = i2 >>> 1;
    }
    this.c = new byte[i1 * paramInt];
    if (i2 < 120) {
      paramInt = 5;
    } else if (i2 < 1542) {
      paramInt = 10;
    } else if (i2 < 119151) {
      paramInt = 19;
    } else {
      paramInt = 40;
    }
    this.e = new int[paramInt];
    this.f = new int[paramInt];
  }
  
  private final void a(int paramInt)
  {
    boolean bool = m;
    int i1 = 0;
    if (bool)
    {
      if (this.d >= 2) {
        n = 1;
      } else {
        n = 0;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    if (m)
    {
      if (paramInt >= 0) {
        n = 1;
      } else {
        n = 0;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    if (m)
    {
      n = this.d;
      if ((paramInt != n - 2) && (paramInt != n - 3)) {
        n = 0;
      } else {
        n = 1;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    Object localObject1 = this.e;
    int i5 = localObject1[paramInt];
    Object localObject2 = this.f;
    int i4 = localObject2[paramInt];
    int i6 = paramInt + 1;
    int i2 = localObject1[i6];
    int i3 = localObject2[i6];
    if (m)
    {
      if ((i4 > 0) && (i3 > 0)) {
        n = 1;
      } else {
        n = 0;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    if (m)
    {
      if (i5 + i4 == i2) {
        n = 1;
      } else {
        n = 0;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    localObject1 = this.f;
    localObject1[paramInt] = (i4 + i3);
    if (paramInt == this.d - 3)
    {
      localObject2 = this.e;
      paramInt += 2;
      localObject2[i6] = localObject2[paramInt];
      localObject1[i6] = localObject1[paramInt];
    }
    this.d -= 1;
    localObject1 = a;
    localObject2 = this.g;
    int n = ByteArrayTimSort.Companion.a((ByteArrayTimSort.Companion)localObject1, (byte[])localObject2, i2, (byte[])localObject2, i5, i4, 0, this.i, this.h);
    if (m)
    {
      if (n >= 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    i5 += n;
    n = i4 - n;
    if (n == 0) {
      return;
    }
    localObject1 = a;
    localObject2 = this.g;
    i3 = ByteArrayTimSort.Companion.b((ByteArrayTimSort.Companion)localObject1, (byte[])localObject2, i5 + n - 1, (byte[])localObject2, i2, i3, i3 - 1, this.i, this.h);
    if (m)
    {
      paramInt = i1;
      if (i3 >= 0) {
        paramInt = 1;
      }
      if ((_Assertions.ENABLED) && (paramInt == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    if (i3 == 0) {
      return;
    }
    if (n <= i3)
    {
      a(i5, n, i2, i3);
      return;
    }
    b(i5, n, i2, i3);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.e;
    int n = this.d;
    arrayOfInt[n] = paramInt1;
    this.f[n] = paramInt2;
    this.d = (n + 1);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = m;
    int i2 = 0;
    if (bool)
    {
      if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt1 + paramInt2 == paramInt3)) {
        n = 1;
      } else {
        n = 0;
      }
      if ((_Assertions.ENABLED) && (n == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    byte[] arrayOfByte = this.g;
    int i1 = this.i;
    Object localObject1 = b(paramInt2);
    int i3 = paramInt1 * i1;
    int i4 = paramInt2 * i1;
    System.arraycopy(arrayOfByte, i3, localObject1, 0, i4);
    int n = 0;
    while (n < i1)
    {
      arrayOfByte[(i3 + n)] = arrayOfByte[(paramInt3 * i1 + n)];
      n += 1;
    }
    n = paramInt1 + 1;
    i3 = paramInt3 + 1;
    paramInt3 = paramInt4 - 1;
    if (paramInt3 == 0)
    {
      System.arraycopy(localObject1, i1 * 0, arrayOfByte, n * i1, i4);
      return;
    }
    if (paramInt2 == 1)
    {
      System.arraycopy(arrayOfByte, i3 * i1, arrayOfByte, n * i1, paramInt3 * i1);
      paramInt1 = i2;
      while (paramInt1 < i1)
      {
        arrayOfByte[((n + paramInt3) * i1 + paramInt1)] = localObject1[(i1 * 0 + paramInt1)];
        paramInt1 += 1;
      }
      return;
    }
    ByteArrayComparator localByteArrayComparator = this.h;
    i4 = this.b;
    paramInt4 = paramInt2;
    i2 = 0;
    paramInt1 = i1;
    paramInt2 = i4;
    i1 = i3;
    i4 = i2;
    i2 = i1;
    i1 = paramInt4;
    paramInt4 = paramInt3;
    int i6 = 0;
    i3 = 0;
    paramInt3 = n;
    n = i4;
    for (;;)
    {
      if (m)
      {
        if ((i1 > 1) && (paramInt4 > 0)) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if ((_Assertions.ENABLED) && (i4 == 0)) {
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
      if (localByteArrayComparator.a(paramInt1, arrayOfByte, i2, (byte[])localObject1, n) < 0)
      {
        i4 = 0;
        while (i4 < paramInt1)
        {
          arrayOfByte[(paramInt3 * paramInt1 + i4)] = arrayOfByte[(i2 * paramInt1 + i4)];
          i4 += 1;
        }
        paramInt3 += 1;
        i4 = i2 + 1;
        i3 += 1;
        paramInt4 -= 1;
        if (paramInt4 == 0)
        {
          i2 = i4;
        }
        else
        {
          i6 = 0;
          i2 = paramInt4;
          i5 = n;
          break label563;
        }
      }
      else
      {
        i3 = 0;
        while (i3 < paramInt1)
        {
          arrayOfByte[(paramInt3 * paramInt1 + i3)] = localObject1[(n * paramInt1 + i3)];
          i3 += 1;
        }
        paramInt3 += 1;
        n += 1;
        i6 += 1;
        i1 -= 1;
        if (i1 != 1) {
          break label548;
        }
      }
      i3 = paramInt4;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      i4 = i1;
      i1 = n;
      paramInt2 = i2;
      break label1034;
      label548:
      i3 = 0;
      i4 = i2;
      int i5 = n;
      i2 = paramInt4;
      label563:
      if ((i6 | i3) >= paramInt2)
      {
        n = paramInt3;
        i3 = i4;
        i6 = paramInt1;
        Object localObject2 = localObject1;
        paramInt4 = paramInt2;
        paramInt2 = i2;
        i4 = i1;
        for (;;)
        {
          if (m)
          {
            if ((i4 > 1) && (paramInt2 > 0)) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
              throw ((Throwable)new AssertionError("Assertion failed"));
            }
          }
          ByteArrayTimSort.Companion localCompanion = a;
          localObject1 = localObject2;
          paramInt3 = i6;
          int i7 = ByteArrayTimSort.Companion.a(localCompanion, arrayOfByte, i3, localObject2, i5, i4, 0, i6, localByteArrayComparator);
          i2 = i4;
          i1 = i5;
          paramInt1 = n;
          if (i7 != 0)
          {
            System.arraycopy(localObject1, i5 * paramInt3, arrayOfByte, n * paramInt3, i7 * paramInt3);
            i6 = n + i7;
            i5 += i7;
            n = i4 - i7;
            i2 = n;
            i1 = i5;
            paramInt1 = i6;
            if (n <= 1)
            {
              paramInt1 = i6;
              i1 = i5;
              i2 = n;
              i4 = paramInt2;
              n = paramInt1;
              paramInt2 = i3;
              i3 = i4;
            }
          }
          for (;;)
          {
            paramInt1 = paramInt4;
            i4 = i2;
            paramInt4 = paramInt3;
            paramInt3 = n;
            break label1034;
            n = 0;
            while (n < paramInt3)
            {
              arrayOfByte[(paramInt1 * paramInt3 + n)] = arrayOfByte[(i3 * paramInt3 + n)];
              n += 1;
            }
            i5 = paramInt1 + 1;
            i3 += 1;
            i4 = paramInt2 - 1;
            if (i4 == 0)
            {
              paramInt1 = i5;
              paramInt2 = i4;
            }
            for (;;)
            {
              break;
              i6 = ByteArrayTimSort.Companion.b(a, (byte[])localObject1, i1, arrayOfByte, i3, i4, 0, paramInt3, localByteArrayComparator);
              paramInt2 = i4;
              paramInt1 = i3;
              n = i5;
              if (i6 == 0) {
                break label960;
              }
              System.arraycopy(arrayOfByte, i3 * paramInt3, arrayOfByte, i5 * paramInt3, i6 * paramInt3);
              i5 += i6;
              i3 += i6;
              i4 -= i6;
              paramInt2 = i4;
              paramInt1 = i3;
              n = i5;
              if (i4 != 0) {
                break label960;
              }
              paramInt2 = i4;
              paramInt1 = i5;
            }
            label960:
            i3 = 0;
            while (i3 < paramInt3)
            {
              arrayOfByte[(n * paramInt3 + i3)] = localObject1[(i1 * paramInt3 + i3)];
              i3 += 1;
            }
            n += 1;
            i1 += 1;
            i4 = i2 - 1;
            if (i4 != 1) {
              break label1287;
            }
            i2 = i4;
            i3 = paramInt2;
            paramInt2 = paramInt1;
          }
          n = paramInt1;
          if (paramInt1 < 1) {
            n = 1;
          }
          this.b = n;
          if (i4 == 1)
          {
            if (m)
            {
              if (i3 > 0) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            System.arraycopy(arrayOfByte, paramInt2 * paramInt4, arrayOfByte, paramInt3 * paramInt4, i3 * paramInt4);
            paramInt1 = 0;
            while (paramInt1 < paramInt4)
            {
              arrayOfByte[((paramInt3 + i3) * paramInt4 + paramInt1)] = localObject1[(i1 * paramInt4 + paramInt1)];
              paramInt1 += 1;
            }
          }
          if (i4 != 0)
          {
            if (m)
            {
              if (i3 == 0) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            if (m)
            {
              if (i4 > 1) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            System.arraycopy(localObject1, i1 * paramInt4, arrayOfByte, paramInt3 * paramInt4, i4 * paramInt4);
            return;
          }
          throw ((Throwable)new IllegalArgumentException("Comparison method violates its general contract!"));
          paramInt4 -= 1;
          if (i7 >= k) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i6 >= k) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if ((i3 | i2) == 0)
          {
            i2 = paramInt4;
            if (paramInt4 < 0) {
              i2 = 0;
            }
            i5 = i2 + 2;
            paramInt4 = i4;
            i3 = paramInt3;
            i2 = i1;
            i1 = paramInt1;
            paramInt3 = paramInt2;
            paramInt2 = i5;
            paramInt1 = i3;
            break;
          }
          localObject2 = localObject1;
          i6 = paramInt3;
          i5 = i1;
          i3 = paramInt1;
        }
      }
      label1034:
      paramInt4 = i2;
      label1287:
      n = i5;
      i2 = i4;
    }
  }
  
  private final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = paramInt4;
    boolean bool = m;
    int i8 = 0;
    int i1 = 0;
    int i9 = 1;
    if (bool)
    {
      if ((paramInt2 > 0) && (i2 > 0) && (paramInt1 + paramInt2 == paramInt3)) {
        paramInt4 = 1;
      } else {
        paramInt4 = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt4 == 0)) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
    }
    Object localObject2 = this.g;
    Object localObject1 = b(i2);
    paramInt4 = this.i;
    int i6 = i2 * paramInt4;
    System.arraycopy(localObject2, paramInt3 * paramInt4, localObject1, 0, i6);
    int i4 = paramInt1 + paramInt2 - 1;
    int n = i2 - 1;
    int i3 = paramInt3 + i2 - 1;
    paramInt3 = 0;
    while (paramInt3 < paramInt4)
    {
      localObject2[(i3 * paramInt4 + paramInt3)] = localObject2[(i4 * paramInt4 + paramInt3)];
      paramInt3 += 1;
    }
    i3 -= 1;
    i4 -= 1;
    int i5 = paramInt2 - 1;
    if (i5 == 0)
    {
      System.arraycopy(localObject1, 0, localObject2, (i3 - n) * paramInt4, i6);
      return;
    }
    if (i2 == 1)
    {
      paramInt2 = i3 - i5;
      System.arraycopy(localObject2, (i4 - i5 + 1) * paramInt4, localObject2, (paramInt2 + 1) * paramInt4, i5 * paramInt4);
      paramInt1 = i1;
      while (paramInt1 < paramInt4)
      {
        localObject2[(paramInt2 * paramInt4 + paramInt1)] = localObject1[(n * paramInt4 + paramInt1)];
        paramInt1 += 1;
      }
      return;
    }
    ByteArrayComparator localByteArrayComparator = this.h;
    paramInt3 = this.b;
    paramInt2 = paramInt4;
    paramInt4 = i5;
    i1 = i4;
    i6 = i3;
    i3 = i2;
    i2 = i1;
    i1 = n;
    int i7 = paramInt4;
    i5 = 0;
    i4 = 0;
    n = i6;
    paramInt4 = i3;
    i3 = i7;
    for (;;)
    {
      if (m)
      {
        if ((i3 > 0) && (paramInt4 > 1)) {
          i6 = 1;
        } else {
          i6 = 0;
        }
        if ((_Assertions.ENABLED) && (i6 == 0)) {
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
      if (localByteArrayComparator.a(paramInt2, (byte[])localObject1, i1, (byte[])localObject2, i2) < 0)
      {
        i4 = 0;
        while (i4 < paramInt2)
        {
          localObject2[(n * paramInt2 + i4)] = localObject2[(i2 * paramInt2 + i4)];
          i4 += 1;
        }
        i4 = n - 1;
        i2 -= 1;
        i5 += 1;
        n = i3 - 1;
        if (n == 0)
        {
          paramInt1 = paramInt3;
          i3 = paramInt2;
          paramInt2 = i2;
          paramInt3 = n;
          n = paramInt4;
          paramInt4 = i3;
          i2 = i4;
          break label1121;
        }
        i6 = 0;
        i3 = n;
        n = i4;
        i4 = i6;
      }
      else
      {
        i5 = 0;
        while (i5 < paramInt2)
        {
          localObject2[(n * paramInt2 + i5)] = localObject1[(i1 * paramInt2 + i5)];
          i5 += 1;
        }
        i6 = n - 1;
        i1 -= 1;
        i4 += 1;
        paramInt4 -= 1;
        if (paramInt4 == 1)
        {
          paramInt1 = paramInt3;
          i4 = paramInt2;
          paramInt2 = i2;
          paramInt3 = i3;
          n = paramInt4;
          paramInt4 = i4;
          i2 = i6;
          break label1121;
        }
        i5 = 0;
        n = i6;
      }
      if ((i5 | i4) >= paramInt3)
      {
        i4 = n;
        i5 = i2;
        n = paramInt3;
        i2 = i4;
        paramInt3 = i1;
        i4 = i5;
        for (;;)
        {
          if (m)
          {
            if ((i3 > 0) && (paramInt4 > 1)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if ((_Assertions.ENABLED) && (i1 == 0)) {
              throw ((Throwable)new AssertionError("Assertion failed"));
            }
          }
          i7 = i3 - ByteArrayTimSort.Companion.a(a, (byte[])localObject1, paramInt3, (byte[])localObject2, paramInt1, i3, i3 - 1, paramInt2, localByteArrayComparator);
          if (i7 != 0)
          {
            i5 = i2 - i7;
            i1 = i4 - i7;
            i2 = i3 - i7;
            System.arraycopy(localObject2, (i1 + 1) * paramInt2, localObject2, (i5 + 1) * paramInt2, i7 * paramInt2);
            i6 = i5;
            i4 = i1;
            i3 = i2;
            if (i2 == 0)
            {
              i3 = paramInt2;
              i4 = paramInt3;
              paramInt1 = n;
              paramInt2 = i1;
              paramInt3 = i2;
              n = paramInt4;
              paramInt4 = i3;
              i1 = i4;
              i2 = i5;
              break label1121;
            }
          }
          else
          {
            i6 = i2;
          }
          i1 = 0;
          while (i1 < paramInt2)
          {
            localObject2[(i6 * paramInt2 + i1)] = localObject1[(paramInt3 * paramInt2 + i1)];
            i1 += 1;
          }
          i2 = i6 - 1;
          paramInt3 -= 1;
          paramInt4 -= 1;
          if (paramInt4 == 1)
          {
            i1 = paramInt3;
            paramInt3 = i3;
          }
          Object localObject4;
          Object localObject3;
          for (;;)
          {
            i3 = paramInt2;
            paramInt1 = n;
            paramInt2 = i4;
            n = paramInt4;
            paramInt4 = i3;
            break;
            ByteArrayTimSort.Companion localCompanion = a;
            i1 = paramInt2;
            localObject4 = localObject1;
            localObject3 = localObject2;
            i6 = paramInt4 - ByteArrayTimSort.Companion.b(localCompanion, (byte[])localObject2, i4, localObject4, 0, paramInt4, paramInt4 - 1, i1, localByteArrayComparator);
            if (i6 != 0)
            {
              i2 -= i6;
              i5 = paramInt3 - i6;
              paramInt4 -= i6;
              System.arraycopy(localObject4, (i5 + 1) * i1, localObject3, (i2 + 1) * i1, i6 * i1);
              if (paramInt4 <= 1)
              {
                paramInt3 = i3;
                i1 = i5;
                continue;
              }
              paramInt3 = i5;
            }
            i5 = 0;
            while (i5 < i1)
            {
              localObject3[(i2 * i1 + i5)] = localObject3[(i4 * i1 + i5)];
              i5 += 1;
            }
            i2 -= 1;
            i4 -= 1;
            i3 -= 1;
            if (i3 != 0) {
              break label1385;
            }
            i1 = paramInt3;
            paramInt3 = i3;
          }
          label1121:
          i3 = paramInt1;
          if (paramInt1 < 1) {
            i3 = 1;
          }
          this.b = i3;
          if (n == 1)
          {
            if (m)
            {
              if (paramInt3 > 0) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            n = i2 - paramInt3;
            System.arraycopy(localObject2, (paramInt2 - paramInt3 + 1) * paramInt4, localObject2, (n + 1) * paramInt4, paramInt3 * paramInt4);
            paramInt1 = i8;
            while (paramInt1 < paramInt4)
            {
              localObject2[(n * paramInt4 + paramInt1)] = localObject1[(i1 * paramInt4 + paramInt1)];
              paramInt1 += 1;
            }
          }
          if (n != 0)
          {
            if (m)
            {
              if (paramInt3 == 0) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            if (m)
            {
              if (n > 0) {
                paramInt1 = i9;
              } else {
                paramInt1 = 0;
              }
              if ((_Assertions.ENABLED) && (paramInt1 == 0)) {
                throw ((Throwable)new AssertionError("Assertion failed"));
              }
            }
            System.arraycopy(localObject1, 0, localObject2, (i2 - (n - 1)) * paramInt4, n * paramInt4);
            return;
          }
          throw ((Throwable)new IllegalArgumentException("Comparison method violates its general contract!"));
          label1385:
          n -= 1;
          if (i7 >= k) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (i6 >= k) {
            i5 = 1;
          } else {
            i5 = 0;
          }
          if ((paramInt2 | i5) == 0)
          {
            i5 = n;
            if (n < 0) {
              i5 = 0;
            }
            n = paramInt4;
            localObject1 = localObject4;
            localObject2 = localObject3;
            paramInt2 = i1;
            paramInt4 = i3;
            i1 = i4;
            i4 = i5 + 2;
            i3 = i2;
            i2 = n;
            n = paramInt3;
            paramInt3 = i4;
            break;
          }
          localObject1 = localObject4;
          localObject2 = localObject3;
          paramInt2 = i1;
        }
      }
    }
  }
  
  private final byte[] b(int paramInt)
  {
    byte[] arrayOfByte = this.c;
    if (arrayOfByte == null) {
      Intrinsics.throwNpe();
    }
    int i1 = arrayOfByte.length;
    int n = this.i;
    if (i1 < paramInt * n)
    {
      i1 = paramInt >> 1 | paramInt;
      i1 |= i1 >> 2;
      i1 |= i1 >> 4;
      i1 |= i1 >> 8;
      i1 = (i1 | i1 >> 16) + 1;
      if (i1 >= 0) {
        paramInt = Math.min(i1, this.g.length / n >>> 1);
      }
      this.c = new byte[paramInt * this.i];
    }
    arrayOfByte = this.c;
    if (arrayOfByte == null) {
      Intrinsics.throwNpe();
    }
    return arrayOfByte;
  }
  
  private final void c()
  {
    for (;;)
    {
      int n = this.d;
      if (n <= 1) {
        break;
      }
      int i1 = n - 2;
      if (i1 >= 1)
      {
        arrayOfInt = this.f;
        if (arrayOfInt[(i1 - 1)] <= arrayOfInt[i1] + arrayOfInt[(i1 + 1)]) {}
      }
      else
      {
        if (i1 < 2) {
          break label95;
        }
        arrayOfInt = this.f;
        if (arrayOfInt[(i1 - 2)] > arrayOfInt[i1] + arrayOfInt[(i1 - 1)]) {
          break label95;
        }
      }
      int[] arrayOfInt = this.f;
      n = i1;
      if (arrayOfInt[(i1 - 1)] < arrayOfInt[(i1 + 1)])
      {
        n = i1 - 1;
        break label114;
        label95:
        arrayOfInt = this.f;
        n = i1;
        if (arrayOfInt[i1] > arrayOfInt[(i1 + 1)]) {
          return;
        }
      }
      label114:
      a(n);
    }
  }
  
  private final void d()
  {
    for (;;)
    {
      int n = this.d;
      if (n <= 1) {
        break;
      }
      int i1 = n - 2;
      n = i1;
      if (i1 > 0)
      {
        int[] arrayOfInt = this.f;
        n = i1;
        if (arrayOfInt[(i1 - 1)] < arrayOfInt[(i1 + 1)]) {
          n = i1 - 1;
        }
      }
      a(n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.aosp.ByteArrayTimSort
 * JD-Core Version:    0.7.0.1
 */