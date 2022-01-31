package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class MiniAppUtils$2$1
  implements MiniAppCmdInterface
{
  MiniAppUtils$2$1(MiniAppUtils.2 param2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppUtils.access$000(this.this$0.val$jsPluginEngine.activityContext, this.this$0.val$jsPluginEngine.appBrandRuntime.getApkgInfo().appId, "", paramJSONObject.optString("data"));
      this.this$0.val$jsPluginEngine.callbackJsEventOK(this.this$0.val$jsRuntime, this.this$0.val$eventName, paramJSONObject, this.this$0.val$callBackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.2.1
 * JD-Core Version:    0.7.0.1
 */