package com.tencent.tvkbeacon.upload;

public class TunnelInfo
{
  public String appKey;
  public String channel;
  public String version;
  
  public TunnelInfo(String paramString)
  {
    this.appKey = paramString;
  }
  
  public TunnelInfo(String paramString1, String paramString2, String paramString3)
  {
    this.appKey = paramString1;
    this.version = paramString2;
    this.channel = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.upload.TunnelInfo
 * JD-Core Version:    0.7.0.1
 */