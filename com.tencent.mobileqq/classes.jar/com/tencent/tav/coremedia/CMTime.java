package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;

public class CMTime
  implements Cloneable
{
  public static final CMTime CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
  public static final CMTime CMTimeOne;
  public static final CMTime CMTimeZero = new CMTime(0L, 600);
  public static final int DEFAULT_TIME_SCALE = 600;
  private static final long SECONDS_MS = 1000L;
  private static final long SECONDS_US = 1000000L;
  private final float time;
  public final int timeScale;
  private final long timeUs;
  public final long value;
  
  static
  {
    CMTimeOne = new CMTime(600L, 600);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((paramFloat * 600.0F), 600);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (paramLong * 1000000L / paramInt);
  }
  
  private CMTime(long paramLong1, int paramInt, float paramFloat, long paramLong2)
  {
    this.value = paramLong1;
    this.timeUs = paramLong2;
    this.time = paramFloat;
    this.timeScale = paramInt;
  }
  
  public static int GCD(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return paramInt2;
    }
    return GCD(paramInt2 % paramInt1, paramInt1);
  }
  
  public static int LCM(int paramInt1, int paramInt2)
  {
    return paramInt1 / GCD(paramInt1, paramInt2) * paramInt2;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramCMTime1 != null)
    {
      CMTime localCMTime = CMTimeInvalid;
      if (paramCMTime1 != localCMTime)
      {
        if ((paramCMTime2 != null) && (paramCMTime2 != localCMTime))
        {
          int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
          paramCMTime1 = convertTimeScale(paramCMTime1, i);
          paramCMTime2 = convertTimeScale(paramCMTime2, i);
          return new CMTime(paramCMTime1.getValue() + paramCMTime2.getValue(), paramCMTime1.timeScale);
        }
        return paramCMTime1.clone();
      }
    }
    return paramCMTime2.clone();
  }
  
  public static CMTime convertTimeScale(@NonNull CMTime paramCMTime, int paramInt)
  {
    Utils.a(paramCMTime);
    CMTime localCMTime = CMTimeInvalid;
    if (paramCMTime == localCMTime) {
      return localCMTime;
    }
    if (paramCMTime == CMTimeZero) {
      return new CMTime(0L, paramInt);
    }
    return new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
  }
  
  public static CMTime fromMs(long paramLong)
  {
    return new CMTime((float)paramLong * 1.0F / 1000.0F);
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    return new CMTime(paramFloat);
  }
  
  public static CMTime fromUs(long paramLong)
  {
    return new CMTime((float)paramLong * 1.0F / 1000000.0F);
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramCMTime1.bigThan(paramCMTime2)) {
      return paramCMTime1;
    }
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramCMTime1.smallThan(paramCMTime2)) {
      return paramCMTime1;
    }
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramCMTime1 != null)
    {
      CMTime localCMTime = CMTimeInvalid;
      if (paramCMTime1 != localCMTime)
      {
        if ((paramCMTime2 != null) && (paramCMTime2 != localCMTime))
        {
          int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
          paramCMTime1 = convertTimeScale(paramCMTime1, i);
          paramCMTime2 = convertTimeScale(paramCMTime2, i);
          return new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
        }
        return paramCMTime1.clone();
      }
    }
    return new CMTime(-paramCMTime2.getValue());
  }
  
  public CMTime add(long paramLong)
  {
    if (this == CMTimeInvalid) {
      return clone();
    }
    return new CMTime(getValue() + paramLong * this.timeScale / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    return add(this, paramCMTime);
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    if (paramCMTime == null) {
      return true;
    }
    return getTimeUs() > paramCMTime.getTimeUs();
  }
  
  public CMTime clone()
  {
    return new CMTime(this.value, this.timeScale, this.time, this.timeUs);
  }
  
  public int compare(CMTime paramCMTime)
  {
    if (paramCMTime == null) {
      return 1;
    }
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    CMTime localCMTime = CMTimeInvalid;
    if (this == localCMTime) {
      return localCMTime;
    }
    return new CMTime(((float)getValue() / paramFloat), this.timeScale);
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    return new CMTime(localCMTime.value / paramCMTime.value, i);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof CMTime;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    long l = this.value;
    paramObject = (CMTime)paramObject;
    bool1 = bool2;
    if (l == paramObject.value)
    {
      bool1 = bool2;
      if (this.timeScale == paramObject.timeScale) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equalsTo(CMTime paramCMTime)
  {
    boolean bool = false;
    if (paramCMTime == null) {
      return false;
    }
    if (getTimeUs() == paramCMTime.getTimeUs()) {
      bool = true;
    }
    return bool;
  }
  
  public int getTimeScale()
  {
    return this.timeScale;
  }
  
  public float getTimeSeconds()
  {
    return this.time;
  }
  
  public long getTimeUs()
  {
    return this.timeUs;
  }
  
  public long getValue()
  {
    return this.value;
  }
  
  public CMTime limitMax(@NonNull CMTime paramCMTime)
  {
    Utils.a(paramCMTime);
    if (bigThan(paramCMTime)) {
      return paramCMTime;
    }
    return this;
  }
  
  public CMTime limitMin(@NonNull CMTime paramCMTime)
  {
    Utils.a(paramCMTime);
    if (smallThan(paramCMTime)) {
      return paramCMTime;
    }
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    CMTime localCMTime = CMTimeInvalid;
    if (this == localCMTime) {
      return localCMTime;
    }
    return new CMTime(((float)getValue() * paramFloat), this.timeScale);
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    CMTime localCMTime = CMTimeInvalid;
    if ((this != localCMTime) && (paramCMTime != null) && (paramCMTime != localCMTime))
    {
      int i = LCM(this.timeScale, paramCMTime.timeScale);
      localCMTime = convertTimeScale(this, i);
      paramCMTime = convertTimeScale(paramCMTime, i);
      return new CMTime(localCMTime.value * paramCMTime.value, i);
    }
    return CMTimeZero;
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    boolean bool = false;
    if (paramCMTime == null) {
      return false;
    }
    if (getTimeUs() < paramCMTime.getTimeUs()) {
      bool = true;
    }
    return bool;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    return sub(this, paramCMTime);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[value = ");
    localStringBuilder.append(this.value);
    localStringBuilder.append(" timeScale = ");
    localStringBuilder.append(this.timeScale);
    localStringBuilder.append(" timeUs = ");
    localStringBuilder.append(this.timeUs);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */