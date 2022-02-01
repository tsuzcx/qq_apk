package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class RequestProxyImpl$1
  implements Callback
{
  private volatile boolean d = false;
  
  RequestProxyImpl$1(RequestProxyImpl paramRequestProxyImpl, String paramString, RequestProxy.RequestListener paramRequestListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.a);
    QLog.e("RequestProxyImpl", 1, paramCall.toString(), paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.d = true;
      this.b.onRequestFailed(-5, "request error:cancel");
    }
    else
    {
      this.b.onRequestFailed(HttpUtil.a(paramIOException, -1), "request error:network");
    }
    this.c.a.remove(this.a);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.d) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.b.onRequestHeadersReceived(i, localMap);
    paramCall = null;
    try
    {
      paramResponse = paramResponse.body().bytes();
      paramCall = paramResponse;
    }
    catch (IOException paramResponse)
    {
      paramResponse.printStackTrace();
    }
    this.b.onRequestSucceed(i, paramCall, localMap);
    this.c.a.remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RequestProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */