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
    Object localObject;
    if (localSonicCacheInterceptor == null) {
      localObject = SonicCacheInterceptor.SonicCacheInterceptorDefaultImpl.getCacheData(paramSonicSession);
    }
    label45:
    for (;;)
    {
      return localObject;
      String str;
      for (localObject = null;; localObject = str)
      {
        if (localSonicCacheInterceptor == null) {
          break label45;
        }
        str = localSonicCacheInterceptor.getCacheData(paramSonicSession);
        localObject = str;
        if (str != null) {
          break;
        }
        localSonicCacheInterceptor = localSonicCacheInterceptor.next();
      }
    }
  }
  
  public abstract String getCacheData(SonicSession paramSonicSession);
  
  public SonicCacheInterceptor next()
  {
    return this.nextInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicCacheInterceptor
 * JD-Core Version:    0.7.0.1
 */