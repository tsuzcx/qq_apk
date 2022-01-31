package com.tencent.qqmini.sdk.runtime.plugin;

import bgkd;
import bgkk;
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
  
  public void insertLivePusher(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.b);
      int i = localJSONObject1.optInt("livePusherId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgkk.a(new LivePusherJsPlugin.1(this, localJSONObject1, i, parambgkd, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void operateLivePusher(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str = localJSONObject.optString("type");
      bgkk.a(new LivePusherJsPlugin.4(this, localJSONObject.optInt("livePusherId"), str, parambgkd, localJSONObject));
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
  
  public void removeLivePusher(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new LivePusherJsPlugin.3(this, new JSONObject(parambgkd.b).optInt("livePusherId"), parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void updateLivePusher(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new LivePusherJsPlugin.2(this, localJSONObject.optInt("livePusherId"), localJSONObject, parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */