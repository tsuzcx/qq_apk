package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class UpdateAppJsPlugin$1
  implements UpdateAppJsPlugin.IAppUpdateListener
{
  UpdateAppJsPlugin$1(UpdateAppJsPlugin paramUpdateAppJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onGetAppUpdateResult(boolean paramBoolean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("updateMsg", paramString);
      if (paramBoolean)
      {
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, localJSONObject, this.val$callbackId);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, localJSONObject, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UpdateAppJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */