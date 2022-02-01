package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.i;
import java.util.Map;

class SystemWebViewClient$f
  implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
{
  android.webkit.WebResourceRequest a;
  
  SystemWebViewClient$f(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    this.a = paramWebResourceRequest;
  }
  
  public String getMethod()
  {
    return this.a.getMethod();
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.a.getRequestHeaders();
  }
  
  public Uri getUrl()
  {
    return this.a.getUrl();
  }
  
  public boolean hasGesture()
  {
    return this.a.hasGesture();
  }
  
  public boolean isForMainFrame()
  {
    return this.a.isForMainFrame();
  }
  
  public boolean isRedirect()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      Object localObject = i.a(this.a, "isRedirect");
      if ((localObject instanceof Boolean)) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.f
 * JD-Core Version:    0.7.0.1
 */