package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bgor;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePusherJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
  private static final String EVENT_OPERATE_LIVE_PUSHER = "operateLivePusher";
  private static final String EVENT_REMOVE_LIVE_PUSHER = "removeLivePusher";
  private static final String EVENT_UPDATE_LIVE_PUSHER = "updateLivePusher";
  public static final String TAG = "LivePusherJsPlugin";
  
  public void insertLivePusher(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.b);
      int i = localJSONObject1.optInt("livePusherId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgor.a(new LivePusherJsPlugin.1(this, localJSONObject1, i, parambgok, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void operateLivePusher(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("type");
      bgor.a(new LivePusherJsPlugin.4(this, localJSONObject.optInt("livePusherId"), str, parambgok, localJSONObject));
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  public void removeLivePusher(bgok parambgok)
  {
    try
    {
      bgor.a(new LivePusherJsPlugin.3(this, new JSONObject(parambgok.b).optInt("livePusherId"), parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void updateLivePusher(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      bgor.a(new LivePusherJsPlugin.2(this, localJSONObject.optInt("livePusherId"), localJSONObject, parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */