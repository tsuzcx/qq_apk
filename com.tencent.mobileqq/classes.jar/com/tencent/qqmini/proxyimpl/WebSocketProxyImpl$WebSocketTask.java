package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;

class WebSocketProxyImpl$WebSocketTask
{
  public WebSocketProxy.WebSocketListener mListener;
  private OkHttpClient mOkHttpClient;
  public int mSocketId;
  public String mUrl;
  public WebSocket mWebSocket;
  public boolean socketClosedCallbacked;
  
  public WebSocketProxyImpl$WebSocketTask(int paramInt1, String paramString, Map<String, String> paramMap, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    this.mSocketId = paramString;
    this.mUrl = paramMap;
    Iterator localIterator;
    this.mListener = localIterator;
    paramMap = new Request.Builder().url(paramMap).build().newBuilder();
    if (paramInt2 != null)
    {
      localIterator = paramInt2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.addHeader(str, (String)paramInt2.get(str));
      }
    }
    paramMap = paramMap.build();
    long l = paramWebSocketListener / 1000 + 1;
    this.mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.SECONDS).build();
    this.mOkHttpClient.newWebSocket(paramMap, new WebSocketProxyImpl.WebSocketTask.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask
 * JD-Core Version:    0.7.0.1
 */