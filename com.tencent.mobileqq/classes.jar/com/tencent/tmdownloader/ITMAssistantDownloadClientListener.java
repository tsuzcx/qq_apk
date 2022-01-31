package com.tencent.tmdownloader;

public abstract interface ITMAssistantDownloadClientListener
{
  public abstract void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2);
  
  public abstract void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.ITMAssistantDownloadClientListener
 * JD-Core Version:    0.7.0.1
 */