package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import org.json.JSONException;
import org.json.JSONObject;

class UpdateManagerJsPlugin$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  UpdateManagerJsPlugin$1(UpdateManagerJsPlugin paramUpdateManagerJsPlugin) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    int i = paramMiniAppStateMessage.what;
    Object localObject;
    if (i != 2054)
    {
      if (i != 2055) {
        return;
      }
      paramMiniAppStateMessage = (Boolean)paramMiniAppStateMessage.obj;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadResult success:");
      ((StringBuilder)localObject).append(paramMiniAppStateMessage);
      ((StringBuilder)localObject).append(", currentAppInfo:");
      ((StringBuilder)localObject).append(UpdateManagerJsPlugin.access$300(this.this$0));
      QMLog.i("UpdateManagerJsPlugin", ((StringBuilder)localObject).toString());
      if (UpdateManagerJsPlugin.access$100(this.this$0) == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!paramMiniAppStateMessage.booleanValue()) {
          break label261;
        }
        paramMiniAppStateMessage = "success";
        ((JSONObject)localObject).put("updateResult", paramMiniAppStateMessage);
        UpdateManagerJsPlugin.access$100(this.this$0).evaluateSubscribeJS("onUpdateDownloadResult", ((JSONObject)localObject).toString(), -1);
        return;
      }
      catch (JSONException paramMiniAppStateMessage)
      {
        return;
      }
      UpdateManagerJsPlugin.access$402(this.this$0, paramMiniAppStateMessage);
      return;
      paramMiniAppStateMessage = (Boolean)paramMiniAppStateMessage.obj;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkResult hasUpdate:");
      ((StringBuilder)localObject).append(paramMiniAppStateMessage);
      ((StringBuilder)localObject).append(", currentAppInfo:");
      ((StringBuilder)localObject).append(UpdateManagerJsPlugin.access$000(this.this$0));
      QMLog.i("UpdateManagerJsPlugin", ((StringBuilder)localObject).toString());
      if (UpdateManagerJsPlugin.access$100(this.this$0) != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("hasUpdate", paramMiniAppStateMessage);
        UpdateManagerJsPlugin.access$100(this.this$0).evaluateSubscribeJS("onUpdateCheckResult", ((JSONObject)localObject).toString(), -1);
        return;
      }
      UpdateManagerJsPlugin.access$202(this.this$0, paramMiniAppStateMessage);
      return;
      label261:
      paramMiniAppStateMessage = "failed";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */