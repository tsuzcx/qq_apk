package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
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
  private volatile boolean b = false;
  
  UploaderProxyImpl$1$1(UploaderProxyImpl.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.a.a);
    QLog.e("UploaderProxyImpl", 1, paramCall.toString(), paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage())) {
      this.a.g.onUploadFailed(-5, "download error:cancel");
    } else {
      this.a.g.onUploadFailed(HttpUtil.a(paramIOException, -1), "request error:network");
    }
    this.a.this$0.a.remove(this.a.a);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.b) {
      return;
    }
    int i = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.a.g.onUploadHeadersReceived(i, paramCall);
    this.a.g.onUploadSucceed(i, paramResponse.body().bytes(), paramCall);
    this.a.this$0.a.remove(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */