package com.tencent.qqmini.nativePlugins;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import dov.com.qq.im.ae.entry.AECameraEntry;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class LaunchAECameraPlugin
  extends BaseJsPlugin
{
  private LaunchAECameraPlugin.AECameraBackBroadcastReceiver a;
  
  private void a()
  {
    if ((this.a != null) && (this.mMiniAppContext.getContext() != null)) {}
    try
    {
      this.mMiniAppContext.getContext().unregisterReceiver(this.a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(String paramString)
  {
    if (this.mMiniAppContext.getContext() != null)
    {
      Context localContext = this.mMiniAppContext.getContext();
      paramString = new LaunchAECameraPlugin.AECameraBackBroadcastReceiver(this, paramString);
      this.a = paramString;
      localContext.registerReceiver(paramString, new IntentFilter("com.tencent.mobileqq.mini.out.nativePlugins.native_back"));
    }
  }
  
  private void b(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (this.mMiniAppContext.getContext() == null) {
        break label172;
      }
      localJSONObject = ((JSONObject)localObject).optJSONObject("data");
      QLog.i("LaunchAECameraPlugin", 1, "playInvokeGYCamera--data=" + localJSONObject);
      if (localJSONObject == null)
      {
        QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--data is null.");
        paramRequestEvent.fail();
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--Failed to handle playInvokeGYCamera", paramRequestEvent);
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = "";
    try
    {
      if (localJSONObject.has("widgetid")) {
        localObject = localJSONObject.getString("widgetid");
      }
      localBundle.putString("widgetid", (String)localObject);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.H.a());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    a();
    a("custom_event_play_onCameraInfoEvent");
    QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY", localBundle, null);
    paramRequestEvent.ok();
    return;
    label172:
    QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--activity is null");
  }
  
  public void a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (this.mMiniAppContext.getContext() == null) {
        break label262;
      }
      localJSONObject = ((JSONObject)localObject).optJSONObject("data");
      localBundle = new Bundle();
      if (localJSONObject == null) {}
      QLog.d("LaunchAECameraPlugin", 1, "data: " + localJSONObject.toString());
    }
    catch (JSONException paramRequestEvent)
    {
      try
      {
        QLog.e("LaunchAECameraPlugin", 1, "data is null.");
        paramRequestEvent.fail();
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          JSONObject localJSONObject;
          Bundle localBundle;
          int i;
          String str;
          localJSONException.printStackTrace();
        }
      }
      paramRequestEvent = paramRequestEvent;
      QLog.e("LaunchAECameraPlugin", 1, "Failed to handle checkinInvokeGYCamera", paramRequestEvent);
      return;
    }
    localObject = "";
    i = AECameraEntry.a.a();
    str = "";
    if (localJSONObject.has("appId")) {
      localObject = localJSONObject.getString("appId");
    }
    if (localJSONObject.has("from")) {
      i = AECameraEntry.a(localJSONObject.getString("from")).a();
    }
    if (localJSONObject.has("widgetid")) {
      str = localJSONObject.getString("widgetid");
    }
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    localBundle.putString("widgetid", str);
    this.mMiniAppContext.getContext().getSharedPreferences("mini_launch_ae_tag", 0).edit().putString("mini_launch_ae_app_id", (String)localObject).apply();
    a();
    a("custom_event_checkin_onCameraInfoEvent");
    QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN", localBundle, null);
    paramRequestEvent.ok();
    return;
    label262:
    QLog.e("LaunchAECameraPlugin", 1, "activity is null");
  }
  
  @JsEvent({"play_invokeGYCamera", "checkin_invokeGYCamera"})
  public void launchAECamera(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null) {}
    do
    {
      return;
      QLog.i("LaunchAECameraPlugin", 1, "launchAECamera--JsEvent=" + paramRequestEvent.event);
      if ("checkin_invokeGYCamera".equals(paramRequestEvent.event))
      {
        a(paramRequestEvent);
        return;
      }
    } while (!"play_invokeGYCamera".equals(paramRequestEvent.event));
    b(paramRequestEvent);
  }
  
  public void onDestroy()
  {
    QLog.d("LaunchAECameraPlugin", 1, "onDestroy");
    super.onDestroy();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchAECameraPlugin
 * JD-Core Version:    0.7.0.1
 */