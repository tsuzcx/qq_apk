package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import java.io.File;

class VideoJsPlugin$10
  implements MiniAppController.ActivityResultListener
{
  VideoJsPlugin$10(VideoJsPlugin paramVideoJsPlugin, Activity paramActivity, boolean paramBoolean) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = PreferenceManager.getDefaultSharedPreferences(this.val$activity).getString("miniapp_video_path", "");
        VideoJsPlugin.access$1500(this.this$0, new File(paramIntent), this.val$compress);
      }
      for (;;)
      {
        MiniAppController.getInstance().removeActivityResultListener(this);
        return true;
        VideoJsPlugin.access$600(this.this$0, VideoJsPlugin.access$500(this.this$0), "chooseVideo", null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */