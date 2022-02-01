package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class WebSocketProxyImpl$WebSocketTask$1
  extends WebSocketListener
{
  WebSocketProxyImpl$WebSocketTask$1(WebSocketProxyImpl.WebSocketTask paramWebSocketTask, WebSocketProxyImpl paramWebSocketProxyImpl) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    paramWebSocket = this.b;
    paramWebSocket.e = true;
    paramWebSocket.c.onClose(this.b.a, paramInt, paramString);
    this.b.f.a.remove(Integer.valueOf(this.b.a));
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    QLog.e("WebSocketProxyImpl", 1, "onFailure : ", paramThrowable);
    this.b.c.onError(this.b.a, HttpUtil.a(paramThrowable, -1), paramThrowable.getMessage());
    this.b.f.a.remove(Integer.valueOf(this.b.a));
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.b.c.onMessage(this.b.a, paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.b.c.onMessage(this.b.a, paramByteString.toByteArray());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = this.b;
    localWebSocketTask.d = paramWebSocket;
    localWebSocketTask.c.onOpen(this.b.a, paramResponse.code(), paramResponse.headers().toMultimap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask.1
 * JD-Core Version:    0.7.0.1
 */