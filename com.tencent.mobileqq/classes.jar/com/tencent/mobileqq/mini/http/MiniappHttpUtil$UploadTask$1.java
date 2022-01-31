package com.tencent.mobileqq.mini.http;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Map;

class MiniappHttpUtil$UploadTask$1
  implements Callback
{
  MiniappHttpUtil$UploadTask$1(MiniappHttpUtil.UploadTask paramUploadTask) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    QLog.e("MiniappHttpUtil", 1, "httpConnect err url:" + this.this$0.url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.this$0.callBack.httpCallBack(-5, null, null);
      return;
    }
    this.this$0.callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(paramIOException, -1), null, null);
  }
  
  public void onResponse(Response paramResponse)
  {
    if (!this.this$0.isCanceled)
    {
      int i = paramResponse.code();
      Map localMap = paramResponse.headers().toMultimap();
      this.this$0.callBack.headersReceived(i, localMap);
      this.this$0.callBack.httpCallBack(i, paramResponse.body().bytes(), localMap);
      return;
    }
    QLog.w("MiniappHttpUtil", 1, "upload onResponse but canceled");
    this.this$0.callBack.httpCallBack(-5, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniappHttpUtil.UploadTask.1
 * JD-Core Version:    0.7.0.1
 */