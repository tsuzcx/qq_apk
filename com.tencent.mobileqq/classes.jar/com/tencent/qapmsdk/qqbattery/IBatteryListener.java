package com.tencent.qapmsdk.qqbattery;

import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.listener.IBaseListener;

public abstract interface IBatteryListener
  extends IBaseListener
{
  @Nullable
  public abstract String getBlackClassName();
  
  public abstract void onPrintLog(@Nullable String paramString);
  
  public abstract void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.IBatteryListener
 * JD-Core Version:    0.7.0.1
 */