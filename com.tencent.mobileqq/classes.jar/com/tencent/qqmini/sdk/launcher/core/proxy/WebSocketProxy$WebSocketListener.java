package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

public abstract interface WebSocketProxy$WebSocketListener
{
  public abstract void onClose(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onMessage(int paramInt, String paramString);
  
  public abstract void onMessage(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
 * JD-Core Version:    0.7.0.1
 */