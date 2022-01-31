package com.tencent.qqmini.sdk.core.proxy;

import java.util.Map;

public abstract class WebSocketProxy
{
  public abstract boolean closeSocket(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean connectSocket(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, WebSocketProxy.WebSocketListener paramWebSocketListener);
  
  public abstract boolean send(String paramString1, String paramString2);
  
  public abstract boolean send(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.WebSocketProxy
 * JD-Core Version:    0.7.0.1
 */