package com.tencent.plato.mqq.module;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.utils.FuncUtil;
import java.io.IOException;

class NetworkingModule$3
  implements Callback
{
  NetworkingModule$3(NetworkingModule paramNetworkingModule, int paramInt, IReadableMap paramIReadableMap) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    if (NetworkingModule.access$100(this.this$0)) {
      return;
    }
    NetworkingModule.access$200(this.this$0, this.val$requestId);
    FuncUtil.invoke(this.val$request.getFunction("fail"), new Object[] { new JSONWritableMap().put("code", -1).put("message", String.valueOf(paramIOException)) });
  }
  
  public void onResponse(Response paramResponse)
  {
    if (NetworkingModule.access$100(this.this$0)) {
      return;
    }
    NetworkingModule.access$200(this.this$0, this.val$requestId);
    ResponseBody localResponseBody = paramResponse.body();
    try
    {
      String str = this.val$request.getString("responseType", null);
      IReadableMap localIReadableMap = NetworkingModule.access$300(paramResponse.headers());
      Object localObject = str;
      if (str == null) {
        localObject = localIReadableMap.getString("Content-Type", null);
      }
      localObject = NetworkingModule.access$400(this.this$0, (String)localObject, localResponseBody);
      FuncUtil.invoke(this.val$request.getFunction("success"), new Object[] { new JSONWritableMap().put("code", paramResponse.code()).put("headers", localIReadableMap).put("data", localObject) });
      return;
    }
    catch (Exception paramResponse)
    {
      paramResponse.printStackTrace();
      FuncUtil.invoke(this.val$request.getFunction("fail"), new Object[] { new JSONWritableMap().put("code", -1).put("message", paramResponse.getMessage()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule.3
 * JD-Core Version:    0.7.0.1
 */