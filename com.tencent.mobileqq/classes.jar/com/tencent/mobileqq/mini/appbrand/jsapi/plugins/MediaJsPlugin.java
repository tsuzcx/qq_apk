package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
  private static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
  private static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
  private static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
  public static final String TAG = "[mini] MediaJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public MediaJsPlugin()
  {
    this.eventMap.add("operateVideoPlayer");
    this.eventMap.add("operateCamera");
    this.eventMap.add("updateCamera");
    this.eventMap.add("removeCamera");
    this.eventMap.add("insertVideoPlayer");
    this.eventMap.add("updateVideoPlayer");
    this.eventMap.add("removeVideoPlayer");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] MediaJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("operateVideoPlayer".equals(paramString1)) {}
    for (;;)
    {
      Object localObject;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        localObject = localJSONObject1.optString("type");
        AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.1(this, localJSONObject1.optInt("videoPlayerId"), (String)localObject, localJSONObject1.optString("data"), paramString1, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      if (("operateCamera".equals(paramString1)) || ("updateCamera".equals(paramString1)) || ("removeCamera".equals(paramString1))) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString2);
          QLog.d("[mini] MediaJsPlugin", 2, paramString2);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.2(this, paramString1, paramInt, localJSONObject2));
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      } else if ("insertVideoPlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject3 = new JSONObject(paramString2);
          int i = localJSONObject3.optInt("videoPlayerId");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("containerId", i);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.3(this, paramJsRuntime, i, localJSONObject3, paramString1, (JSONObject)localObject, paramInt));
        }
        catch (JSONException localJSONException3)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException3);
        }
      } else if ("updateVideoPlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject4 = new JSONObject(paramString2);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.4(this, paramJsRuntime, localJSONObject4.optInt("videoPlayerId"), localJSONObject4, paramString1, paramInt));
        }
        catch (JSONException localJSONException4)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException4);
        }
      } else if ("removeVideoPlayer".equals(paramString1)) {
        try
        {
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.5(this, paramJsRuntime, new JSONObject(paramString2).optInt("videoPlayerId"), paramString1, paramInt));
        }
        catch (JSONException localJSONException5)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException5);
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */