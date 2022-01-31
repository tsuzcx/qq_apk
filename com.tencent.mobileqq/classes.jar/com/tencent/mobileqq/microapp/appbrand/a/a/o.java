package com.tencent.mobileqq.microapp.appbrand.a.a;

import bbwf;
import bbwg;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class o
  extends bbwf
{
  o(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {
      return;
    }
    try
    {
      if (parambbwg.jdField_a_of_type_Int == 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesWritten", parambbwg.jdField_a_of_type_Long);
        localJSONObject.put("totalBytesExpectedWrite", parambbwg.jdField_a_of_type_Long);
        localJSONObject.put("state", "progressUpdate");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        parambbwg = new JSONObject();
        parambbwg.put("statusCode", 200);
        parambbwg.put("downloadTaskId", this.b);
        parambbwg.put("tempFilePath", b.a().c(this.c));
        parambbwg.put("state", "success");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + parambbwg + ")");
        return;
      }
    }
    catch (Throwable parambbwg)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("state", "fail");
        localJSONObject.put("errMsg", "Download Failed:" + parambbwg.getMessage());
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable parambbwg)
      {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed:" + parambbwg.jdField_a_of_type_Int);
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
    }
  }
  
  public void onProgress(bbwg parambbwg)
  {
    super.onProgress(parambbwg);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {}
    while ((parambbwg.jdField_a_of_type_Long == 0L) || (parambbwg.b == 0L)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("progress", (int)(parambbwg.b * 100L / parambbwg.jdField_a_of_type_Long));
      localJSONObject.put("totalBytesWritten", parambbwg.b);
      localJSONObject.put("totalBytesExpectedWrite", parambbwg.jdField_a_of_type_Long);
      localJSONObject.put("state", "progressUpdate");
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
      return;
    }
    catch (Throwable parambbwg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.o
 * JD-Core Version:    0.7.0.1
 */