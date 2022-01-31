package com.tencent.ttpic.baseutils.math;

public final class Math
{
  public static final double NINETY_DEGREES = 1.570796326794897D;
  public static final double ONE_EIGHTY_DEGREES = 3.141592653589793D;
  public static final double ONE_TWENTY_DEGREES = 2.094395102393195D;
  private static final long POWER_CLAMP = 4294967295L;
  public static final double THREE_SIXTY_DEGREES = 6.283185307179586D;
  
  public static int power(int paramInt1, int paramInt2)
  {
    long l2 = paramInt2;
    long l1 = paramInt1;
    l2 = 0xFFFFFFFF & l2;
    for (paramInt1 = 1; l2 != 0L; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1;
      if ((1L & l2) != 0L) {
        paramInt2 = (int)(paramInt1 * l1);
      }
      l2 >>>= 1;
      l1 *= l1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.math.Math
 * JD-Core Version:    0.7.0.1
 */