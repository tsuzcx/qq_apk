package com.tencent.qapmsdk.dns.utils;

import com.tencent.qapmsdk.dns.HttpDns.Callback;
import com.tencent.qapmsdk.dns.HttpDns.DnsType;
import java.net.InetAddress;

class Utils$AsyncCallbackWrapper$2
  implements Runnable
{
  Utils$AsyncCallbackWrapper$2(Utils.AsyncCallbackWrapper paramAsyncCallbackWrapper, HttpDns.Callback paramCallback, HttpDns.DnsType paramDnsType, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong) {}
  
  public void run()
  {
    this.val$callback.onResolveDns(this.val$type, this.val$host, this.val$inetAddresses, this.val$cost);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.Utils.AsyncCallbackWrapper.2
 * JD-Core Version:    0.7.0.1
 */