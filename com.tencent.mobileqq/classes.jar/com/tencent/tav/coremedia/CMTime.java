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
    this((600.0F * paramFloat), 600);
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
    this.timeUs = (1000000L * paramLong / paramInt);
  }
  
  private CMTime(long paramLong1, int paramInt, float paramFloat, long paramLong2)
  {
    this.value = paramLong1;
    this.timeUs = paramLong2;
    this.time = paramFloat;
    this.timeScale = paramInt;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramCMTime1 == CMTimeInvalid) {
      return paramCMTime2.clone();
    }
    if (paramCMTime2 == CMTimeInvalid) {
      return paramCMTime1.clone();
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    return new CMTime(paramCMTime1.getValue() + paramCMTime2.getValue(), paramCMTime1.timeScale);
  }
  
  public static CMTime convertTimeScale(@NonNull CMTime paramCMTime, int paramInt)
  {
    if (paramCMTime == CMTimeInvalid) {
      return CMTimeInvalid;
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
    if (paramCMTime1 == CMTimeInvalid) {
      return new CMTime(-paramCMTime2.getValue());
    }
    if (paramCMTime2 == CMTimeInvalid) {
      return paramCMTime1.clone();
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    return new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
  }
  
  public CMTime add(long paramLong)
  {
    if (this == CMTimeInvalid) {
      return clone();
    }
    return new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    if (this == CMTimeInvalid) {
      return paramCMTime.clone();
    }
    if (paramCMTime == CMTimeInvalid) {
      return clone();
    }
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      return new CMTime(localCMTime1.getValue() + localCMTime2.getValue(), i);
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    return getTimeUs() > paramCMTime.getTimeUs();
  }
  
  public CMTime clone()
  {
    return new CMTime(this.value, this.timeScale, this.time, this.timeUs);
  }
  
  public int compare(CMTime paramCMTime)
  {
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
    if (this == CMTimeInvalid) {
      return CMTimeInvalid;
    }
    return new CMTime(((float)getValue() / paramFloat), this.timeScale);
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      return new CMTime(localCMTime1.getValue() / localCMTime2.getValue(), i);
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CMTime)) {
      return false;
    }
    if ((this.value == ((CMTime)paramObject).value) && (this.timeScale == ((CMTime)paramObject).timeScale)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equalsTo(CMTime paramCMTime)
  {
    return getTimeUs() == paramCMTime.getTimeUs();
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
    if (bigThan(paramCMTime)) {
      return paramCMTime;
    }
    return this;
  }
  
  public CMTime limitMin(@NonNull CMTime paramCMTime)
  {
    if (smallThan(paramCMTime)) {
      return paramCMTime;
    }
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    if (this == CMTimeInvalid) {
      return CMTimeInvalid;
    }
    return new CMTime(((float)getValue() * paramFloat), this.timeScale);
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      return new CMTime(localCMTime1.value * localCMTime2.value, i);
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    return getTimeUs() < paramCMTime.getTimeUs();
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    if (this == CMTimeInvalid) {
      return new CMTime(-paramCMTime.getValue());
    }
    if (paramCMTime == CMTimeInvalid) {
      return clone();
    }
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      return new CMTime(localCMTime1.getValue() - localCMTime2.getValue(), i);
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public String toString()
  {
    return "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */