package com.tencent.tavcut.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class TimeFormatUtil
{
  public static String getDuration(long paramLong)
  {
    long l1 = Math.round((float)paramLong / 1000.0F);
    long l2 = l1 % 60L;
    long l3 = l1 / 60L % 60L;
    l1 = l1 / 3600L % 24L;
    if (l1 > 0L) {
      return String.format(Locale.getDefault(), "%d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2) });
    }
    l1 = l2;
    if (paramLong < 1000L)
    {
      l1 = l2;
      if (paramLong > 0L) {
        l1 = 1L;
      }
    }
    return String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
  }
  
  public static String getDurationSecondsChinese(long paramLong)
  {
    float f = (float)paramLong / 1000.0F;
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
    localDecimalFormat.setRoundingMode(RoundingMode.DOWN);
    return localDecimalFormat.format(f) + "秒";
  }
  
  public static String getDurationSecondsEnglish(long paramLong)
  {
    float f = (float)paramLong / 1000.0F;
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
    localDecimalFormat.setRoundingMode(RoundingMode.DOWN);
    return localDecimalFormat.format(f) + "s";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.TimeFormatUtil
 * JD-Core Version:    0.7.0.1
 */