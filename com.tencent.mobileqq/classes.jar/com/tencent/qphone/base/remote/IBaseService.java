package com.tencent.qphone.base.remote;

import android.os.IInterface;

public abstract interface IBaseService
  extends IInterface
{
  public abstract int getMsfConnectedIPFamily();
  
  public abstract int getMsfConnectedNetType();
  
  public abstract int onKillProcess();
  
  public abstract int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString);
  
  public abstract FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg);
  
  public abstract int sendToServiceMsg(ToServiceMsg paramToServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseService
 * JD-Core Version:    0.7.0.1
 */