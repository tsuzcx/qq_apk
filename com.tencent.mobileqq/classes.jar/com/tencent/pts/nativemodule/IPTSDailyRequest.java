package com.tencent.pts.nativemodule;

import android.os.Bundle;

public abstract interface IPTSDailyRequest
  extends PTSNativeModuleRegistry.PTSNativeModule
{
  public abstract void makeDailyRequest(long paramLong, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.nativemodule.IPTSDailyRequest
 * JD-Core Version:    0.7.0.1
 */