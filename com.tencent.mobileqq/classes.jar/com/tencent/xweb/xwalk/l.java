package com.tencent.xweb.xwalk;

import com.tencent.xweb.w;
import java.util.Map;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public class l
  extends w
{
  XWalkView a;
  
  public l(XWalkView paramXWalkView)
  {
    this.a = paramXWalkView;
  }
  
  public String a()
  {
    return this.a.getSettings().getUserAgentString();
  }
  
  public void a(int paramInt)
  {
    this.a.getSettings().setUsingForAppBrand(paramInt);
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    this.a.getSettings().setAppCachePath(paramString);
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.a.getSettings().setAppBrandInfo(paramMap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
  }
  
  public int b()
  {
    return this.a.getSettings().getForceDarkMode();
  }
  
  public void b(int paramInt)
  {
    this.a.getSettings().setTextZoom(paramInt);
  }
  
  public void b(String paramString)
  {
    this.a.getSettings().setUserAgentString(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.getSettings().setBuiltInZoomControls(paramBoolean);
  }
  
  public int c()
  {
    return this.a.getSettings().getForceDarkBehavior();
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    this.a.getSettings().setLoadWithOverviewMode(paramBoolean);
  }
  
  public void d(int paramInt)
  {
    this.a.getSettings().setForceDarkMode(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.getSettings().setSaveFormData(paramBoolean);
  }
  
  public void e(int paramInt)
  {
    this.a.getSettings().setForceDarkBehavior(paramInt);
  }
  
  public void e(boolean paramBoolean) {}
  
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
  
  public void k(boolean paramBoolean) {}
  
  public void l(boolean paramBoolean)
  {
    this.a.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
  }
  
  public void m(boolean paramBoolean)
  {
    this.a.getSettings().setBackgroundAudioPause(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */