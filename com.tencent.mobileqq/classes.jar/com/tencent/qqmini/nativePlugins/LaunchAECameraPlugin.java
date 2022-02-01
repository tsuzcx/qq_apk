package com.tencent.qqmini.nativePlugins;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
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
    if (this.mMiniAppContext.getContext() == null)
    {
      QLog.e("LaunchAECameraPlugin", 1, "activity is null");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localJSONObject = localJSONObject.optJSONObject("data");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("miniAppInvokeGYCamera--data=");
      ((StringBuilder)localObject).append(localJSONObject);
      QLog.i("LaunchAECameraPlugin", 1, ((StringBuilder)localObject).toString());
      if (localJSONObject == null)
      {
        QLog.e("LaunchAECameraPlugin", 1, "miniAppInvokeGYCamera--data is null.");
        paramRequestEvent.fail();
        return;
      }
      localObject = new Bundle();
      try
      {
        int i = AECameraEntry.I.a();
        if (localJSONObject.has("from")) {
          i = AECameraEntry.a(localJSONObject.getString("from")).a();
        }
        ((Bundle)localObject).putInt("VIDEO_STORY_FROM_TYPE", i);
        i = 200;
        if (localJSONObject.has("cmode")) {
          i = ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).switchModeToInt(localJSONObject.getString("cmode"));
        }
        ((Bundle)localObject).putInt("AECAMERA_MODE", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      a();
      a("custom_event_miniApp_onCameraInfoEvent");
      QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP", (Bundle)localObject, null);
      paramRequestEvent.ok();
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QLog.e("LaunchAECameraPlugin", 1, "miniAppInvokeGYCamera--Failed to handle miniAppInvokeGYCamera", paramRequestEvent);
    }
  }
  
  private void c(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (this.mMiniAppContext.getContext() != null)
      {
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playInvokeGYCamera--data=");
        ((StringBuilder)localObject).append(localJSONObject);
        QLog.i("LaunchAECameraPlugin", 1, ((StringBuilder)localObject).toString());
        if (localJSONObject == null)
        {
          QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--data is null.");
          paramRequestEvent.fail();
          return;
        }
        Bundle localBundle = new Bundle();
        localObject = "";
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
          localJSONException.printStackTrace();
        }
        a();
        a("custom_event_play_onCameraInfoEvent");
        QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY", localBundle, null);
        paramRequestEvent.ok();
        return;
      }
      QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--activity is null");
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--Failed to handle playInvokeGYCamera", paramRequestEvent);
    }
  }
  
  public void a(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        if (this.mMiniAppContext.getContext() != null)
        {
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
          Bundle localBundle = new Bundle();
          if (localJSONObject == null) {}
          try
          {
            QLog.e("LaunchAECameraPlugin", 1, "data is null.");
            paramRequestEvent.fail();
            return;
          }
          catch (JSONException localJSONException)
          {
            int i;
            boolean bool;
            String str2;
            localJSONException.printStackTrace();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("data: ");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("LaunchAECameraPlugin", 1, ((StringBuilder)localObject).toString());
          i = AECameraEntry.a.a();
          bool = localJSONObject.has("appId");
          str2 = "";
          if (bool)
          {
            localObject = localJSONObject.getString("appId");
            if (localJSONObject.has("from")) {
              i = AECameraEntry.a(localJSONObject.getString("from")).a();
            }
            if (localJSONObject.has("widgetid")) {
              str2 = localJSONObject.getString("widgetid");
            }
            localBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
            localBundle.putString("widgetid", str2);
            this.mMiniAppContext.getContext().getSharedPreferences("mini_launch_ae_tag", 0).edit().putString("mini_launch_ae_app_id", (String)localObject).apply();
            a();
            a("custom_event_checkin_onCameraInfoEvent");
            QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN", localBundle, null);
            paramRequestEvent.ok();
          }
        }
        else
        {
          QLog.e("LaunchAECameraPlugin", 1, "activity is null");
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QLog.e("LaunchAECameraPlugin", 1, "Failed to handle checkinInvokeGYCamera", paramRequestEvent);
        return;
      }
      String str1 = "";
    }
  }
  
  @JsEvent({"play_invokeGYCamera", "checkin_invokeGYCamera", "miniApp_invokeGYCamera"})
  public void launchAECamera(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchAECamera--JsEvent=");
    localStringBuilder.append(paramRequestEvent.event);
    QLog.i("LaunchAECameraPlugin", 1, localStringBuilder.toString());
    if ("checkin_invokeGYCamera".equals(paramRequestEvent.event))
    {
      a(paramRequestEvent);
      return;
    }
    if ("play_invokeGYCamera".equals(paramRequestEvent.event))
    {
      c(paramRequestEvent);
      return;
    }
    if ("miniApp_invokeGYCamera".equals(paramRequestEvent.event)) {
      b(paramRequestEvent);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("LaunchAECameraPlugin", 1, "onDestroy");
    super.onDestroy();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchAECameraPlugin
 * JD-Core Version:    0.7.0.1
 */