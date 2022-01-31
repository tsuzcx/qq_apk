package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.File;

final class r
  implements f.a
{
  r(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public String a()
  {
    if (b.a().g(this.a) == 2)
    {
      if (!TextUtils.isEmpty(b.a().d(this.a))) {
        return f.a(this.e, this.b, this.c, null, "file already exists " + this.a, this.d);
      }
      if (new File(b.a().e(this.a)).mkdirs()) {
        return f.a(this.e, this.b, this.c, null, this.d);
      }
      return f.a(this.e, this.b, this.c, null, "permission denied, open " + this.a, this.d);
    }
    return f.a(this.e, this.b, this.c, null, "permission denied, open " + this.a, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.r
 * JD-Core Version:    0.7.0.1
 */