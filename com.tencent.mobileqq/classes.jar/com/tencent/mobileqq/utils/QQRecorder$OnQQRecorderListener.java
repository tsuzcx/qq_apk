package com.tencent.mobileqq.utils;

public abstract interface QQRecorder$OnQQRecorderListener
{
  public abstract int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void onInitSuccess();
  
  public abstract void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble);
  
  public abstract void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2);
  
  public abstract void onRecorderNotReady(String paramString);
  
  public abstract void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract int onRecorderStart();
  
  public abstract void onRecorderVolumeStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener
 * JD-Core Version:    0.7.0.1
 */