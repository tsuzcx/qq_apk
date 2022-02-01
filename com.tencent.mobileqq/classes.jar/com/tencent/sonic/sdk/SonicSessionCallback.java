package com.tencent.sonic.sdk;

abstract interface SonicSessionCallback
{
  public abstract void onSessionDataUpdated(String paramString);
  
  public abstract void onSessionDestroy();
  
  public abstract void onSessionFirstLoad(String paramString);
  
  public abstract void onSessionHitCache();
  
  public abstract void onSessionHttpError(int paramInt);
  
  public abstract void onSessionLoadLocalCache(String paramString);
  
  public abstract void onSessionSaveCache(String paramString1, String paramString2, String paramString3);
  
  public abstract void onSessionTemplateChanged(String paramString);
  
  public abstract void onSessionUnAvailable();
  
  public abstract void onSonicSessionRefresh();
  
  public abstract void onSonicSessionStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionCallback
 * JD-Core Version:    0.7.0.1
 */