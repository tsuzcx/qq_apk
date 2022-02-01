package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RequestProxy
{
  private static AtomicInteger sRequestId = new AtomicInteger();
  
  public static int getRequestSocketId()
  {
    return sRequestId.getAndIncrement();
  }
  
  public abstract void abort(String paramString);
  
  public abstract boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
 * JD-Core Version:    0.7.0.1
 */