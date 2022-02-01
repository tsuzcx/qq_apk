package com.tencent.sonic.sdk;

public abstract class SonicCacheInterceptor
{
  public static final String TAG = "SonicSdk_SonicCacheInterceptor";
  private final SonicCacheInterceptor nextInterceptor;
  
  public SonicCacheInterceptor(SonicCacheInterceptor paramSonicCacheInterceptor)
  {
    this.nextInterceptor = paramSonicCacheInterceptor;
  }
  
  static String getSonicCacheData(SonicSession paramSonicSession)
  {
    SonicCacheInterceptor localSonicCacheInterceptor = paramSonicSession.config.cacheInterceptor;
    if (localSonicCacheInterceptor == null) {
      return SonicCacheInterceptor.SonicCacheInterceptorDefaultImpl.getCacheData(paramSonicSession);
    }
    String str = null;
    while (localSonicCacheInterceptor != null)
    {
      str = localSonicCacheInterceptor.getCacheData(paramSonicSession);
      if (str != null) {
        return str;
      }
      localSonicCacheInterceptor = localSonicCacheInterceptor.next();
    }
    return str;
  }
  
  public abstract String getCacheData(SonicSession paramSonicSession);
  
  public SonicCacheInterceptor next()
  {
    return this.nextInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicCacheInterceptor
 * JD-Core Version:    0.7.0.1
 */