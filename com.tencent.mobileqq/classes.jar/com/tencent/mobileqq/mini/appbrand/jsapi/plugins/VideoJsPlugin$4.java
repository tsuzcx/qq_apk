package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.qphone.base.util.QLog;

class VideoJsPlugin$4
  implements Runnable
{
  VideoJsPlugin$4(VideoJsPlugin paramVideoJsPlugin, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt) {}
  
  public void run()
  {
    VideoJsPlugin.access$900(this.this$0, AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime(), "正在获取视频封面，请稍后");
    boolean bool = VideoJsPlugin.access$1100(this.this$0, VideoJsPlugin.access$1000(this.this$0, this.val$path), this.val$info);
    QLog.d("VideoJsPlugin", 2, "saveThumbnail : " + bool);
    VideoJsPlugin.access$1200(this.this$0, AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime());
    VideoJsPlugin.access$1300(this.this$0, this.val$path, this.val$size, this.val$info, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */