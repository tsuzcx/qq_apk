package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
  private ConcurrentHashMap<Integer, WebviewContainer> cameraMappingTableMap = new ConcurrentHashMap();
  Set<String> eventMap = new HashSet();
  private ConcurrentHashMap<Integer, WebviewContainer> videoMappingTableMap = new ConcurrentHashMap();
  
  public MediaJsPlugin()
  {
    this.eventMap.add("operateVideoPlayer");
    this.eventMap.add("insertCamera");
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
      Object localObject2;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        localObject2 = localJSONObject1.optString("type");
        AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.1(this, localJSONObject1.optInt("videoPlayerId"), (String)localObject2, localJSONObject1.optString("data"), paramString1, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      int i;
      label313:
      Object localObject1;
      if ("insertCamera".equals(paramString1)) {
        for (;;)
        {
          try
          {
            Object localObject3 = new JSONObject(paramString2);
            i = ((JSONObject)localObject3).optInt("cameraId");
            int j = ((JSONObject)localObject3).optInt("parentId");
            localObject2 = ((JSONObject)localObject3).optJSONObject("position");
            String str1 = ((JSONObject)localObject3).optString("flash");
            String str2 = ((JSONObject)localObject3).optString("devicePosition");
            if (!str1.equals("on")) {
              break label313;
            }
            str1 = "on";
            boolean bool = ((JSONObject)localObject3).optBoolean("fixed", false);
            localObject3 = ((JSONObject)localObject3).optString("mode");
            JSONObject localJSONObject4 = new JSONObject();
            localJSONObject4.put("containerId", i);
            AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.2(this, paramJsRuntime, i, j, str2, (JSONObject)localObject2, paramString1, localJSONObject4, paramInt, str1, bool, (String)localObject3));
          }
          catch (JSONException localJSONException2)
          {
            QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException2);
          }
          break;
          if (localJSONException2.equals("auto")) {
            localObject1 = "auto";
          } else {
            localObject1 = "off";
          }
        }
      }
      if (("operateCamera".equals(paramString1)) || ("updateCamera".equals(paramString1)) || ("removeCamera".equals(paramString1))) {
        try
        {
          localObject1 = new JSONObject(paramString2);
          QLog.d("[mini] MediaJsPlugin", 2, paramString2);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.3(this, ((JSONObject)localObject1).optInt("cameraId"), paramString1, paramInt, (JSONObject)localObject1));
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
        }
      } else if ("insertVideoPlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString2);
          i = localJSONObject2.optInt("videoPlayerId");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("containerId", i);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.4(this, paramJsRuntime, i, localJSONObject2, paramString1, (JSONObject)localObject2, paramInt));
        }
        catch (JSONException localJSONException4)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException4);
        }
      } else if ("updateVideoPlayer".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject3 = new JSONObject(paramString2);
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.5(this, paramJsRuntime, localJSONObject3.optInt("videoPlayerId"), localJSONObject3, paramString1, paramInt));
        }
        catch (JSONException localJSONException5)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException5);
        }
      } else if ("removeVideoPlayer".equals(paramString1)) {
        try
        {
          AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.6(this, new JSONObject(paramString2).optInt("videoPlayerId"), paramJsRuntime, paramString1, paramInt));
        }
        catch (JSONException localJSONException6)
        {
          QLog.e("[mini] MediaJsPlugin", 1, paramString1 + " error.", localJSONException6);
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */