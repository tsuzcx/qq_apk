package com.tencent.sonic.sdk;

public class SonicConfig$Builder
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicConfig.Builder
 * JD-Core Version:    0.7.0.1
 */