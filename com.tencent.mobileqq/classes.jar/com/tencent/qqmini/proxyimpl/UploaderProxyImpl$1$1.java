package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class UploaderProxyImpl$1$1
  implements Callback
{
  private volatile boolean canceled;
  
  UploaderProxyImpl$1$1(UploaderProxyImpl.1 param1) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    QLog.e("UploaderProxyImpl", 1, "httpConnect err url:" + this.this$1.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage())) {
      this.this$1.val$listener.onUploadFailed(-5, "download error:cancel");
    }
    for (;;)
    {
      this.this$1.this$0.taskMap.remove(this.this$1.val$url);
      return;
      this.this$1.val$listener.onUploadFailed(HttpUtil.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.this$1.val$listener.onUploadHeadersReceived(i, localMap);
    this.this$1.val$listener.onUploadSucceed(i, paramResponse.body().bytes(), localMap);
    this.this$1.this$0.taskMap.remove(this.this$1.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */