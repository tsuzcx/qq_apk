package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import java.util.Map;

class SystemWebViewClient$e
  implements WebResourceRequest
{
  private String a;
  private boolean b;
  private boolean c;
  private boolean d;
  private String e;
  private Map<String, String> f;
  
  public SystemWebViewClient$e(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, Map<String, String> paramMap)
  {
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramString2;
    this.f = paramMap;
  }
  
  public String getMethod()
  {
    return this.e;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.f;
  }
  
  public Uri getUrl()
  {
    return Uri.parse(this.a);
  }
  
  public boolean hasGesture()
  {
    return this.d;
  }
  
  public boolean isForMainFrame()
  {
    return this.b;
  }
  
  public boolean isRedirect()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.e
 * JD-Core Version:    0.7.0.1
 */