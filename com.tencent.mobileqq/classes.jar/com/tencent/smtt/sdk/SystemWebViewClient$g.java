package com.tencent.smtt.sdk;

import java.io.InputStream;
import java.util.Map;

class SystemWebViewClient$g
  extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
{
  android.webkit.WebResourceResponse a;
  
  public SystemWebViewClient$g(android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.a = paramWebResourceResponse;
  }
  
  public InputStream getData()
  {
    return this.a.getData();
  }
  
  public String getEncoding()
  {
    return this.a.getEncoding();
  }
  
  public String getMimeType()
  {
    return this.a.getMimeType();
  }
  
  public String getReasonPhrase()
  {
    return this.a.getReasonPhrase();
  }
  
  public Map<String, String> getResponseHeaders()
  {
    return this.a.getResponseHeaders();
  }
  
  public int getStatusCode()
  {
    return this.a.getStatusCode();
  }
  
  public void setData(InputStream paramInputStream)
  {
    this.a.setData(paramInputStream);
  }
  
  public void setEncoding(String paramString)
  {
    this.a.setEncoding(paramString);
  }
  
  public void setMimeType(String paramString)
  {
    this.a.setMimeType(paramString);
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    this.a.setResponseHeaders(paramMap);
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    this.a.setStatusCodeAndReasonPhrase(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.g
 * JD-Core Version:    0.7.0.1
 */