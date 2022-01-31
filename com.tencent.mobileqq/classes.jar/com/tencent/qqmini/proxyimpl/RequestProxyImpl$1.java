package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class RequestProxyImpl$1
  implements Callback
{
  private volatile boolean canceled;
  
  RequestProxyImpl$1(RequestProxyImpl paramRequestProxyImpl, String paramString, RequestProxy.RequestListener paramRequestListener) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
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
  
  public void onResponse(Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.val$listener.onRequestHeadersReceived(i, localMap);
    Object localObject = null;
    try
    {
      paramResponse = paramResponse.body().bytes();
      this.val$listener.onRequestSucceed(i, paramResponse, localMap);
      this.this$0.taskMap.remove(this.val$url);
      return;
    }
    catch (IOException paramResponse)
    {
      for (;;)
      {
        paramResponse.printStackTrace();
        paramResponse = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RequestProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */