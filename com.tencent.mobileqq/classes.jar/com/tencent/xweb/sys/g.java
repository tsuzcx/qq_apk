package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.xweb.w;
import java.util.Map;

public class g
  extends w
{
  WebView a;
  String b = "";
  
  public g(WebView paramWebView)
  {
    this.a = paramWebView;
    a();
  }
  
  public String a()
  {
    String str = this.b;
    if ((str == null) || (str.isEmpty())) {}
    try
    {
      this.b = this.a.getSettings().getUserAgentString();
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    Log.e("SysWebViewSettings", "getUserAgentString: failed");
    return this.b;
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    this.a.getSettings().setAppCacheMaxSize(paramLong);
  }
  
  public void a(String paramString)
  {
    this.a.getSettings().setAppCachePath(paramString);
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.a.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    this.a.getSettings().setTextZoom(paramInt);
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
    this.a.getSettings().setUserAgentString(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.getSettings().setBuiltInZoomControls(paramBoolean);
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.getSettings().setMixedContentMode(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.getSettings().setLoadWithOverviewMode(paramBoolean);
  }
  
  public void d(int paramInt) {}
  
  public void d(boolean paramBoolean)
  {
    this.a.getSettings().setSaveFormData(paramBoolean);
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean)
  {
    this.a.getSettings().setSavePassword(paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.a.getSettings().setUseWideViewPort(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    this.a.getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    this.a.getSettings().setAppCacheEnabled(paramBoolean);
  }
  
  public void i(boolean paramBoolean)
  {
    this.a.getSettings().setDatabaseEnabled(paramBoolean);
  }
  
  public void j(boolean paramBoolean)
  {
    this.a.getSettings().setDomStorageEnabled(paramBoolean);
  }
  
  public void k(boolean paramBoolean)
  {
    this.a.getSettings().setGeolocationEnabled(paramBoolean);
  }
  
  public void l(boolean paramBoolean)
  {
    this.a.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
  }
  
  public void m(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.g
 * JD-Core Version:    0.7.0.1
 */