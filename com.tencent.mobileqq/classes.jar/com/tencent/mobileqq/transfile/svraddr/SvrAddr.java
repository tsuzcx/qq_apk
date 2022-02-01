package com.tencent.mobileqq.transfile.svraddr;

import android.support.annotation.NonNull;

public class SvrAddr
  implements ISvrAddr
{
  public boolean bIpv6;
  public String ip = "";
  public int port;
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public boolean isIpv6()
  {
    return this.bIpv6;
  }
  
  @NonNull
  public String toString()
  {
    if (this.ip == null) {
      this.ip = "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.ip).append(":").append(this.port);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.svraddr.SvrAddr
 * JD-Core Version:    0.7.0.1
 */