package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

public abstract interface UploaderProxy$UploadListener
{
  public abstract void onUploadFailed(int paramInt, String paramString);
  
  public abstract void onUploadHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void onUploadProgress(float paramFloat, long paramLong1, long paramLong2);
  
  public abstract void onUploadSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener
 * JD-Core Version:    0.7.0.1
 */