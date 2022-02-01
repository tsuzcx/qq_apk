package com.tencent.qqmini.miniapp.core.service;

public abstract interface ServiceEventListener
{
  public abstract void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract String onServiceNativeRequest(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.ServiceEventListener
 * JD-Core Version:    0.7.0.1
 */