package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
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
    this.this$1.socketClosedCallbacked = true;
    this.this$1.mListener.onClose(this.this$1.mSocketId, paramInt, paramString);
    this.this$1.this$0.taskMap.remove(Integer.valueOf(this.this$1.mSocketId));
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    this.this$1.mListener.onError(this.this$1.mSocketId, HttpUtil.getRetCodeFrom(paramThrowable, -1), "WebSocket error:network");
    this.this$1.this$0.taskMap.remove(Integer.valueOf(this.this$1.mSocketId));
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.this$1.mListener.onMessage(this.this$1.mSocketId, paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.this$1.mListener.onMessage(this.this$1.mSocketId, paramByteString.toByteArray());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.this$1.mWebSocket = paramWebSocket;
    this.this$1.mListener.onOpen(this.this$1.mSocketId, paramResponse.code(), paramResponse.headers().toMultimap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask.1
 * JD-Core Version:    0.7.0.1
 */