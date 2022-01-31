package com.tencent.mobileqq.highway.api;

import java.util.HashMap;

public abstract interface ITransactionCallback
{
  public abstract void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap);
  
  public abstract void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap);
  
  public abstract void onSwitch2BackupChannel();
  
  public abstract void onTransStart();
  
  public abstract void onUpdateProgress(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.api.ITransactionCallback
 * JD-Core Version:    0.7.0.1
 */