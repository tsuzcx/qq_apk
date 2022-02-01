package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.action.DebugSocketAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ProfileJsPlugin
  extends BaseJsPlugin
{
  private static final String API_TIME_PERFORMANCE_REAULT = "timePerformanceResult";
  public static final String TAG = "[mini] ProfileJsPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private String covertProfileToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + paramString + "}]}";
  }
  
  @JsEvent({"timePerformanceResult"})
  public void timePerformanceResult(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject = paramRequestEvent.optString("result", "");
      int i = paramRequestEvent.optInt("id", -1);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramRequestEvent = new JSONArray((String)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("id", i);
        ((JSONObject)localObject).put("result", paramRequestEvent);
        paramRequestEvent = covertProfileToIdeData(((JSONObject)localObject).toString());
        DebugSocketAction.obtain(this.mMiniAppContext).sendQQDebugMethodMsg("DebugMessageClient", paramRequestEvent);
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("[mini] ProfileJsPlugin", "qq API_TIME_PERFORMANCE_REAULT:", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.ProfileJsPlugin
 * JD-Core Version:    0.7.0.1
 */