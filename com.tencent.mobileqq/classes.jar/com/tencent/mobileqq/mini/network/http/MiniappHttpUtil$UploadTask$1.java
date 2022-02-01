package com.tencent.mobileqq.mini.network.http;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class MiniappHttpUtil$UploadTask$1
  implements Callback
{
  MiniappHttpUtil$UploadTask$1(MiniappHttpUtil.UploadTask paramUploadTask) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.this$0.url);
    QLog.e("MiniappHttpUtil", 1, paramCall.toString(), paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.this$0.callBack.httpCallBack(-5, null, null);
      return;
    }
    this.this$0.callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(paramIOException, -1), null, null);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (!this.this$0.isCanceled)
    {
      int i = paramResponse.code();
      paramCall = paramResponse.headers().toMultimap();
      this.this$0.callBack.headersReceived(i, paramCall);
      this.this$0.callBack.httpCallBack(i, paramResponse.body().bytes(), paramCall);
      return;
    }
    QLog.w("MiniappHttpUtil", 1, "upload onResponse but canceled");
    this.this$0.callBack.httpCallBack(-5, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask.1
 * JD-Core Version:    0.7.0.1
 */