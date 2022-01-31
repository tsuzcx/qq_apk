package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.text.TextUtils;
import bace;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import org.json.JSONObject;

final class q
  implements f.a
{
  q(f paramf, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt, String paramString3) {}
  
  public String a()
  {
    Object localObject = b.a().d(this.a);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return f.a(this.f, this.b, this.c, null, "tempFilePath file not exist", this.d);
    }
    if (TextUtils.isEmpty(this.e))
    {
      String str = b.a().f(this.a);
      if (!TextUtils.isEmpty(str))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("savedFilePath", str);
          return f.a(this.f, this.b, this.c, (JSONObject)localObject, this.d);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      return f.a(this.f, this.b, this.c, null, null, this.d);
    }
    if (b.a().g(this.e) != 2) {
      return f.a(this.f, this.b, this.c, null, "permission denied, open " + this.e, this.d);
    }
    bace.d((String)localObject, b.a().d(this.e));
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("savedFilePath", this.e);
      return f.a(this.f, this.b, this.c, (JSONObject)localObject, this.d);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.q
 * JD-Core Version:    0.7.0.1
 */