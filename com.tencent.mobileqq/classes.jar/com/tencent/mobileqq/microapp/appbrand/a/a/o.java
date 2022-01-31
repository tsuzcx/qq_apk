package com.tencent.mobileqq.microapp.appbrand.a.a;

import bead;
import beae;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class o
  extends bead
{
  o(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {
      return;
    }
    try
    {
      if (parambeae.jdField_a_of_type_Int == 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesWritten", parambeae.jdField_a_of_type_Long);
        localJSONObject.put("totalBytesExpectedWrite", parambeae.jdField_a_of_type_Long);
        localJSONObject.put("state", "progressUpdate");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        parambeae = new JSONObject();
        parambeae.put("statusCode", 200);
        parambeae.put("downloadTaskId", this.b);
        parambeae.put("tempFilePath", b.a().c(this.c));
        parambeae.put("state", "success");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + parambeae + ")");
        return;
      }
    }
    catch (Throwable parambeae)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("state", "fail");
        localJSONObject.put("errMsg", "Download Failed:" + parambeae.getMessage());
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable parambeae)
      {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed:" + parambeae.jdField_a_of_type_Int);
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
    }
  }
  
  public void onProgress(beae parambeae)
  {
    super.onProgress(parambeae);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {}
    while ((parambeae.jdField_a_of_type_Long == 0L) || (parambeae.b == 0L)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("progress", (int)(parambeae.b * 100L / parambeae.jdField_a_of_type_Long));
      localJSONObject.put("totalBytesWritten", parambeae.b);
      localJSONObject.put("totalBytesExpectedWrite", parambeae.jdField_a_of_type_Long);
      localJSONObject.put("state", "progressUpdate");
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
      return;
    }
    catch (Throwable parambeae) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.o
 * JD-Core Version:    0.7.0.1
 */