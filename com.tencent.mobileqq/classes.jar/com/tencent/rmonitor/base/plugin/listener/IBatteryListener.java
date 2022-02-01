package com.tencent.rmonitor.base.plugin.listener;

import android.support.annotation.Nullable;

public abstract interface IBatteryListener
  extends IBaseListener
{
  @Nullable
  public abstract String getBlackClassName();
  
  public abstract void onPrintLog(@Nullable String paramString);
  
  public abstract void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IBatteryListener
 * JD-Core Version:    0.7.0.1
 */