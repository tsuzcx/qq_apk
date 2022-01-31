package com.tencent.mobileqq.microapp.appbrand.a.a;

import batl;
import batm;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class o
  extends batl
{
  o(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {
      return;
    }
    try
    {
      if (parambatm.jdField_a_of_type_Int == 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesWritten", parambatm.jdField_a_of_type_Long);
        localJSONObject.put("totalBytesExpectedWrite", parambatm.jdField_a_of_type_Long);
        localJSONObject.put("state", "progressUpdate");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        parambatm = new JSONObject();
        parambatm.put("statusCode", 200);
        parambatm.put("downloadTaskId", this.b);
        parambatm.put("tempFilePath", b.a().c(this.c));
        parambatm.put("state", "success");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + parambatm + ")");
        return;
      }
    }
    catch (Throwable parambatm)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("state", "fail");
        localJSONObject.put("errMsg", "Download Failed:" + parambatm.getMessage());
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable parambatm)
      {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed:" + parambatm.jdField_a_of_type_Int);
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
    }
  }
  
  public void onProgress(batm parambatm)
  {
    super.onProgress(parambatm);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {}
    while ((parambatm.jdField_a_of_type_Long == 0L) || (parambatm.b == 0L)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("progress", (int)(parambatm.b * 100L / parambatm.jdField_a_of_type_Long));
      localJSONObject.put("totalBytesWritten", parambatm.b);
      localJSONObject.put("totalBytesExpectedWrite", parambatm.jdField_a_of_type_Long);
      localJSONObject.put("state", "progressUpdate");
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
      return;
    }
    catch (Throwable parambatm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.o
 * JD-Core Version:    0.7.0.1
 */