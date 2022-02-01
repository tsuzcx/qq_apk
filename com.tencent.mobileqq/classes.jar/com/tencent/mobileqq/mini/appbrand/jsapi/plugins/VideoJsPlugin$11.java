package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import java.io.File;

class VideoJsPlugin$11
  implements MiniAppController.ActivityResultListener
{
  VideoJsPlugin$11(VideoJsPlugin paramVideoJsPlugin, File paramFile, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.val$videoFile.deleteOnExit();
      VideoJsPlugin.access$600(this.this$0, VideoJsPlugin.access$500(this.this$0), "chooseVideo", null);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    VideoJsPlugin.access$1500(this.this$0, this.val$videoFile, this.val$compress);
    MiniAppController.getInstance().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */