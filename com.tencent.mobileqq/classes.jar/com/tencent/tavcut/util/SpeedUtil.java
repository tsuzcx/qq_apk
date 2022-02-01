package com.tencent.tavcut.util;

import java.math.BigDecimal;

public class SpeedUtil
{
  public static final float MAX_SPEED = 5.0F;
  public static final float MIN_SPEED = 0.2F;
  
  public static float convertSeekValue(int paramInt)
  {
    if (paramInt <= 50) {
      return paramInt * 1.0F / 50.0F * 0.8F + 0.2F;
    }
    return (paramInt * 1.0F - 50.0F) / 50.0F * 4.0F + 1.0F;
  }
  
  public static int convertSpeedToSeekValue(float paramFloat)
  {
    if (paramFloat > 1.0F) {}
    for (paramFloat = (paramFloat - 1.0F) / 4.0F * 50.0F + 50.0F;; paramFloat = (paramFloat - 0.2F) / 0.8F * 50.0F)
    {
      return (int)paramFloat;
      if (paramFloat >= 1.0F) {
        break;
      }
    }
    return 50;
  }
  
  public static boolean floatEqual(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.E-005D;
  }
  
  public static float getPreciseValue(float paramFloat)
  {
    return getPreciseValue(paramFloat, 1);
  }
  
  public static float getPreciseValue(float paramFloat, int paramInt)
  {
    paramInt = Math.max(paramInt, 1);
    return new BigDecimal(paramFloat).setScale(paramInt, 4).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.SpeedUtil
 * JD-Core Version:    0.7.0.1
 */