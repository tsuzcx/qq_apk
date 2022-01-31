package com.tencent.qapmsdk.dns;

import com.tencent.qapmsdk.dns.model.DnsInfo;
import java.net.InetAddress;

final class HttpDns$1
  implements HttpDns.Callback
{
  boolean hook = false;
  
  public void onHook(boolean paramBoolean, Throwable paramThrowable)
  {
    this.hook = paramBoolean;
  }
  
  public void onResolveDns(HttpDns.DnsType paramDnsType, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (this.hook) {
      DnsInfo.setDns(paramString, paramArrayOfInetAddress, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.HttpDns.1
 * JD-Core Version:    0.7.0.1
 */