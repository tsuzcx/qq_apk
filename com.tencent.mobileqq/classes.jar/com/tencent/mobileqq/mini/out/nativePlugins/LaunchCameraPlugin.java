package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import born;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LaunchCameraPlugin
  implements NativePlugin
{
  private static final String APP_ID = "appId";
  private static final String DATA = "data";
  public static final String FILE_PATH = "file_path";
  private static final String FROM_TYPE = "from";
  public static final String IS_VIDEO = "is_video";
  public static final String MINI_BACK_FROM_NATIVE = "com.tencent.mobileqq.mini.out.nativePlugins.native_back";
  public static final String MINI_LAUNCH_AE_APP_ID = "mini_launch_ae_app_id";
  public static final String MINI_LAUNCH_CAMERA = "com.tencent.mobileqq.mini.out.nativePlugins.mini_launch_camera";
  public static final String MINI_LAUNCH_TAG = "mini_launch_ae_tag";
  public static final String NAME = "checkin_invokeGYCamera";
  public static final String TAG = "LaunchCameraPlugin";
  public static final String THUMB_PATH = "video_thumb_path";
  public static final String VIDEO_DURATION = "video_duration";
  private LaunchCameraPlugin.NativeBackBroadCast broadCast;
  private NativePlugin.JSContext jsContext;
  
  public void onDestroy()
  {
    if ((this.jsContext != null) && (this.jsContext.getActivity() != null)) {
      this.jsContext.getActivity().unregisterReceiver(this.broadCast);
    }
  }
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    if ((this.jsContext != null) && (this.jsContext.getActivity() != null)) {
      this.jsContext.getActivity().unregisterReceiver(this.broadCast);
    }
    this.jsContext = paramJSContext;
    if ((paramJSContext != null) && (paramJSContext.getActivity() != null))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
      Bundle localBundle = new Bundle();
      if (localJSONObject == null) {}
      try
      {
        QLog.e("LaunchCameraPlugin", 1, "data is null.");
        paramJSContext.evaluateCallback(false, new JSONObject(), "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          int i;
          String str;
          paramJSONObject.printStackTrace();
        }
      }
      QLog.d("LaunchCameraPlugin", 1, "data: " + localJSONObject.toString());
      paramJSONObject = "";
      i = born.a.a();
      str = "";
      if (localJSONObject.has("appId")) {
        paramJSONObject = localJSONObject.getString("appId");
      }
      if (localJSONObject.has("from")) {
        i = born.a(localJSONObject.getString("from")).a();
      }
      if (localJSONObject.has("widgetid")) {
        str = localJSONObject.getString("widgetid");
      }
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
      localBundle.putString("widgetid", str);
      paramJSContext.getActivity().getSharedPreferences("mini_launch_ae_tag", 0).edit().putString("mini_launch_ae_app_id", paramJSONObject).apply();
      QIPCClientHelper.getInstance().callServer("AECameraLaunchServer", "com.tencent.mobileqq.mini.out.nativePlugins.mini_launch_camera", localBundle, null);
      paramJSContext.evaluateCallback(true, new JSONObject(), "");
      paramJSONObject = paramJSContext.getActivity();
      paramJSContext = new LaunchCameraPlugin.NativeBackBroadCast(this, null);
      this.broadCast = paramJSContext;
      paramJSONObject.registerReceiver(paramJSContext, new IntentFilter("com.tencent.mobileqq.mini.out.nativePlugins.native_back"));
      return;
    }
    QLog.e("LaunchCameraPlugin", 1, "jsContext is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.LaunchCameraPlugin
 * JD-Core Version:    0.7.0.1
 */