package com.tencent.mobileqq.highway.utils;

public class EndPoint
  implements Cloneable
{
  public static final int COMMON_IP = 0;
  public static final String KEY_OF_APN = "";
  public static final int PROXY_IP = 1;
  public int connIndex;
  public int connResult = -1;
  public long cost = -1L;
  public int failCount = 0;
  public String host;
  public int ipIndex = 0;
  public boolean isSameIsp = true;
  public String keyOfAPN = "";
  public int port;
  public int protoType = 1;
  public long timestamp;
  public int type;
  
  public EndPoint(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public EndPoint(String paramString, int paramInt1, int paramInt2)
  {
    this.host = paramString;
    this.port = paramInt1;
    this.type = paramInt2;
  }
  
  public EndPoint(String paramString, int paramInt, long paramLong)
  {
    this(paramString, paramInt, 0);
    this.timestamp = paramLong;
  }
  
  public EndPoint(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt, 0);
    this.isSameIsp = paramBoolean;
  }
  
  public EndPoint clone()
  {
    return (EndPoint)super.clone();
  }
  
  public boolean isPorxyIp()
  {
    return this.type == 1;
  }
  
  public String toString()
  {
    return this.host + ":" + this.port + ",type:" + this.type + " failCount:" + this.failCount + " isSameIPC:" + this.isSameIsp + " keyOfAPN:" + this.keyOfAPN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.EndPoint
 * JD-Core Version:    0.7.0.1
 */