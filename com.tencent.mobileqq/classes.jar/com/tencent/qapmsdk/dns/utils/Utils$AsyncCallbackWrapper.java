package com.tencent.qapmsdk.dns.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qapmsdk.dns.HttpDns.Callback;
import com.tencent.qapmsdk.dns.HttpDns.DnsType;
import java.net.InetAddress;

class Utils$AsyncCallbackWrapper
  implements HttpDns.Callback
{
  private HttpDns.Callback dnsCallBack;
  private Handler handler;
  
  public void onHook(boolean paramBoolean, Throwable paramThrowable)
  {
    HttpDns.Callback localCallback = this.dnsCallBack;
    Handler localHandler = this.handler;
    if ((localCallback != null) && (localHandler != null)) {
      localHandler.post(new Utils.AsyncCallbackWrapper.1(this, localCallback, paramBoolean, paramThrowable));
    }
  }
  
  public void onResolveDns(HttpDns.DnsType paramDnsType, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    HttpDns.Callback localCallback = this.dnsCallBack;
    Handler localHandler = this.handler;
    if ((localCallback != null) && (localHandler != null)) {
      localHandler.post(new Utils.AsyncCallbackWrapper.2(this, localCallback, paramDnsType, paramString, paramArrayOfInetAddress, paramLong));
    }
  }
  
  void setCallback(HttpDns.Callback paramCallback)
  {
    try
    {
      this.dnsCallBack = paramCallback;
      if ((paramCallback != null) && (this.handler == null))
      {
        paramCallback = new HandlerThread("httpdns-callback");
        paramCallback.start();
        this.handler = new Handler(paramCallback.getLooper());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.Utils.AsyncCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */