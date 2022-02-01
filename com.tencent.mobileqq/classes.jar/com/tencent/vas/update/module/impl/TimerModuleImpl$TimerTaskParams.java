package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;

class TimerModuleImpl$TimerTaskParams
{
  public int a;
  public long b;
  public boolean c;
  
  private TimerModuleImpl$TimerTaskParams(TimerModuleImpl paramTimerModuleImpl) {}
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("timer type = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" delay = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" loop = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.TimerModuleImpl.TimerTaskParams
 * JD-Core Version:    0.7.0.1
 */