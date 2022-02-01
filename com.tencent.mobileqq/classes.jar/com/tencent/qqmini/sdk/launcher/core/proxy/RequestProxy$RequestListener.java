package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

public abstract interface RequestProxy$RequestListener
{
  public abstract void onRequestFailed(int paramInt, String paramString);
  
  public abstract void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
 * JD-Core Version:    0.7.0.1
 */