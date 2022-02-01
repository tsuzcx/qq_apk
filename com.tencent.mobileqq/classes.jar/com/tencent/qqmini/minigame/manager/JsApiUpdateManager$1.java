package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

final class JsApiUpdateManager$1
  implements AsyncResult
{
  JsApiUpdateManager$1(MiniAppInfo paramMiniAppInfo, JsApiUpdateManager.IUpdateListener paramIUpdateListener, MiniAppFileManager paramMiniAppFileManager) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("JsApiUpdateManager", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      JsApiUpdateManager.access$002((MiniAppInfo)paramJSONObject.opt("mini_app_info_data"));
      if (JsApiUpdateManager.access$000() != null)
      {
        if (AppBrandUtil.needUpdate(this.val$oldMiniAppInfo, JsApiUpdateManager.access$000()))
        {
          JsApiUpdateManager.handleUpdateCheckResult(this.val$callback, true);
          JsApiUpdateManager.access$100(this.val$fileManager, JsApiUpdateManager.access$000(), this.val$callback);
          return;
        }
        JsApiUpdateManager.handleUpdateCheckResult(this.val$callback, false);
        return;
      }
      QMLog.e("JsApiUpdateManager", "onCmdListener newMiniAppInfo = null");
      return;
    }
    QMLog.e("JsApiUpdateManager", "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */