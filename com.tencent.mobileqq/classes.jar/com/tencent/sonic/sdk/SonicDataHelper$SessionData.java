package com.tencent.sonic.sdk;

class SonicDataHelper$SessionData
{
  int cacheHitCount;
  String eTag;
  long expiredTime;
  String htmlSha1;
  long htmlSize;
  int isRedPointPreload;
  String sessionId;
  String templateTag;
  long templateUpdateTime;
  long unAvailableTime;
  
  public void reset()
  {
    this.eTag = "";
    this.templateTag = "";
    this.htmlSha1 = "";
    this.htmlSize = 0L;
    this.templateUpdateTime = 0L;
    this.expiredTime = 0L;
    this.cacheHitCount = 0;
    this.unAvailableTime = 0L;
    this.isRedPointPreload = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDataHelper.SessionData
 * JD-Core Version:    0.7.0.1
 */