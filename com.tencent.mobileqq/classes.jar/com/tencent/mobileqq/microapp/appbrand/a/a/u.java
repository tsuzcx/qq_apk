package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public final class u
  extends a
{
  Set b = null;
  public long c;
  
  public u()
  {
    this.b.add("showKeyboard");
    this.b.add("hideKeyboard");
    this.b.add("updateInput");
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InputJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    }
    if ("showKeyboard".equals(paramString1)) {
      if (System.currentTimeMillis() - this.c > 1000L)
      {
        this.c = System.currentTimeMillis();
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new v(this, paramBaseAppBrandWebview, paramString2, paramInt), 200L);
      }
    }
    for (;;)
    {
      return "";
      if ("hideKeyboard".equals(paramString1)) {
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new w(this, paramBaseAppBrandWebview, paramString2, paramInt));
      } else if ("updateInput".equals(paramString1)) {
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new x(this, paramString2, paramBaseAppBrandWebview, paramString1, paramInt));
      }
    }
  }
  
  public Set b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.u
 * JD-Core Version:    0.7.0.1
 */