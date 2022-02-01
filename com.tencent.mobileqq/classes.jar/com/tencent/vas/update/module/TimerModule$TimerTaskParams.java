package com.tencent.vas.update.module;

import androidx.annotation.NonNull;

class TimerModule$TimerTaskParams
{
  public long mDelay;
  public boolean mIsLoop;
  public int mType;
  
  private TimerModule$TimerTaskParams(TimerModule paramTimerModule) {}
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("timer type = ");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(" delay = ");
    localStringBuilder.append(this.mDelay);
    localStringBuilder.append(" loop = ");
    localStringBuilder.append(this.mIsLoop);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.TimerModule.TimerTaskParams
 * JD-Core Version:    0.7.0.1
 */