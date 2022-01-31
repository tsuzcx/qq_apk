package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePlayerJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_LIVE_VIDEO_PLAYER = "insertLivePlayer";
  private static final String EVENT_OPERATE_LIVE_VIDEO_PLAYER = "operateLivePlayer";
  private static final String EVENT_REMOVE_LIVE_VIDEO_PLAYER = "removeLivePlayer";
  private static final String EVENT_UPDATE_LIVE_VIDEO_PLAYER = "updateLivePlayer";
  public static final String TAG = "[mini] LivePlayerJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public LivePlayerJsPlugin()
  {
    this.eventMap.add("insertLivePlayer");
    this.eventMap.add("updateLivePlayer");
    this.eventMap.add("removeLivePlayer");
    this.eventMap.add("operateLivePlayer");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] LivePlayerJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("operateLivePlayer".equals(paramString1)) {}
    for (;;)
    {
      Object localObject;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        localObject = localJSONObject1.optString("type");
        AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.1(this, paramJsRuntime, localJSONObject1.optInt("livePlayerId"), (String)localObject, paramInt, localJSONObject1));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      if ("insertLivePlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString2);
          int i = localJSONObject2.optInt("livePlayerId");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("containerId", i);
          AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.2(this, paramJsRuntime, i, localJSONObject2, paramString1, (JSONObject)localObject, paramInt));
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("[mini] LivePlayerJsPlugin", 1, paramString1 + " error.", localJSONException2);
        }
      } else if ("updateLivePlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject3 = new JSONObject(paramString2);
          AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.3(this, paramJsRuntime, localJSONObject3.optInt("livePlayerId"), localJSONObject3, paramString1, paramInt));
        }
        catch (JSONException localJSONException3)
        {
          QLog.e("[mini] LivePlayerJsPlugin", 1, paramString1 + " error.", localJSONException3);
        }
      } else if ("removeLivePlayer".equals(paramString1)) {
        try
        {
          AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.4(this, paramJsRuntime, new JSONObject(paramString2).optInt("livePlayerId"), paramString1, paramInt));
        }
        catch (JSONException localJSONException4)
        {
          QLog.e("[mini] LivePlayerJsPlugin", 1, paramString1 + " error.", localJSONException4);
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */