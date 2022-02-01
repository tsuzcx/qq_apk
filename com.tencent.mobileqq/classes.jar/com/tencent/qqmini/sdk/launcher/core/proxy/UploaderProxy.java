package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.Map;

public abstract class UploaderProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean upload(String paramString1, Map<String, String> paramMap1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap2, int paramInt, UploaderProxy.UploadListener paramUploadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy
 * JD-Core Version:    0.7.0.1
 */