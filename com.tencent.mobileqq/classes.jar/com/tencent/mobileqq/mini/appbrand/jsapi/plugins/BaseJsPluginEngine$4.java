package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.List;
import org.json.JSONObject;

class BaseJsPluginEngine$4
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$4(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, List paramList, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      this.this$0.onceSubMsgCallbackSuc(this.val$webview, this.val$allSubMsg, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.4
 * JD-Core Version:    0.7.0.1
 */