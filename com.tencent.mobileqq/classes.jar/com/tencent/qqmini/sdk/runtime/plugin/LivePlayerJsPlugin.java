package com.tencent.qqmini.sdk.runtime.plugin;

import bgie;
import bgkd;
import bgkk;
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
    return bgie.a(this.mMiniAppContext).a();
  }
  
  public void insertLivePlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.b);
      int i = localJSONObject1.optInt("livePlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgkk.a(new LivePlayerJsPlugin.1(this, i, localJSONObject1, parambgkd, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void operateLivePlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str = localJSONObject.optString("type");
      bgkk.a(new LivePlayerJsPlugin.4(this, localJSONObject.optInt("livePlayerId"), str, parambgkd, localJSONObject));
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
  
  public void removeLivePlayer(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new LivePlayerJsPlugin.3(this, new JSONObject(parambgkd.b).optInt("livePlayerId"), parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void updateLivePlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new LivePlayerJsPlugin.2(this, localJSONObject.optInt("livePlayerId"), localJSONObject, parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */