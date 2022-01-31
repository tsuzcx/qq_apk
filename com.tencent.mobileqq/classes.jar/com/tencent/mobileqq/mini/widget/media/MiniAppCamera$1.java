package com.tencent.mobileqq.mini.widget.media;

import bdnn;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppCamera$1
  implements MiniAppCamera.GetPhotoCallback
{
  MiniAppCamera$1(MiniAppCamera paramMiniAppCamera, String paramString, WebviewContainer paramWebviewContainer, int paramInt) {}
  
  public void onGetPhoto(String paramString)
  {
    if (bdnn.a(paramString))
    {
      paramString = ApiUtil.wrapCallbackFail(this.val$event, null);
      if (paramString != null) {}
      for (paramString = paramString.toString();; paramString = "")
      {
        this.val$wc.appBrandRuntime.serviceRuntime.evaluateCallbackJs(this.val$callbackId, paramString);
        return;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempImagePath", MiniAppFileManager.getInstance().getWxFilePath(paramString));
      this.val$wc.appBrandRuntime.serviceRuntime.evaluateCallbackJs(this.val$callbackId, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.1
 * JD-Core Version:    0.7.0.1
 */