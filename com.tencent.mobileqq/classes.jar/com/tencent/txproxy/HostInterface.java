package com.tencent.txproxy;

public abstract interface HostInterface
{
  public abstract boolean isMobileNet();
  
  public abstract void reportBadIp(String paramString1, String paramString2);
  
  public abstract String reqDns(String paramString);
  
  public abstract boolean useIpDirectConnect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.HostInterface
 * JD-Core Version:    0.7.0.1
 */