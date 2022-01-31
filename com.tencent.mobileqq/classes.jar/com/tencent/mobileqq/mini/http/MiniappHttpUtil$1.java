package com.tencent.mobileqq.mini.http;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Map;

final class MiniappHttpUtil$1
  implements Callback
{
  private volatile boolean canceled;
  
  MiniappHttpUtil$1(String paramString, HttpCallBack paramHttpCallBack) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    QLog.e("MiniappHttpUtil", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$callBack.httpCallBack(-5, null, null);
      return;
    }
    this.val$callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(paramIOException, -1), null, null);
  }
  
  public void onResponse(Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.val$callBack.headersReceived(i, localMap);
    this.val$callBack.httpCallBack(i, paramResponse.body().bytes(), localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniappHttpUtil.1
 * JD-Core Version:    0.7.0.1
 */