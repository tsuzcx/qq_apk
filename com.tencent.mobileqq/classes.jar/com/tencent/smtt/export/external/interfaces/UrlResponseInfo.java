package com.tencent.smtt.export.external.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class UrlResponseInfo
{
  public abstract Map<String, List<String>> getAllHeaders();
  
  public abstract List<Map.Entry<String, String>> getAllHeadersAsList();
  
  public abstract int getHttpStatusCode();
  
  public abstract String getHttpStatusText();
  
  public abstract String getNegotiatedProtocol();
  
  public abstract String getProxyServer();
  
  public abstract long getReceivedByteCount();
  
  public abstract String getUrl();
  
  public abstract List<String> getUrlChain();
  
  public abstract boolean wasCached();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.UrlResponseInfo
 * JD-Core Version:    0.7.0.1
 */