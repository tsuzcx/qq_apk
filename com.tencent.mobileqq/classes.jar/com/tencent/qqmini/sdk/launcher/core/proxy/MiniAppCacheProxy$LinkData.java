package com.tencent.qqmini.sdk.launcher.core.proxy;

public class MiniAppCacheProxy$LinkData
{
  public byte[] appInfo;
  public String shareTicket;
  
  public MiniAppCacheProxy$LinkData() {}
  
  public MiniAppCacheProxy$LinkData(byte[] paramArrayOfByte, String paramString)
  {
    this.appInfo = paramArrayOfByte;
    this.shareTicket = paramString;
  }
  
  public byte[] getAppInfo()
  {
    return this.appInfo;
  }
  
  public String getShareTicket()
  {
    return this.shareTicket;
  }
  
  public void setAppInfo(byte[] paramArrayOfByte)
  {
    this.appInfo = paramArrayOfByte;
  }
  
  public void setShareTicket(String paramString)
  {
    this.shareTicket = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy.LinkData
 * JD-Core Version:    0.7.0.1
 */