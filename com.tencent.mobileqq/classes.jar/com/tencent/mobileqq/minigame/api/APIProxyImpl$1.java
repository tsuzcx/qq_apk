package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

class APIProxyImpl$1
  implements Callback
{
  APIProxyImpl$1(APIProxyImpl paramAPIProxyImpl, long paramLong1, String paramString, long paramLong2) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    GameLog.getInstance().i(APIProxyImpl.access$000(this.this$0), "httpRequest onFailure [timecost = " + (System.currentTimeMillis() - this.val$startMS) + "ms], url:" + this.val$url);
    paramCall = APIProxyImpl.access$100(this.this$0).getGameEngine().getNativeHttp();
    if (paramCall != null) {
      paramCall.httpCallBack(this.val$http, -1, null);
    }
    for (;;)
    {
      APIProxyImpl.access$200(this.this$0, System.currentTimeMillis() - this.val$startMS, -1);
      return;
      GameLog.getInstance().e(APIProxyImpl.access$000(this.this$0), "httpRequest onFailure but mTTEngine is null, url:" + this.val$url);
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = null;
    try
    {
      localObject = paramResponse.body().bytes();
      paramCall = (Call)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject;
        long l;
        localIOException.printStackTrace();
        continue;
        int i = -1;
        continue;
        GameLog.getInstance().e(APIProxyImpl.access$000(this.this$0), "httpRequest onResponse but mTTEngine is null, url:" + this.val$url);
      }
    }
    GameLog.getInstance().i(APIProxyImpl.access$000(this.this$0), "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.val$startMS) + "ms]");
    localObject = APIProxyImpl.access$100(this.this$0).getGameEngine().getNativeHttp();
    if (localObject != null)
    {
      l = this.val$http;
      if (paramCall != null)
      {
        i = paramResponse.code();
        ((ITHttp)localObject).httpCallBack(l, i, paramCall);
        APIProxyImpl.access$200(this.this$0, System.currentTimeMillis() - this.val$startMS, paramResponse.code());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */