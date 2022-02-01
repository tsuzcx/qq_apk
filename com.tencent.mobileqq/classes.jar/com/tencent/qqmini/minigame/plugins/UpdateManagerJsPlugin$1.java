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
    JSONObject localJSONObject;
    switch (paramMiniAppStateMessage.what)
    {
    default: 
      return;
    case 2054: 
      paramMiniAppStateMessage = (Boolean)paramMiniAppStateMessage.obj;
      QMLog.i("UpdateManagerJsPlugin", "checkResult hasUpdate:" + paramMiniAppStateMessage + ", currentAppInfo:" + UpdateManagerJsPlugin.access$000(this.this$0));
      if (UpdateManagerJsPlugin.access$100(this.this$0) != null) {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("hasUpdate", paramMiniAppStateMessage);
          UpdateManagerJsPlugin.access$100(this.this$0).evaluateSubscribeJS("onUpdateCheckResult", localJSONObject.toString(), -1);
          return;
        }
        catch (JSONException paramMiniAppStateMessage)
        {
          return;
        }
      }
      UpdateManagerJsPlugin.access$202(this.this$0, paramMiniAppStateMessage);
      return;
    }
    paramMiniAppStateMessage = (Boolean)paramMiniAppStateMessage.obj;
    QMLog.i("UpdateManagerJsPlugin", "downloadResult success:" + paramMiniAppStateMessage + ", currentAppInfo:" + UpdateManagerJsPlugin.access$300(this.this$0));
    if (UpdateManagerJsPlugin.access$100(this.this$0) != null) {}
    try
    {
      localJSONObject = new JSONObject();
      if (paramMiniAppStateMessage.booleanValue()) {}
      for (paramMiniAppStateMessage = "success";; paramMiniAppStateMessage = "failed")
      {
        localJSONObject.put("updateResult", paramMiniAppStateMessage);
        UpdateManagerJsPlugin.access$100(this.this$0).evaluateSubscribeJS("onUpdateDownloadResult", localJSONObject.toString(), -1);
        return;
      }
      UpdateManagerJsPlugin.access$402(this.this$0, paramMiniAppStateMessage);
      return;
    }
    catch (JSONException paramMiniAppStateMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */