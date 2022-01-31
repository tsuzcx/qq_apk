package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import java.util.Map;

class SystemWebViewClient$WebResourceRequestImpl
  implements WebResourceRequest
{
  private boolean hasUserGesture;
  private boolean isMainFrame;
  private boolean isRedirect;
  private String method;
  private Map<String, String> requestHeaders;
  private String url;
  
  public SystemWebViewClient$WebResourceRequestImpl(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, Map<String, String> paramMap)
  {
    this.url = paramBoolean1;
    this.isMainFrame = paramBoolean2;
    this.isRedirect = paramBoolean3;
    this.hasUserGesture = paramString2;
    this.method = paramMap;
    Object localObject;
    this.requestHeaders = localObject;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  public Uri getUrl()
  {
    return Uri.parse(this.url);
  }
  
  public boolean hasGesture()
  {
    return this.hasUserGesture;
  }
  
  public boolean isForMainFrame()
  {
    return this.isMainFrame;
  }
  
  public boolean isRedirect()
  {
    return this.isRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.WebResourceRequestImpl
 * JD-Core Version:    0.7.0.1
 */