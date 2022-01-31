package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePusherJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
  private static final String EVENT_OPERATE_LIVE_PUSHER = "operateLivePusher";
  private static final String EVENT_REMOVE_LIVE_PUSHER = "removeLivePusher";
  private static final String EVENT_UPDATE_LIVE_PUSHER = "updateLivePusher";
  public static final String TAG = "[mini] LivePusherJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public LivePusherJsPlugin()
  {
    this.eventMap.add("insertLivePusher");
    this.eventMap.add("updateLivePusher");
    this.eventMap.add("removeLivePusher");
    this.eventMap.add("operateLivePusher");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] LivePusherJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("insertLivePusher".equals(paramString1)) {}
    for (;;)
    {
      Object localObject;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        int i = localJSONObject1.optInt("livePusherId");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("containerId", i);
        AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.1(this, paramJsRuntime, i, localJSONObject1, paramString1, (JSONObject)localObject, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        QLog.e("[mini] LivePusherJsPlugin", 1, paramString1 + " error.", localJSONException1);
        continue;
      }
      if ("updateLivePusher".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString2);
          AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.2(this, paramJsRuntime, localJSONObject2.optInt("livePusherId"), localJSONObject2, paramString1, paramInt));
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("[mini] LivePusherJsPlugin", 1, paramString1 + " error.", localJSONException2);
        }
      } else if ("removeLivePusher".equals(paramString1)) {
        try
        {
          AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.3(this, paramJsRuntime, new JSONObject(paramString2).optInt("livePusherId"), paramString1, paramInt));
        }
        catch (JSONException localJSONException3)
        {
          QLog.e("[mini] LivePusherJsPlugin", 1, paramString1 + " error.", localJSONException3);
        }
      } else if ("operateLivePusher".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject3 = new JSONObject(paramString2);
          localObject = localJSONObject3.optString("type");
          AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.4(this, paramJsRuntime, localJSONObject3.optInt("livePusherId"), (String)localObject, paramInt, localJSONObject3));
        }
        catch (JSONException localJSONException4)
        {
          localJSONException4.printStackTrace();
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */