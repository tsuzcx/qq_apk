package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okio.Buffer;

class WebSocketProxyImpl$WebSocketTask$1
  implements WebSocketListener
{
  WebSocketProxyImpl$WebSocketTask$1(WebSocketProxyImpl.WebSocketTask paramWebSocketTask, WebSocketProxyImpl paramWebSocketProxyImpl) {}
  
  public void onClose(int paramInt, String paramString)
  {
    this.this$1.mListener.onClose(this.this$1.mSocketId, paramInt, paramString);
    this.this$1.this$0.taskMap.remove(Integer.valueOf(this.this$1.mSocketId));
  }
  
  public void onFailure(IOException paramIOException, Response paramResponse)
  {
    this.this$1.mListener.onError(this.this$1.mSocketId, HttpUtil.getRetCodeFrom(paramIOException, -1), "WebSocket error:network");
    this.this$1.this$0.taskMap.remove(Integer.valueOf(this.this$1.mSocketId));
  }
  
  public void onMessage(ResponseBody paramResponseBody)
  {
    this.this$1.mListener.onMessage(this.this$1.mSocketId, paramResponseBody.contentType().subtype(), paramResponseBody.bytes());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.this$1.mWebSocket = paramWebSocket;
    this.this$1.mListener.onOpen(this.this$1.mSocketId, paramResponse.code(), paramResponse.headers().toMultimap());
  }
  
  public void onPong(Buffer paramBuffer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask.1
 * JD-Core Version:    0.7.0.1
 */