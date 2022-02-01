package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public final class b
  extends a
{
  Set b = null;
  public long c;
  
  public b()
  {
    this.b.add("showKeyboard");
    this.b.add("hideKeyboard");
    this.b.add("updateInput");
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" |jsonParams: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" |callbackId:");
      localStringBuilder.append(paramInt);
      QLog.d("InputJsPlugin", 2, localStringBuilder.toString());
    }
    if ("showKeyboard".equals(paramString1))
    {
      if (System.currentTimeMillis() - this.c > 1000L)
      {
        this.c = System.currentTimeMillis();
        com.tencent.mobileqq.microapp.appbrand.b.a.a(new c(this, paramBaseAppBrandWebview, paramString2, paramInt), 200L);
      }
    }
    else if ("hideKeyboard".equals(paramString1)) {
      com.tencent.mobileqq.microapp.appbrand.b.a.a(new d(this, paramBaseAppBrandWebview, paramString2, paramInt));
    } else if ("updateInput".equals(paramString1)) {
      com.tencent.mobileqq.microapp.appbrand.b.a.a(new e(this, paramString2, paramBaseAppBrandWebview, paramString1, paramInt));
    }
    return "";
  }
  
  public Set a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.b
 * JD-Core Version:    0.7.0.1
 */