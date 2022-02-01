package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.util.EmbeddedHelper;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
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
    return PageAction.obtain(this.mMiniAppContext).getPageId();
  }
  
  @JsEvent({"insertLivePlayer"})
  public void insertLivePlayer(RequestEvent paramRequestEvent)
  {
    QMLog.d("LivePlayerJsPlugin", "JsEvent insertLivePlayer");
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("livePlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.1(this, i, localJSONObject1, paramRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    QMLog.d("LivePlayerJsPlugin", paramRequestEvent.event);
    if ("insertLivePlayer".equals(paramRequestEvent.event)) {
      EmbeddedHelper.checkEmbeddedWidgetSupport(paramRequestEvent, this.mMiniAppContext.getMiniAppInfo().appId, this.mMiniAppContext.getAttachedActivity());
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"operateLivePlayer"})
  public void operateLivePlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("type");
      AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.4(this, localJSONObject.optInt("livePlayerId"), str, paramRequestEvent, localJSONObject));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"removeLivePlayer"})
  public void removeLivePlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams).optInt("livePlayerId"), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateLivePlayer"})
  public void updateLivePlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new LivePlayerJsPlugin.2(this, localJSONObject.optInt("livePlayerId"), localJSONObject, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePlayerJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */