package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

public final class RepeatRequestEvent
  extends RequestEvent
  implements Action<String>
{
  private static final String TAG = "RepeatRequestEvent";
  private RequestEvent originRequestEvent;
  
  public static RepeatRequestEvent obtain(RequestEvent paramRequestEvent, String paramString)
  {
    RepeatRequestEvent localRepeatRequestEvent = new RepeatRequestEvent();
    localRepeatRequestEvent.originRequestEvent = paramRequestEvent;
    localRepeatRequestEvent.event = paramString;
    localRepeatRequestEvent.jsonParams = paramRequestEvent.jsonParams;
    localRepeatRequestEvent.callbackId = paramRequestEvent.callbackId;
    localRepeatRequestEvent.jsService = paramRequestEvent.jsService;
    return localRepeatRequestEvent;
  }
  
  public String cancel(JSONObject paramJSONObject)
  {
    return this.originRequestEvent.cancel(paramJSONObject);
  }
  
  public String fail(JSONObject paramJSONObject, String paramString)
  {
    return this.originRequestEvent.fail(paramJSONObject, paramString);
  }
  
  public String ok(JSONObject paramJSONObject)
  {
    return this.originRequestEvent.ok(paramJSONObject);
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsPluginEngine();
    if ((paramBaseRuntime instanceof JsPluginEngine))
    {
      paramBaseRuntime = (JsPluginEngine)paramBaseRuntime;
      QMLog.d("RepeatRequestEvent", "Dispatch repeat RequestEvent=" + this.event);
      return paramBaseRuntime.dispatchSecondaryRequestEvent(this);
    }
    QMLog.w("RepeatRequestEvent", "Failed to handle repeat RequestEvent=" + this.event);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RepeatRequestEvent
 * JD-Core Version:    0.7.0.1
 */