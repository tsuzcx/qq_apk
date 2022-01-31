package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.apkg.g.d;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class n
  implements g.d
{
  n(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onInitApkgInfo(int paramInt, com.tencent.mobileqq.microapp.apkg.f paramf)
  {
    paramf = (BaseAppBrandWebview)this.a.get();
    if (paramf == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("taskId", this.b);
        localJSONObject.put("moduleName", this.c);
        if (paramInt == 0)
        {
          localJSONObject.put("state", "success");
          paramf.evaluteJs("WeixinJSBridge.subscribeHandler(\"onLoadSubPackageTaskStateChange\", " + localJSONObject + ")");
          return;
        }
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localJSONObject.put("taskId", this.b);
        localJSONObject.put("moduleName", this.c);
        localJSONObject.put("state", "fail");
        paramf.evaluteJs("WeixinJSBridge.subscribeHandler(\"onLoadSubPackageTaskStateChange\", " + localJSONObject + ")");
        localThrowable1.printStackTrace();
        return;
        localJSONObject.put("state", "fail");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.n
 * JD-Core Version:    0.7.0.1
 */