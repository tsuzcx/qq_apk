package com.tencent.mobileqq.transfile;

public class RichMediaStrategy$WIFI
  extends RichMediaStrategy.NetPolicy
{
  private int connectTimeout = 10000;
  private int maxTryTime = 9;
  private int minTryTime = 3;
  private int readTimeout = 20000;
  private int timeLimit = 360000;
  private int tryInterval = 3000;
  
  public int getConnectTimeout()
  {
    return this.connectTimeout;
  }
  
  public int getMaxTryTime()
  {
    return this.maxTryTime;
  }
  
  public int getMinTryTime()
  {
    return this.minTryTime;
  }
  
  public int getReadTimeout()
  {
    return this.readTimeout;
  }
  
  public int getTimeLimit()
  {
    return this.timeLimit;
  }
  
  public int getTryInterval()
  {
    return this.tryInterval;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.WIFI
 * JD-Core Version:    0.7.0.1
 */