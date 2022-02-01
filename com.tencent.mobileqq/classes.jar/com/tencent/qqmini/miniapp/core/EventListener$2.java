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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfoById onCmdListener() called with: isSuc = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], ret = [");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("]");
    QMLog.d("EventListener", ((StringBuilder)localObject).toString());
    if ((paramJSONObject != null) && (paramBoolean)) {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
    } else {
      paramJSONObject = null;
    }
    if (paramJSONObject != null)
    {
      paramBoolean = AppBrandUtil.needUpdate(this.val$oldMiniAppInfo, paramJSONObject);
    }
    else
    {
      QMLog.e("EventListener", "onCmdListener newMiniAppInfo = null");
      paramBoolean = false;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUpdate  needUpdate=");
      ((StringBuilder)localObject).append(paramBoolean);
      QMLog.i("EventListener", ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      if (paramBoolean) {
        ((JSONObject)localObject).put("state", "updating");
      } else {
        ((JSONObject)localObject).put("state", "noUpdate");
      }
      this.this$0.mRuntime.appBrandService.evaluateSubscribeJS("onUpdateStatusChange", ((JSONObject)localObject).toString(), 0);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateJSONObject error.");
      localStringBuilder.append(localException);
      QMLog.e("EventListener", localStringBuilder.toString());
    }
    if (paramBoolean) {
      EventListener.access$100(this.this$0, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.2
 * JD-Core Version:    0.7.0.1
 */