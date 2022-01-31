package com.tencent.qqmini.sdk.core.proxy;

import java.util.Map;

public abstract class WebSocketProxy
{
  public abstract boolean closeSocket(int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener);
  
  public abstract boolean send(int paramInt, String paramString);
  
  public abstract boolean send(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.WebSocketProxy
 * JD-Core Version:    0.7.0.1
 */