package com.tencent.smtt.sdk;

import java.io.InputStream;
import java.util.Map;

class SystemWebViewClient$WebResourceResponseImpl2
  extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
{
  android.webkit.WebResourceResponse mWebResourceResponse;
  
  public SystemWebViewClient$WebResourceResponseImpl2(android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.mWebResourceResponse = paramWebResourceResponse;
  }
  
  public InputStream getData()
  {
    return this.mWebResourceResponse.getData();
  }
  
  public String getEncoding()
  {
    return this.mWebResourceResponse.getEncoding();
  }
  
  public String getMimeType()
  {
    return this.mWebResourceResponse.getMimeType();
  }
  
  public String getReasonPhrase()
  {
    return this.mWebResourceResponse.getReasonPhrase();
  }
  
  public Map<String, String> getResponseHeaders()
  {
    return this.mWebResourceResponse.getResponseHeaders();
  }
  
  public int getStatusCode()
  {
    return this.mWebResourceResponse.getStatusCode();
  }
  
  public void setData(InputStream paramInputStream)
  {
    this.mWebResourceResponse.setData(paramInputStream);
  }
  
  public void setEncoding(String paramString)
  {
    this.mWebResourceResponse.setEncoding(paramString);
  }
  
  public void setMimeType(String paramString)
  {
    this.mWebResourceResponse.setMimeType(paramString);
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    this.mWebResourceResponse.setResponseHeaders(paramMap);
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    this.mWebResourceResponse.setStatusCodeAndReasonPhrase(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.WebResourceResponseImpl2
 * JD-Core Version:    0.7.0.1
 */