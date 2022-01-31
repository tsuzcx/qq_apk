package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class UploaderProxyImpl$1$1
  implements Callback
{
  private volatile boolean canceled;
  
  UploaderProxyImpl$1$1(UploaderProxyImpl.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
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
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.this$1.val$listener.onUploadHeadersReceived(i, paramCall);
    this.this$1.val$listener.onUploadSucceed(i, paramResponse.body().bytes(), paramCall);
    this.this$1.this$0.taskMap.remove(this.this$1.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */