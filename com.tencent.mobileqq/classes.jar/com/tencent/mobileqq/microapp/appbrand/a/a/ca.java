package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.microapp.widget.b;
import java.util.Date;
import org.json.JSONObject;

final class ca
  implements Runnable
{
  ca(bj parambj, Date paramDate, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    b localb = new b(this.f.a.b());
    localb.a(a.c(this.a), a.d(this.a), a.e(this.a), new cb(this));
    localb.a(a.d(this.e.optString("start")));
    localb.b(a.d(this.e.optString("end")));
    localb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.ca
 * JD-Core Version:    0.7.0.1
 */