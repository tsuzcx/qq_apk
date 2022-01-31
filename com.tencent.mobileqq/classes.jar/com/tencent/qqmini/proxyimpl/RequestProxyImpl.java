package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class RequestProxyImpl
  extends RequestProxy
{
  private static final String TAG = "RequestProxyImpl";
  public ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Call localCall = (Call)this.taskMap.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    this.taskMap.remove(paramString);
  }
  
  public boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    paramArrayOfByte = MiniOkHttpClientFactory.getRequestClient().newCall(HttpUtil.buildRequest(paramString1, paramMap, paramString2.toUpperCase(), null, paramArrayOfByte));
    paramArrayOfByte.enqueue(new RequestProxyImpl.1(this, paramString1, paramRequestListener));
    this.taskMap.put(paramString1, paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RequestProxyImpl
 * JD-Core Version:    0.7.0.1
 */