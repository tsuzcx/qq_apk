package com.tencent.mobileqq.mini.http;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class MiniappHttpUtil$1
  implements Callback
{
  private volatile boolean canceled;
  
  MiniappHttpUtil$1(String paramString, HttpCallBack paramHttpCallBack) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
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
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int i = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.val$callBack.headersReceived(i, paramCall);
    this.val$callBack.httpCallBack(i, paramResponse.body().bytes(), paramCall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniappHttpUtil.1
 * JD-Core Version:    0.7.0.1
 */