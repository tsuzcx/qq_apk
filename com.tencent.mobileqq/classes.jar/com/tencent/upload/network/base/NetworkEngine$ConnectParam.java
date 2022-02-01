package com.tencent.upload.network.base;

final class NetworkEngine$ConnectParam
{
  public final String ip;
  public final int port;
  public final String proxyIp;
  public final int proxyPort;
  public final int timeout;
  
  public NetworkEngine$ConnectParam(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    this.ip = paramString1;
    this.port = paramInt1;
    this.proxyIp = paramString2;
    this.proxyPort = paramInt2;
    this.timeout = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.base.NetworkEngine.ConnectParam
 * JD-Core Version:    0.7.0.1
 */