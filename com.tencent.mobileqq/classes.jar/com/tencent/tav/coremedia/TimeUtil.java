package com.tencent.tav.coremedia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil
{
  private static final long DEVIATION = 10000L;
  public static final long SECOND_TO_US = 1000000L;
  public static final String YYYY2MM2DD_HH1MM1SS = "yyyy-MM-dd HH:mm:ss";
  
  public static boolean equals(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong1 - paramLong2) < 10000L;
  }
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return paramLong * 1000000L / (paramInt1 * 2 * paramInt2);
  }
  
  public static String long2str(long paramLong, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "yyyy-M-d  HH:mm";
    }
    return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(paramLong));
  }
  
  public static float milli2Second(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000.0F;
  }
  
  public static long milli2Us(long paramLong)
  {
    return paramLong * 1000L;
  }
  
  public static String milliToSecond(long paramLong)
  {
    float f = Math.round(milli2Second(paramLong) * 10.0F) / 10.0F;
    return String.format(Locale.CHINA, "%1$.1f", new Object[] { Float.valueOf(f) });
  }
  
  public static long second2Ms(float paramFloat)
  {
    return (paramFloat * 1000.0F);
  }
  
  public static String second2String(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = paramInt / 60;
    StringBuilder localStringBuilder2;
    if (i > 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(i);
      localStringBuilder2.append("'");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    paramInt %= 60;
    if (paramInt >= 10)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramInt);
      localStringBuilder2.append("\"");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else if (paramInt >= 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("0");
      localStringBuilder2.append(paramInt);
      localStringBuilder2.append("\"");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public static long second2Us(float paramFloat)
  {
    return (paramFloat * 1000000.0F);
  }
  
  public static CMTime us2CMTime(long paramLong)
  {
    return new CMTime((us2Second(paramLong) * 600.0F));
  }
  
  public static long us2Milli(long paramLong)
  {
    return paramLong / 1000L;
  }
  
  public static float us2Second(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000000.0F;
  }
  
  public static String usToSecond(long paramLong)
  {
    float f = Math.round(us2Second(paramLong) * 10.0F) / 10.0F;
    return String.format(Locale.CHINA, "%1$.1f", new Object[] { Float.valueOf(f) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.TimeUtil
 * JD-Core Version:    0.7.0.1
 */