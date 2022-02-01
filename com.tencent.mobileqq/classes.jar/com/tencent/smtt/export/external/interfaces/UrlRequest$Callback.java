package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;
import java.util.HashMap;

public abstract class UrlRequest$Callback
{
  public void onCanceled(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo) {}
  
  public abstract void onFailed(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, X5netException paramX5netException);
  
  public abstract void onReadCompleted(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, ByteBuffer paramByteBuffer);
  
  public abstract void onRedirectReceived(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, String paramString);
  
  public abstract void onResponseStarted(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo);
  
  public abstract void onSucceeded(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo);
  
  public void shouldInterceptResponseHeader(UrlRequest paramUrlRequest, HashMap<String, String> paramHashMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.UrlRequest.Callback
 * JD-Core Version:    0.7.0.1
 */