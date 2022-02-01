package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase
{
  private static WebViewDatabase a;
  private Context b;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static WebViewDatabase a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new WebViewDatabase(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    return a(paramContext);
  }
  
  public void clearFormData()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().g(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().e(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().c(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
  }
  
  public boolean hasFormData()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().f(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().d(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().b(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewDatabase
 * JD-Core Version:    0.7.0.1
 */