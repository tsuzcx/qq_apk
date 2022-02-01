package com.tencent.mobileqq.transfile;

public class TimeoutParam
{
  public static final int TIMEOUT_STEP = 2000;
  private int connectTimeoutBias = 0;
  public int connectTimeoutFor2G = 20000;
  public int connectTimeoutFor3G = 15000;
  public int connectTimeoutForWifi = 10000;
  public int readTimeoutFor2G = 40000;
  public int readTimeoutFor3G = 30000;
  public int readTimeoutForWifi = 20000;
  
  public TimeoutParam() {}
  
  private TimeoutParam(TimeoutParam paramTimeoutParam)
  {
    this.readTimeoutFor2G = paramTimeoutParam.readTimeoutFor2G;
    this.readTimeoutFor3G = paramTimeoutParam.readTimeoutFor3G;
    this.readTimeoutForWifi = paramTimeoutParam.readTimeoutForWifi;
    this.connectTimeoutFor2G = paramTimeoutParam.connectTimeoutFor2G;
    this.connectTimeoutFor3G = paramTimeoutParam.connectTimeoutFor3G;
    this.connectTimeoutForWifi = paramTimeoutParam.connectTimeoutForWifi;
  }
  
  public void adjustConnectTimeout(int paramInt)
  {
    this.connectTimeoutBias = (paramInt * 2000);
  }
  
  public TimeoutParam clone()
  {
    return new TimeoutParam(this);
  }
  
  public int getConnectTimeout(int paramInt)
  {
    int i;
    if (paramInt != 1) {
      if (paramInt != 3)
      {
        if ((paramInt == 4) || (paramInt == 5)) {
          break label47;
        }
        i = this.connectTimeoutFor2G;
        paramInt = this.connectTimeoutBias;
      }
    }
    for (;;)
    {
      return i + paramInt;
      i = this.connectTimeoutFor3G;
      paramInt = this.connectTimeoutBias;
      continue;
      label47:
      i = this.connectTimeoutForWifi;
      paramInt = this.connectTimeoutBias;
    }
  }
  
  public int getReadTimeout(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 3)
      {
        if ((paramInt != 4) && (paramInt != 5)) {
          return this.readTimeoutFor2G;
        }
      }
      else {
        return this.readTimeoutFor3G;
      }
    }
    return this.readTimeoutForWifi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TimeoutParam
 * JD-Core Version:    0.7.0.1
 */