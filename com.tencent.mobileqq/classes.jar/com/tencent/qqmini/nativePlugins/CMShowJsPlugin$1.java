package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class CMShowJsPlugin$1
  implements MiniAppCmdInterface
{
  CMShowJsPlugin$1(CMShowJsPlugin paramCMShowJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.a.ok(paramJSONObject);
      return;
    }
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("errMsg");
    } else {
      paramJSONObject = "";
    }
    this.a.fail(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */