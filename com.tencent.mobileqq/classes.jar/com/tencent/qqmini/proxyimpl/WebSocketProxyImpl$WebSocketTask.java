package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class WebSocketProxyImpl$WebSocketTask
{
  public WebSocketProxy.WebSocketListener mListener;
  private OkHttpClient mOkHttpClient;
  public String mUrl;
  public WebSocket mWebSocket;
  private WebSocketCall mWebSocketCall;
  
  public WebSocketProxyImpl$WebSocketTask(String paramString, Map<String, String> paramMap, int paramInt, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    this.mUrl = paramMap;
    Iterator localIterator;
    this.mListener = localIterator;
    paramMap = new Request.Builder().url(paramMap).build().newBuilder();
    if (paramInt != null)
    {
      localIterator = paramInt.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.addHeader(str, (String)paramInt.get(str));
      }
    }
    paramMap = paramMap.build();
    this.mOkHttpClient = new OkHttpClient();
    long l = paramWebSocketListener / 1000 + 1;
    this.mOkHttpClient.setConnectTimeout(l, TimeUnit.SECONDS);
    this.mOkHttpClient.setWriteTimeout(l, TimeUnit.SECONDS);
    this.mOkHttpClient.setReadTimeout(0L, TimeUnit.SECONDS);
    this.mWebSocketCall = WebSocketCall.create(this.mOkHttpClient, paramMap);
    this.mWebSocketCall.enqueue(new WebSocketProxyImpl.WebSocketTask.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask
 * JD-Core Version:    0.7.0.1
 */