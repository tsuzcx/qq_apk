package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.luggage.wxa.sr.a;
import java.util.Map;

public class c$f
  implements com.tencent.xweb.WebResourceRequest
{
  private Uri a;
  private boolean b;
  private boolean c;
  private String d;
  private Map<String, String> e;
  private a f;
  
  public c$f(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.a = paramWebResourceRequest.getUrl();
      this.b = paramWebResourceRequest.isForMainFrame();
      this.c = paramWebResourceRequest.hasGesture();
      this.d = paramWebResourceRequest.getMethod();
      this.e = paramWebResourceRequest.getRequestHeaders();
      this.f = new a(this);
    }
  }
  
  public Uri a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public Map<String, String> d()
  {
    return this.e;
  }
  
  public Bundle e()
  {
    a locala = this.f;
    if (locala == null) {
      return null;
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.f
 * JD-Core Version:    0.7.0.1
 */