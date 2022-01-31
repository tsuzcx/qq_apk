package com.tencent.tmassistantsdk;

public abstract interface ITMAssistantCallBackListener
{
  public abstract void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2);
  
  public abstract void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString);
  
  public abstract void onQQDownloaderInvalid();
  
  public abstract void onServiceFree();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantsdk.ITMAssistantCallBackListener
 * JD-Core Version:    0.7.0.1
 */