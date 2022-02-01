package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.RepeatRequestEvent;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativeFeatureJsPlugin";
  
  @JsEvent({"invokeNativePlugin"})
  public void invokeNativePlugin(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("api_name", null);
      this.mMiniAppContext.performAction(RepeatRequestEvent.obtain(paramRequestEvent, str));
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("NativeFeatureJsPlugin", "invokeNativePlugin err", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */