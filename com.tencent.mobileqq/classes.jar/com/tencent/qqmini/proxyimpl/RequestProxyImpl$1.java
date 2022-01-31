package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
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
  private volatile boolean canceled;
  
  RequestProxyImpl$1(RequestProxyImpl paramRequestProxyImpl, String paramString, RequestProxy.RequestListener paramRequestListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("RequestProxyImpl", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$listener.onRequestFailed(-5, "request error:cancel");
    }
    for (;;)
    {
      this.this$0.taskMap.remove(this.val$url);
      return;
      this.val$listener.onRequestFailed(HttpUtil.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.val$listener.onRequestHeadersReceived(i, localMap);
    paramCall = null;
    try
    {
      paramResponse = paramResponse.body().bytes();
      paramCall = paramResponse;
    }
    catch (IOException paramResponse)
    {
      for (;;)
      {
        paramResponse.printStackTrace();
      }
    }
    this.val$listener.onRequestSucceed(i, paramCall, localMap);
    this.this$0.taskMap.remove(this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RequestProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */