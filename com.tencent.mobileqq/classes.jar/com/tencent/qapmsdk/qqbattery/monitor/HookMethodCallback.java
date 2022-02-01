package com.tencent.qapmsdk.qqbattery.monitor;

public abstract interface HookMethodCallback
{
  public abstract void afterHookedMethod(MethodHookParam paramMethodHookParam);
  
  public abstract void beforeHookedMethod(MethodHookParam paramMethodHookParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.HookMethodCallback
 * JD-Core Version:    0.7.0.1
 */