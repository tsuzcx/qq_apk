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
  String USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST = "Bad Network!";
  SonicCacheInterceptor cacheInterceptor = null;
  SonicSessionConnectionInterceptor connectionInterceptor = null;
  Map<String, String> customRequestHeaders = null;
  Map<String, String> customResponseHeaders = null;
  int sessionMode = 1;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof SonicSessionConfig))
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
  
  public static class Builder
  {
    private final SonicSessionConfig target = new SonicSessionConfig(null);
    
    public SonicSessionConfig build()
    {
      return this.target;
    }
    
    public Builder setAcceptDiff(boolean paramBoolean)
    {
      this.target.ACCEPT_DIFF_DATA = paramBoolean;
      return this;
    }
    
    public Builder setAutoStartWhenCreate(boolean paramBoolean)
    {
      this.target.AUTO_START_WHEN_CREATE = paramBoolean;
      return this;
    }
    
    public Builder setCacheInterceptor(SonicCacheInterceptor paramSonicCacheInterceptor)
    {
      this.target.cacheInterceptor = paramSonicCacheInterceptor;
      return this;
    }
    
    public Builder setConnectTimeoutMillis(int paramInt)
    {
      this.target.CONNECT_TIMEOUT_MILLIS = paramInt;
      return this;
    }
    
    public Builder setConnectionInterceptor(SonicSessionConnectionInterceptor paramSonicSessionConnectionInterceptor)
    {
      this.target.connectionInterceptor = paramSonicSessionConnectionInterceptor;
      return this;
    }
    
    public Builder setCustomRequestHeaders(Map<String, String> paramMap)
    {
      this.target.customRequestHeaders = paramMap;
      return this;
    }
    
    public Builder setCustomResponseHeaders(Map<String, String> paramMap)
    {
      this.target.customResponseHeaders = paramMap;
      return this;
    }
    
    public Builder setIsAccountRelated(boolean paramBoolean)
    {
      this.target.IS_ACCOUNT_RELATED = paramBoolean;
      return this;
    }
    
    public Builder setPreloadSessionExpiredTimeMillis(long paramLong)
    {
      this.target.PRELOAD_SESSION_EXPIRED_TIME = paramLong;
      return this;
    }
    
    public Builder setReadBufferSize(int paramInt)
    {
      this.target.READ_BUF_SIZE = paramInt;
      return this;
    }
    
    public Builder setReadTimeoutMillis(int paramInt)
    {
      this.target.READ_TIMEOUT_MILLIS = paramInt;
      return this;
    }
    
    public Builder setReloadInBadNetwork(boolean paramBoolean)
    {
      this.target.RELOAD_IN_BAD_NETWORK = paramBoolean;
      return this;
    }
    
    public Builder setSessionMode(int paramInt)
    {
      this.target.sessionMode = paramInt;
      return this;
    }
    
    public Builder setSupportCacheControl(boolean paramBoolean)
    {
      this.target.SUPPORT_CACHE_CONTROL = paramBoolean;
      return this;
    }
    
    public Builder setSupportLocalServer(boolean paramBoolean)
    {
      this.target.SUPPORT_LOCAL_SERVER = paramBoolean;
      return this;
    }
    
    public Builder setUseSonicCacheInBadNetworkToastMessage(String paramString)
    {
      this.target.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConfig
 * JD-Core Version:    0.7.0.1
 */