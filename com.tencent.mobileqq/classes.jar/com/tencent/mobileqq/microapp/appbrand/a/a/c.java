package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import org.json.JSONArray;
import org.json.JSONObject;

final class c
  implements Runnable
{
  c(b paramb, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, String paramString, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.g.a.a.g.getCurrentWebviewContainer();
    if (localWebviewContainer != null)
    {
      localWebviewContainer.drawCanvas(this.a, this.b, this.c, this.d, this.e, this.f);
      localObject = com.tencent.mobileqq.microapp.b.a.a(this.e, null);
      if (localObject == null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      localWebviewContainer.appBrandRuntime.i.evaluateCallbackJs(this.f, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.c
 * JD-Core Version:    0.7.0.1
 */