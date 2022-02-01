package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class EventListener$2
  implements AsyncResult
{
  EventListener$2(EventListener paramEventListener, MiniAppInfo paramMiniAppInfo) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = false;
    QMLog.d("EventListener", "getAppInfoById onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean)) {}
    for (paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");; paramJSONObject = null)
    {
      if (paramJSONObject != null) {
        paramBoolean = AppBrandUtil.needUpdate(this.val$oldMiniAppInfo, paramJSONObject);
      }
      for (;;)
      {
        try
        {
          QMLog.i("EventListener", "checkUpdate  needUpdate=" + paramBoolean);
          localJSONObject = new JSONObject();
          if (!paramBoolean) {
            continue;
          }
          localJSONObject.put("state", "updating");
          this.this$0.mRuntime.appBrandService.evaluateSubscribeJS("onUpdateStatusChange", localJSONObject.toString(), 0);
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          QMLog.e("EventListener", "updateJSONObject error." + localException);
          continue;
        }
        if (paramBoolean) {
          EventListener.access$100(this.this$0, paramJSONObject);
        }
        return;
        QMLog.e("EventListener", "onCmdListener newMiniAppInfo = null");
        paramBoolean = bool;
        continue;
        localJSONObject.put("state", "noUpdate");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.2
 * JD-Core Version:    0.7.0.1
 */