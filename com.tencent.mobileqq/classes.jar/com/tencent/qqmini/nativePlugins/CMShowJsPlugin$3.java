package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class CMShowJsPlugin$3
  implements MiniAppCmdInterface
{
  CMShowJsPlugin$3(CMShowJsPlugin paramCMShowJsPlugin, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.optString("result_data"));
      QLog.i("CMShowJsPlugin", 1, "pre-resultData ready");
      if (this.a)
      {
        if (CMShowJsPlugin.a())
        {
          QLog.i("CMShowJsPlugin", 1, "isRequesting...avoid duplicate request.");
          return;
        }
        CMShowJsPlugin.a(true);
        CMShowKitFileManager.a(paramJSONObject, CMShowJsPlugin.b(this.c), new CMShowJsPlugin.3.1(this, paramJSONObject));
        return;
      }
      this.b.ok(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      label88:
      break label88;
    }
    this.b.fail();
    return;
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("errMsg");
    } else {
      paramJSONObject = "";
    }
    this.b.fail(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */