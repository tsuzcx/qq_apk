package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.Serializable;
import mqq.util.WeakReference;

final class f$a
  implements Serializable
{
  public String a;
  public String b;
  public WeakReference c;
  public int d;
  
  public f$a(f paramf, String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new WeakReference(paramBaseAppBrandWebview);
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */