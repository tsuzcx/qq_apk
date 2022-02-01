package com.tencent.qapmsdk.battery;

import com.tencent.qapmsdk.base.listener.IBaseListener;

public abstract interface IBatteryListener
  extends IBaseListener
{
  public abstract String getSosoClassName();
  
  public abstract void onPrintLog(String paramString);
  
  public abstract void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.IBatteryListener
 * JD-Core Version:    0.7.0.1
 */