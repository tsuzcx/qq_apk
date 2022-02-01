package com.tencent.mobileqq.mini.network.http;

import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
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
  private volatile boolean canceled = false;
  
  MiniappHttpUtil$1(String paramString, HttpCallBack paramHttpCallBack) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.val$url);
    QLog.e("MiniappHttpUtil", 1, paramCall.toString(), paramIOException);
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
    try
    {
      int i = paramResponse.code();
      GamePreConnectManager.onUrlConnect(this.val$url, i);
      paramCall = paramResponse.headers().toMultimap();
      this.val$callBack.headersReceived(i, paramCall);
      this.val$callBack.httpCallBack(i, paramResponse.body().bytes(), paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.1
 * JD-Core Version:    0.7.0.1
 */