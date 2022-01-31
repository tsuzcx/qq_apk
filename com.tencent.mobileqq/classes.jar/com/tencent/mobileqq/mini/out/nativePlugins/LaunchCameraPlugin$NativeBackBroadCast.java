package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class LaunchCameraPlugin$NativeBackBroadCast
  extends BroadcastReceiver
{
  private LaunchCameraPlugin$NativeBackBroadCast(LaunchCameraPlugin paramLaunchCameraPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if ((LaunchCameraPlugin.access$100(this.this$0) == null) || (LaunchCameraPlugin.access$100(this.this$0).getActivity() == null)) {
      return;
    }
    paramContext = new JSONObject();
    try
    {
      String str1 = paramIntent.getStringExtra("file_path");
      String str2 = paramIntent.getStringExtra("video_thumb_path");
      long l = paramIntent.getLongExtra("video_duration", 0L);
      boolean bool = paramIntent.getBooleanExtra("is_video", false);
      paramContext.put("filePath", MiniAppFileManager.getInstance().getWxFilePath(str1));
      if (bool) {
        i = 1;
      }
      paramContext.put("isVideo", i);
      if (bool)
      {
        paramContext.put("videoDuration", (l + 999L) / 1000L);
        paramContext.put("cover", MiniAppFileManager.getInstance().getWxFilePath(str2));
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    QLog.e("LaunchCameraPlugin", 1, "data: " + paramContext);
    LaunchCameraPlugin.access$100(this.this$0).callJs("checkin_onCameraInfoEvent", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.LaunchCameraPlugin.NativeBackBroadCast
 * JD-Core Version:    0.7.0.1
 */