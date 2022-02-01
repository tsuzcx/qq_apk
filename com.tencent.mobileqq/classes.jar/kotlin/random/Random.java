package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract class Random
{
  @JvmField
  @NotNull
  public static final Random.Companion Companion = Random.Companion.INSTANCE;
  public static final Random.Default Default = new Random.Default(null);
  private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
  
  public abstract int nextBits(int paramInt);
  
  public boolean nextBoolean()
  {
    return nextBits(1) != 0;
  }
  
  @NotNull
  public byte[] nextBytes(int paramInt)
  {
    return nextBytes(new byte[paramInt]);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return nextBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public byte[] nextBytes(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    int i = paramArrayOfByte.length;
    int j = 0;
    int k = 1;
    if ((paramInt1 >= 0) && (i >= paramInt1))
    {
      i = paramArrayOfByte.length;
      if ((paramInt2 >= 0) && (i >= paramInt2))
      {
        i = 1;
        break label55;
      }
    }
    i = 0;
    label55:
    if (i != 0)
    {
      if (paramInt1 <= paramInt2) {
        i = k;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        k = (paramInt2 - paramInt1) / 4;
        i = 0;
        while (i < k)
        {
          int m = nextInt();
          paramArrayOfByte[paramInt1] = ((byte)m);
          paramArrayOfByte[(paramInt1 + 1)] = ((byte)(m >>> 8));
          paramArrayOfByte[(paramInt1 + 2)] = ((byte)(m >>> 16));
          paramArrayOfByte[(paramInt1 + 3)] = ((byte)(m >>> 24));
          paramInt1 += 4;
          i += 1;
        }
        i = paramInt2 - paramInt1;
        k = nextBits(i * 8);
        paramInt2 = j;
        while (paramInt2 < i)
        {
          paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k >>> paramInt2 * 8));
          paramInt2 += 1;
        }
        return paramArrayOfByte;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("fromIndex (");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(") must be not greater than toIndex (");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(").");
      throw ((Throwable)new IllegalArgumentException(paramArrayOfByte.toString().toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") or toIndex (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") are out of range: 0..");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append('.');
    paramArrayOfByte = (Throwable)new IllegalArgumentException(localStringBuilder.toString().toString());
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public double nextDouble()
  {
    return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
  }
  
  public double nextDouble(double paramDouble)
  {
    return nextDouble(0.0D, paramDouble);
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    RandomKt.checkRangeBounds(paramDouble1, paramDouble2);
    double d1 = paramDouble2 - paramDouble1;
    if (Double.isInfinite(d1))
    {
      boolean bool = Double.isInfinite(paramDouble1);
      int j = 1;
      int i;
      if ((!bool) && (!Double.isNaN(paramDouble1))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((!Double.isInfinite(paramDouble2)) && (!Double.isNaN(paramDouble2))) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          d1 = nextDouble();
          double d2 = 2;
          Double.isNaN(d2);
          double d3 = paramDouble2 / d2;
          Double.isNaN(d2);
          d1 *= (d3 - paramDouble1 / d2);
          paramDouble1 = paramDouble1 + d1 + d1;
          break label143;
        }
      }
    }
    paramDouble1 += nextDouble() * d1;
    label143:
    d1 = paramDouble1;
    if (paramDouble1 >= paramDouble2) {
      d1 = Math.nextAfter(paramDouble2, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
    }
    return d1;
  }
  
  public float nextFloat()
  {
    return nextBits(24) / 16777216;
  }
  
  public int nextInt()
  {
    return nextBits(32);
  }
  
  public int nextInt(int paramInt)
  {
    return nextInt(0, paramInt);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    RandomKt.checkRangeBounds(paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if ((i <= 0) && (i != -2147483648))
    {
      do
      {
        i = nextInt();
      } while ((paramInt1 > i) || (paramInt2 <= i));
      return i;
    }
    if ((-i & i) == i)
    {
      paramInt2 = nextBits(RandomKt.fastLog2(i));
    }
    else
    {
      int j;
      do
      {
        j = nextInt() >>> 1;
        paramInt2 = j % i;
      } while (j - paramInt2 + (i - 1) < 0);
    }
    return paramInt1 + paramInt2;
  }
  
  public long nextLong()
  {
    return (nextInt() << 32) + nextInt();
  }
  
  public long nextLong(long paramLong)
  {
    return nextLong(0L, paramLong);
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    RandomKt.checkRangeBounds(paramLong1, paramLong2);
    long l1 = paramLong2 - paramLong1;
    if (l1 > 0L)
    {
      if ((-l1 & l1) == l1)
      {
        int i = (int)l1;
        int j = (int)(l1 >>> 32);
        if (i != 0) {}
        for (i = nextBits(RandomKt.fastLog2(i));; i = nextInt())
        {
          paramLong2 = i & 0xFFFFFFFF;
          break label135;
          if (j != 1) {
            break;
          }
        }
        paramLong2 = (nextBits(RandomKt.fastLog2(j)) << 32) + nextInt();
      }
      else
      {
        long l2;
        do
        {
          l2 = nextLong() >>> 1;
          paramLong2 = l2 % l1;
        } while (l2 - paramLong2 + (l1 - 1L) < 0L);
      }
      label135:
      return paramLong1 + paramLong2;
    }
    do
    {
      l1 = nextLong();
    } while ((paramLong1 > l1) || (paramLong2 <= l1));
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.random.Random
 * JD-Core Version:    0.7.0.1
 */