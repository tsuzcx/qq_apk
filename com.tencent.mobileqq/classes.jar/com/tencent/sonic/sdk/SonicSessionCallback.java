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
  
  public static class SimpleCallbackImpl
    implements SonicSessionCallback
  {
    public void onSessionDataUpdated(String paramString) {}
    
    public void onSessionDestroy() {}
    
    public void onSessionFirstLoad(String paramString) {}
    
    public void onSessionHitCache() {}
    
    public void onSessionHttpError(int paramInt) {}
    
    public void onSessionLoadLocalCache(String paramString) {}
    
    public void onSessionSaveCache(String paramString1, String paramString2, String paramString3) {}
    
    public void onSessionTemplateChanged(String paramString) {}
    
    public void onSessionUnAvailable() {}
    
    public void onSonicSessionRefresh() {}
    
    public void onSonicSessionStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionCallback
 * JD-Core Version:    0.7.0.1
 */