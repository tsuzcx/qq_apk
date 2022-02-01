package com.tencent.mobileqq.vas.aidl;

import android.os.IInterface;

public abstract interface ISwitchCallback
  extends IInterface
{
  public abstract void beginSwitch();
  
  public abstract void doSwitch(String paramString1, String paramString2);
  
  public abstract void onProgress(long paramLong1, long paramLong2);
  
  public abstract void postSwitch(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.aidl.ISwitchCallback
 * JD-Core Version:    0.7.0.1
 */