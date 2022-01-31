package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import org.json.JSONObject;

final class h
  implements f.a
{
  h(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt, String paramString3) {}
  
  public String a()
  {
    if (!f.a(this.f, this.a)) {
      return f.a(this.f, this.b, this.c, null, "invalid encoding " + this.a, this.d);
    }
    Object localObject = b.a().d(this.e);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return f.a(this.f, this.b, this.c, null, "no such file or directory, open " + this.e, this.d);
    }
    localObject = f.a(this.f, this.a, (String)localObject);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", localObject);
      localObject = f.a(this.f, this.b, this.c, localJSONObject, this.d);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      return f.a(this.f, this.b, this.c, null, localThrowable.getMessage(), this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.h
 * JD-Core Version:    0.7.0.1
 */