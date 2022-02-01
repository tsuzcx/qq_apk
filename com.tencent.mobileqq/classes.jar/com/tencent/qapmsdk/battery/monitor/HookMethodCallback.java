package com.tencent.qapmsdk.battery.monitor;

public abstract interface HookMethodCallback
{
  public abstract void afterHookedMethod(MethodHookParam paramMethodHookParam);
  
  public abstract void beforeHookedMethod(MethodHookParam paramMethodHookParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.HookMethodCallback
 * JD-Core Version:    0.7.0.1
 */