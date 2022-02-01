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
      int i = 0;
      boolean bool = paramIntent.getBooleanExtra("is_video", false);
      paramIntent = paramIntent.getSerializableExtra("extra_info");
      paramContext = null;
      if ((paramIntent instanceof HashMap)) {
        paramContext = (HashMap)paramIntent;
      }
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
      if (bool) {
        i = 1;
      }
      localJSONObject.put("isVideo", i);
      if (bool)
      {
        localJSONObject.put("videoDuration", (l + 999L) / 1000L);
        localJSONObject.put("cover", ((IMiniAppFileManager)LaunchAECameraPlugin.c(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin).getManager(IMiniAppFileManager.class)).getWxFilePath(str2));
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = localJSONObject.toString();
    paramIntent = new StringBuilder();
    paramIntent.append("AECameraBackBroadcastReceiver---sendBackTo=");
    paramIntent.append(this.jdField_a_of_type_JavaLangString);
    paramIntent.append(", data: ");
    paramIntent.append(paramContext);
    QLog.i("LaunchAECameraPlugin", 1, paramIntent.toString());
    LaunchAECameraPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsLaunchAECameraPlugin, this.jdField_a_of_type_JavaLangString, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchAECameraPlugin.AECameraBackBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */