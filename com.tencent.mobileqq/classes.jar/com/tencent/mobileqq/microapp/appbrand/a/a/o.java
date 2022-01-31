package com.tencent.mobileqq.microapp.appbrand.a.a;

import bdvu;
import bdvv;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class o
  extends bdvu
{
  o(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {
      return;
    }
    try
    {
      if (parambdvv.jdField_a_of_type_Int == 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesWritten", parambdvv.jdField_a_of_type_Long);
        localJSONObject.put("totalBytesExpectedWrite", parambdvv.jdField_a_of_type_Long);
        localJSONObject.put("state", "progressUpdate");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        parambdvv = new JSONObject();
        parambdvv.put("statusCode", 200);
        parambdvv.put("downloadTaskId", this.b);
        parambdvv.put("tempFilePath", b.a().c(this.c));
        parambdvv.put("state", "success");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + parambdvv + ")");
        return;
      }
    }
    catch (Throwable parambdvv)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("state", "fail");
        localJSONObject.put("errMsg", "Download Failed:" + parambdvv.getMessage());
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable parambdvv)
      {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed:" + parambdvv.jdField_a_of_type_Int);
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
    }
  }
  
  public void onProgress(bdvv parambdvv)
  {
    super.onProgress(parambdvv);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {}
    while ((parambdvv.jdField_a_of_type_Long == 0L) || (parambdvv.b == 0L)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("progress", (int)(parambdvv.b * 100L / parambdvv.jdField_a_of_type_Long));
      localJSONObject.put("totalBytesWritten", parambdvv.b);
      localJSONObject.put("totalBytesExpectedWrite", parambdvv.jdField_a_of_type_Long);
      localJSONObject.put("state", "progressUpdate");
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
      return;
    }
    catch (Throwable parambdvv) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.o
 * JD-Core Version:    0.7.0.1
 */