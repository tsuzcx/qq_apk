package com.tencent.qqmini.nativePlugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class LaunchAECameraPlugin$AECameraBackBroadcastReceiver
  extends BroadcastReceiver
{
  private final String jdField_a_of_type_JavaLangString;
  
  public LaunchAECameraPlugin$AECameraBackBroadcastReceiver(LaunchAECameraPlugin paramLaunchAECameraPlugin, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (LaunchAECameraPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin).getContext() == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str1 = paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("video_thumb_path");
      long l = paramIntent.getLongExtra("video_duration", 0L);
      boolean bool = paramIntent.getBooleanExtra("is_video", false);
      paramContext = paramIntent.getSerializableExtra("extra_info");
      if ((paramContext instanceof HashMap))
      {
        paramContext = (HashMap)paramContext;
        if (paramContext != null)
        {
          if (paramContext.containsKey("material_result")) {
            localJSONObject.put("material_result", paramContext.get("material_result"));
          }
          if (paramContext.containsKey("extra_info_key_widget_id")) {
            localJSONObject.put("materialId", paramContext.get("extra_info_key_widget_id"));
          }
        }
        localJSONObject.put("filePath", ((IMiniAppFileManager)LaunchAECameraPlugin.b(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin).getManager(IMiniAppFileManager.class)).getWxFilePath(str1));
        if (bool) {}
        for (int i = 1;; i = 0)
        {
          localJSONObject.put("isVideo", i);
          if (bool)
          {
            localJSONObject.put("videoDuration", (999L + l) / 1000L);
            localJSONObject.put("cover", ((IMiniAppFileManager)LaunchAECameraPlugin.c(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin).getManager(IMiniAppFileManager.class)).getWxFilePath(str2));
          }
          paramContext = localJSONObject.toString();
          QLog.i("LaunchAECameraPlugin", 1, "AECameraBackBroadcastReceiver---sendBackTo=" + this.jdField_a_of_type_JavaLangString + ", data: " + paramContext);
          LaunchAECameraPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin, this.jdField_a_of_type_JavaLangString, paramContext);
          return;
        }
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchAECameraPlugin.AECameraBackBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */