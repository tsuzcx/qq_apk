package com.tencent.sonic.sdk;

public class SonicConfig
{
  boolean AUTO_INIT_DB_WHEN_CREATE = true;
  boolean GET_COOKIE_WHEN_SESSION_CREATE = true;
  int MAX_PRELOAD_SESSION_COUNT = 5;
  long SONIC_CACHE_CHECK_TIME_INTERVAL = 86400000L;
  int SONIC_CACHE_MAX_AGE = 300000;
  long SONIC_CACHE_MAX_SIZE = 31457280L;
  public int SONIC_MAX_NUM_OF_DOWNLOADING_TASK = 3;
  long SONIC_RESOURCE_CACHE_MAX_SIZE = 62914560L;
  long SONIC_UNAVAILABLE_TIME = 21600000L;
  public boolean VERIFY_CACHE_FILE_WITH_SHA1 = true;
  
  public static class Builder
  {
    private final SonicConfig target = new SonicConfig(null);
    
    public SonicConfig build()
    {
      return this.target;
    }
    
    public Builder setAutoInitDBWhenCreate(boolean paramBoolean)
    {
      this.target.AUTO_INIT_DB_WHEN_CREATE = paramBoolean;
      return this;
    }
    
    public Builder setCacheCheckTimeInterval(long paramLong)
    {
      this.target.SONIC_CACHE_CHECK_TIME_INTERVAL = paramLong;
      return this;
    }
    
    public Builder setCacheMaxSize(long paramLong)
    {
      this.target.SONIC_CACHE_MAX_SIZE = paramLong;
      return this;
    }
    
    public Builder setCacheVerifyWithSha1(boolean paramBoolean)
    {
      this.target.VERIFY_CACHE_FILE_WITH_SHA1 = paramBoolean;
      return this;
    }
    
    public Builder setGetCookieWhenSessionCreate(boolean paramBoolean)
    {
      this.target.GET_COOKIE_WHEN_SESSION_CREATE = paramBoolean;
      return this;
    }
    
    public Builder setMaxNumOfDownloadingTasks(int paramInt)
    {
      this.target.SONIC_MAX_NUM_OF_DOWNLOADING_TASK = paramInt;
      return this;
    }
    
    public Builder setMaxPreloadSessionCount(int paramInt)
    {
      this.target.MAX_PRELOAD_SESSION_COUNT = paramInt;
      return this;
    }
    
    public Builder setResourceCacheMaxSize(long paramLong)
    {
      this.target.SONIC_RESOURCE_CACHE_MAX_SIZE = paramLong;
      return this;
    }
    
    public Builder setSonicCacheMaxAge(int paramInt)
    {
      this.target.SONIC_CACHE_MAX_AGE = paramInt;
      return this;
    }
    
    public Builder setUnavailableTime(long paramLong)
    {
      this.target.SONIC_UNAVAILABLE_TIME = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicConfig
 * JD-Core Version:    0.7.0.1
 */