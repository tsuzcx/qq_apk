package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import bdcs;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.io.File;

final class j
  implements f.a
{
  j(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public String a()
  {
    if (b.a().g(this.a) != 2) {
      return f.a(this.e, this.b, this.c, null, "permission denied, open " + this.a, this.d);
    }
    String str = b.a().d(this.a);
    if (TextUtils.isEmpty(str)) {
      return f.a(this.e, this.b, this.c, null, "no such file or directory, open " + this.a, this.d);
    }
    if (new File(str).isDirectory()) {
      return f.a(this.e, this.b, this.c, null, "operation not permitted, unlink " + this.a, this.d);
    }
    bdcs.a(str, false);
    return f.a(this.e, this.b, this.c, null, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.j
 * JD-Core Version:    0.7.0.1
 */