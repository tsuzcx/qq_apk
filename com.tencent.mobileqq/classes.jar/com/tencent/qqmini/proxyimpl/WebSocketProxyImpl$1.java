package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;

class WebSocketProxyImpl$1
  implements Runnable
{
  WebSocketProxyImpl$1(WebSocketProxyImpl paramWebSocketProxyImpl, WebSocketProxyImpl.WebSocketTask paramWebSocketTask, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (!this.val$task.socketClosedCallbacked) {
      this.val$task.mListener.onClose(this.val$socketId, this.val$code, this.val$reason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */