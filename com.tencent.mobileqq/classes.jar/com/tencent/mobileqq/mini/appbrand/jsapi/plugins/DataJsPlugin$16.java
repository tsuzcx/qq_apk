package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import org.json.JSONObject;

class DataJsPlugin$16
  implements MiniAppCmdInterface
{
  DataJsPlugin$16(DataJsPlugin paramDataJsPlugin, GameRuntimeLoader paramGameRuntimeLoader, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */