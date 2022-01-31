package com.tencent.qqmini.sdk.runtime.plugin;

import bgml;
import bgok;
import bgor;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePlayerJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_LIVE_VIDEO_PLAYER = "insertLivePlayer";
  private static final String EVENT_OPERATE_LIVE_VIDEO_PLAYER = "operateLivePlayer";
  private static final String EVENT_REMOVE_LIVE_VIDEO_PLAYER = "removeLivePlayer";
  private static final String EVENT_UPDATE_LIVE_VIDEO_PLAYER = "updateLivePlayer";
  public static final String TAG = "LivePlayerJsPlugin";
  
  private int getPageWebViewId()
  {
    return bgml.a(this.mMiniAppContext).a();
  }
  
  public void insertLivePlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.b);
      int i = localJSONObject1.optInt("livePlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgor.a(new LivePlayerJsPlugin.1(this, i, localJSONObject1, parambgok, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void operateLivePlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("type");
      bgor.a(new LivePlayerJsPlugin.4(this, localJSONObject.optInt("livePlayerId"), str, parambgok, localJSONObject));
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  public void removeLivePlayer(bgok parambgok)
  {
    try
    {
      bgor.a(new LivePlayerJsPlugin.3(this, new JSONObject(parambgok.b).optInt("livePlayerId"), parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void updateLivePlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      bgor.a(new LivePlayerJsPlugin.2(this, localJSONObject.optInt("livePlayerId"), localJSONObject, parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */