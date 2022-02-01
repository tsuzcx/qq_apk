package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

public class CMSampleState
{
  private boolean isNewFrame = true;
  private String msg;
  private long stateCode = 0L;
  private Throwable throwable;
  @NonNull
  private final CMTime time;
  
  public CMSampleState()
  {
    this(CMTime.CMTimeInvalid);
  }
  
  public CMSampleState(long paramLong, String paramString, Throwable paramThrowable)
  {
    this.time = new CMTime(paramLong);
    this.stateCode = paramLong;
    this.msg = paramString;
    this.throwable = paramThrowable;
  }
  
  public CMSampleState(@NonNull CMTime paramCMTime)
  {
    Utils.checkNotNull(paramCMTime);
    this.time = paramCMTime;
    if (paramCMTime.value < 0L) {
      this.stateCode = paramCMTime.value;
    }
  }
  
  public static CMSampleState fromError(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state:");
    localStringBuilder.append(paramLong);
    return fromError(paramLong, localStringBuilder.toString());
  }
  
  public static CMSampleState fromError(long paramLong, String paramString)
  {
    return fromError(paramLong, paramString, new RuntimeException(paramString));
  }
  
  public static CMSampleState fromError(long paramLong, String paramString, Throwable paramThrowable)
  {
    return new CMSampleState(paramLong, paramString, paramThrowable);
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public long getStateCode()
  {
    return this.stateCode;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  @NonNull
  public CMTime getTime()
  {
    return this.time;
  }
  
  public boolean isInvalid()
  {
    return this.time == CMTime.CMTimeInvalid;
  }
  
  public boolean isNewFrame()
  {
    return this.isNewFrame;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    this.isNewFrame = paramBoolean;
  }
  
  public boolean stateMatchingTo(long... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      long l = paramVarArgs[i];
      if (this.stateCode == l) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CMSampleState{time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", isNewFrame=");
    localStringBuilder.append(this.isNewFrame);
    localStringBuilder.append(", stateCode=");
    localStringBuilder.append(this.stateCode);
    localStringBuilder.append(", throwable=");
    localStringBuilder.append(this.throwable);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleState
 * JD-Core Version:    0.7.0.1
 */