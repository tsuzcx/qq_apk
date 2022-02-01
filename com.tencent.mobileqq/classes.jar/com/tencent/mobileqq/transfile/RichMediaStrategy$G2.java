package com.tencent.mobileqq.transfile;

public class RichMediaStrategy$G2
  extends RichMediaStrategy.NetPolicy
{
  private int connectTimeout = 20000;
  private int maxTryTime = 9;
  private int minTryTime = 3;
  private int readTimeout = 40000;
  private int timeLimit = 480000;
  private int tryInterval = 5000;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.G2
 * JD-Core Version:    0.7.0.1
 */