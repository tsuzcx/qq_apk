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
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramJSONObject);
      return;
    }
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = "")
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */