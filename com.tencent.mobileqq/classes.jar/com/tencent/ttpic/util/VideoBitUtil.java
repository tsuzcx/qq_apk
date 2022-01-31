package com.tencent.ttpic.util;

public class VideoBitUtil
{
  public static final int BIT_TURN_ZERO_1 = 65534;
  public static final int BIT_TURN_ZERO_2 = 65533;
  public static final int BIT_TURN_ZERO_3 = 65531;
  public static final int BIT_TURN_ZERO_4 = 65527;
  
  public static boolean checkBit(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public static int turnBitTo0(int paramInt1, int paramInt2)
  {
    return paramInt1 & paramInt2;
  }
  
  public static int turnBitTo1(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoBitUtil
 * JD-Core Version:    0.7.0.1
 */