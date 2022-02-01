package com.tencent.sonic.sdk;

public class SonicResourceDataHelper$ResourceData
{
  public long expiredTime;
  long lastUpdateTime;
  String resourceId;
  public String resourceSha1;
  public long resourceSize;
  
  public void reset()
  {
    this.resourceSha1 = "";
    this.resourceSize = 0L;
    this.lastUpdateTime = 0L;
    this.expiredTime = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicResourceDataHelper.ResourceData
 * JD-Core Version:    0.7.0.1
 */