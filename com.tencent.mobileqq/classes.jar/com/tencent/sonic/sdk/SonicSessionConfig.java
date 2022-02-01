package com.tencent.sonic.sdk;

import java.util.Map;

public class SonicSessionConfig
{
  boolean ACCEPT_DIFF_DATA = true;
  boolean AUTO_START_WHEN_CREATE = true;
  int CONNECT_TIMEOUT_MILLIS = 5000;
  boolean IS_ACCOUNT_RELATED = true;
  long PRELOAD_SESSION_EXPIRED_TIME = 180000L;
  int READ_BUF_SIZE = 10240;
  int READ_TIMEOUT_MILLIS = 15000;
  boolean RELOAD_IN_BAD_NETWORK = false;
  boolean SUPPORT_CACHE_CONTROL = false;
  boolean SUPPORT_LOCAL_SERVER = false;
  boolean SUPPORT_SONIC_CHUNK_DATA = true;
  String USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST = "Bad Network!";
  SonicCacheInterceptor cacheInterceptor = null;
  SonicSessionConnectionInterceptor connectionInterceptor = null;
  Map<String, String> customRequestHeaders = null;
  Map<String, String> customResponseHeaders = null;
  int sessionMode = 1;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof SonicSessionConfig;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (SonicSessionConfig)paramObject;
      bool1 = bool2;
      if (this.sessionMode == paramObject.sessionMode)
      {
        bool1 = bool2;
        if (this.SUPPORT_LOCAL_SERVER == paramObject.SUPPORT_LOCAL_SERVER) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public SonicCacheInterceptor getCacheInterceptor()
  {
    return this.cacheInterceptor;
  }
  
  public SonicSessionConnectionInterceptor getConnectionInterceptor()
  {
    return this.connectionInterceptor;
  }
  
  public Map<String, String> getCustomRequestHeaders()
  {
    return this.customRequestHeaders;
  }
  
  public Map<String, String> getCustomResponseHeaders()
  {
    return this.customResponseHeaders;
  }
  
  public int getSessionMode()
  {
    return this.sessionMode;
  }
  
  public boolean isAcceptDiffData()
  {
    return this.ACCEPT_DIFF_DATA;
  }
  
  public boolean isAccountRelated()
  {
    return this.IS_ACCOUNT_RELATED;
  }
  
  public boolean isAutoStartWhenCreate()
  {
    return this.AUTO_START_WHEN_CREATE;
  }
  
  public boolean isReloadInBadNetWork()
  {
    return this.RELOAD_IN_BAD_NETWORK;
  }
  
  public boolean isSupportCacheControl()
  {
    return this.SUPPORT_CACHE_CONTROL;
  }
  
  public boolean isSupportLocalServer()
  {
    return this.SUPPORT_LOCAL_SERVER;
  }
  
  public boolean isSupportSonicCHunkData()
  {
    return this.SUPPORT_SONIC_CHUNK_DATA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConfig
 * JD-Core Version:    0.7.0.1
 */