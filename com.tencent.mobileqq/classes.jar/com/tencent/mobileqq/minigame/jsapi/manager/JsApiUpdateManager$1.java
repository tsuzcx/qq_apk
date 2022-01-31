package com.tencent.mobileqq.minigame.jsapi.manager;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class JsApiUpdateManager$1
  implements MiniAppCmdInterface
{
  JsApiUpdateManager$1(MiniAppConfig paramMiniAppConfig, GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("JsApiUpdateManager", 1, "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      JsApiUpdateManager.access$002(new MiniAppConfig(paramJSONObject));
      if (paramJSONObject != null)
      {
        if (AppBrandUtil.needUpdate(this.val$oldMiniAppConfig.config, paramJSONObject))
        {
          JsApiUpdateManager.handleUpdateCheckResult(this.val$gameJsPluginEngine, true);
          JsApiUpdateManager.access$100(this.val$gameJsPluginEngine, new MiniAppConfig(paramJSONObject));
          return;
        }
        JsApiUpdateManager.handleUpdateCheckResult(this.val$gameJsPluginEngine, false);
        return;
      }
      QLog.e("JsApiUpdateManager", 1, "onCmdListener newMiniAppInfo = null");
      return;
    }
    QLog.e("JsApiUpdateManager", 1, "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */