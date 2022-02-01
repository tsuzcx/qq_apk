package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class CMShowJsPlugin$2
  implements MiniAppCmdInterface
{
  CMShowJsPlugin$2(CMShowJsPlugin paramCMShowJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject = new JSONObject(paramJSONObject.optString("result_data"));
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramJSONObject);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
        return;
      }
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
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */