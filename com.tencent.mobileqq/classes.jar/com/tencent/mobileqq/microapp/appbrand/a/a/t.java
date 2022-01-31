package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import org.json.JSONArray;

final class t
  implements f.a
{
  t(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt, String paramString3, JSONArray paramJSONArray, String paramString4) {}
  
  public String a()
  {
    if (!f.a(this.h, this.a)) {
      return f.a(this.h, this.b, this.c, null, "invalid encoding " + this.a, this.d);
    }
    if (b.a().g(this.e) != 2) {
      return f.a(this.h, this.b, this.c, null, "permission denied, open " + this.e, this.d);
    }
    String str = b.a().e(this.e);
    f.a(this.h, this.f, this.g, this.a, str);
    return f.a(this.h, this.b, this.c, null, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.t
 * JD-Core Version:    0.7.0.1
 */