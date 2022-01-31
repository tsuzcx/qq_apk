package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;

final class i
  implements f.a
{
  i(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public String a()
  {
    if (TextUtils.isEmpty(b.a().d(this.a))) {
      return f.a(this.e, this.b, this.c, null, "no such file or directory " + this.a, this.d);
    }
    return f.a(this.e, this.b, this.c, null, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.i
 * JD-Core Version:    0.7.0.1
 */