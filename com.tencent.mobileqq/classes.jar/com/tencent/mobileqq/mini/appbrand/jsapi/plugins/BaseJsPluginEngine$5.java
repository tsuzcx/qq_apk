package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$5
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$5(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString, JsRuntime paramJsRuntime, List paramList, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      this.this$0.onceSubMsgCallbackSuc(this.val$eventName, this.val$webview, this.val$allSubMsg, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.5
 * JD-Core Version:    0.7.0.1
 */