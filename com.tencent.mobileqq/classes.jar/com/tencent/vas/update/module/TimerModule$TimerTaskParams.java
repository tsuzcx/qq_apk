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
    return "timer type = " + this.mType + " delay = " + this.mDelay + " loop = " + this.mIsLoop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.TimerModule.TimerTaskParams
 * JD-Core Version:    0.7.0.1
 */