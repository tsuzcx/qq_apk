package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.ReflectionUtils;
import java.util.Map;

class SystemWebViewClient$WebResourceRequestImpl2
  implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
{
  android.webkit.WebResourceRequest mWebResourceRequest;
  
  SystemWebViewClient$WebResourceRequestImpl2(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    this.mWebResourceRequest = paramWebResourceRequest;
  }
  
  public String getMethod()
  {
    return this.mWebResourceRequest.getMethod();
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.mWebResourceRequest.getRequestHeaders();
  }
  
  public Uri getUrl()
  {
    return this.mWebResourceRequest.getUrl();
  }
  
  public boolean hasGesture()
  {
    return this.mWebResourceRequest.hasGesture();
  }
  
  public boolean isForMainFrame()
  {
    return this.mWebResourceRequest.isForMainFrame();
  }
  
  public boolean isRedirect()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mWebResourceRequest, "isRedirect");
      if ((localObject instanceof Boolean)) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.WebResourceRequestImpl2
 * JD-Core Version:    0.7.0.1
 */