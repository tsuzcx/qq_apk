package com.tencent.qqmini.sdk.core.proxy;

import java.util.Map;

public abstract class RequestProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.RequestProxy
 * JD-Core Version:    0.7.0.1
 */