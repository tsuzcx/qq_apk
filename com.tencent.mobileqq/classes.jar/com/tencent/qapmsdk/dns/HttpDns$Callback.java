package com.tencent.qapmsdk.dns;

import java.net.InetAddress;

public abstract interface HttpDns$Callback
{
  public abstract void onHook(boolean paramBoolean, Throwable paramThrowable);
  
  public abstract void onResolveDns(HttpDns.DnsType paramDnsType, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.HttpDns.Callback
 * JD-Core Version:    0.7.0.1
 */