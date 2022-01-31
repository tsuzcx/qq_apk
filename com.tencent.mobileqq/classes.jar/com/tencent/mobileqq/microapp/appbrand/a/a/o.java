package com.tencent.mobileqq.microapp.appbrand.a.a;

import bbwt;
import bbwu;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class o
  extends bbwt
{
  o(f paramf, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {
      return;
    }
    try
    {
      if (parambbwu.jdField_a_of_type_Int == 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesWritten", parambbwu.jdField_a_of_type_Long);
        localJSONObject.put("totalBytesExpectedWrite", parambbwu.jdField_a_of_type_Long);
        localJSONObject.put("state", "progressUpdate");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        parambbwu = new JSONObject();
        parambbwu.put("statusCode", 200);
        parambbwu.put("downloadTaskId", this.b);
        parambbwu.put("tempFilePath", b.a().c(this.c));
        parambbwu.put("state", "success");
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + parambbwu + ")");
        return;
      }
    }
    catch (Throwable parambbwu)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("downloadTaskId", this.b);
        localJSONObject.put("state", "fail");
        localJSONObject.put("errMsg", "Download Failed:" + parambbwu.getMessage());
        localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
        return;
      }
      catch (Throwable parambbwu)
      {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed:" + parambbwu.jdField_a_of_type_Int);
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
    }
  }
  
  public void onProgress(bbwu parambbwu)
  {
    super.onProgress(parambbwu);
    BaseAppBrandWebview localBaseAppBrandWebview = (BaseAppBrandWebview)this.a.get();
    if (localBaseAppBrandWebview == null) {}
    while ((parambbwu.jdField_a_of_type_Long == 0L) || (parambbwu.b == 0L)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.b);
      localJSONObject.put("progress", (int)(parambbwu.b * 100L / parambbwu.jdField_a_of_type_Long));
      localJSONObject.put("totalBytesWritten", parambbwu.b);
      localJSONObject.put("totalBytesExpectedWrite", parambbwu.jdField_a_of_type_Long);
      localJSONObject.put("state", "progressUpdate");
      localBaseAppBrandWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onDownloadTaskStateChange\", " + localJSONObject + ")");
      return;
    }
    catch (Throwable parambbwu) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.o
 * JD-Core Version:    0.7.0.1
 */