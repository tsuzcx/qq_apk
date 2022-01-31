package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class by
  implements Runnable
{
  by(bj parambj, String paramString1, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.a).optJSONArray("array");
      g localg = new g(this.e.a.b());
      localObject = a.a((JSONArray)localObject);
      localg.a((String[])localObject);
      localg.a(localObject.length - 1);
      localg.a(new bz(this));
      localg.show();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("UIJsPlugin", 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.by
 * JD-Core Version:    0.7.0.1
 */