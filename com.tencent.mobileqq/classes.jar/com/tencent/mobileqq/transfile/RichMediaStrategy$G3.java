package com.tencent.mobileqq.transfile;

public class RichMediaStrategy$G3
  extends RichMediaStrategy.NetPolicy
{
  private int connectTimeout = 15000;
  private int maxTryTime = 9;
  private int minTryTime = 3;
  private int readTimeout = 30000;
  private int timeLimit = 420000;
  private int tryInterval = 4000;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.G3
 * JD-Core Version:    0.7.0.1
 */