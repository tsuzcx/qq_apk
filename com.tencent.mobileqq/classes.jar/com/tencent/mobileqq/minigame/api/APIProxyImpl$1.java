package com.tencent.mobileqq.minigame.api;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.io.IOException;

class APIProxyImpl$1
  implements Callback
{
  APIProxyImpl$1(APIProxyImpl paramAPIProxyImpl, long paramLong1, String paramString, long paramLong2) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    GameLog.getInstance().i("APIProxyImpl", "httpRequest onFailure [timecost = " + (System.currentTimeMillis() - this.val$startMS) + "ms], url:" + this.val$url);
    if (APIProxyImpl.access$000(this.this$0) != null) {
      APIProxyImpl.access$000(this.this$0).getNativeHttp().httpCallBack(this.val$http, -1, null);
    }
    for (;;)
    {
      APIProxyImpl.access$100(this.this$0, System.currentTimeMillis() - this.val$startMS, -1);
      return;
      GameLog.getInstance().e("APIProxyImpl", "httpRequest onFailure but mTTEngine is null, url:" + this.val$url);
    }
  }
  
  public void onResponse(Response paramResponse)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = paramResponse.body().bytes();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        long l;
        localIOException.printStackTrace();
        continue;
        int i = -1;
        continue;
        GameLog.getInstance().e("APIProxyImpl", "httpRequest onResponse but mTTEngine is null, url:" + this.val$url);
      }
    }
    GameLog.getInstance().i("APIProxyImpl", "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.val$startMS) + "ms]");
    if (APIProxyImpl.access$000(this.this$0) != null)
    {
      localObject2 = APIProxyImpl.access$000(this.this$0).getNativeHttp();
      l = this.val$http;
      if (localObject1 != null)
      {
        i = paramResponse.code();
        ((ITHttp)localObject2).httpCallBack(l, i, localObject1);
        APIProxyImpl.access$100(this.this$0, System.currentTimeMillis() - this.val$startMS, paramResponse.code());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */