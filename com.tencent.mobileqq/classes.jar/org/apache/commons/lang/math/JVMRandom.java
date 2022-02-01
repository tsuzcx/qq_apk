package org.apache.commons.lang.math;

import java.util.Random;

public final class JVMRandom
  extends Random
{
  private static final Random SHARED_RANDOM = new Random();
  private static final long serialVersionUID = 1L;
  private boolean constructed = false;
  
  private static int bitsRequired(long paramLong)
  {
    int i = 0;
    for (long l = paramLong;; l >>= 1)
    {
      if (paramLong < 0L) {
        return 64 - i;
      }
      if (l == 0L) {
        return i;
      }
      i += 1;
      paramLong <<= 1;
    }
  }
  
  private static long next63bits()
  {
    return SHARED_RANDOM.nextLong() & 0xFFFFFFFF;
  }
  
  public static long nextLong(long paramLong)
  {
    if (paramLong > 0L)
    {
      if ((-paramLong & paramLong) == paramLong) {
        return next63bits() >> 63 - bitsRequired(paramLong - 1L);
      }
      long l1;
      long l2;
      do
      {
        l1 = next63bits();
        l2 = l1 % paramLong;
      } while (l1 - l2 + (paramLong - 1L) < 0L);
      return l2;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Upper bound for nextInt must be positive");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public boolean nextBoolean()
  {
    return SHARED_RANDOM.nextBoolean();
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public double nextDouble()
  {
    return SHARED_RANDOM.nextDouble();
  }
  
  public float nextFloat()
  {
    return SHARED_RANDOM.nextFloat();
  }
  
  public double nextGaussian()
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public int nextInt()
  {
    return nextInt(2147483647);
  }
  
  public int nextInt(int paramInt)
  {
    return SHARED_RANDOM.nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return nextLong(9223372036854775807L);
  }
  
  public void setSeed(long paramLong)
  {
    try
    {
      boolean bool = this.constructed;
      if (!bool) {
        return;
      }
      throw new UnsupportedOperationException();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.JVMRandom
 * JD-Core Version:    0.7.0.1
 */