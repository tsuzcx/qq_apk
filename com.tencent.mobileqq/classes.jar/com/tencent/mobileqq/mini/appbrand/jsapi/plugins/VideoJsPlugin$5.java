package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;

class VideoJsPlugin$5
  implements Runnable
{
  VideoJsPlugin$5(VideoJsPlugin paramVideoJsPlugin, LocalMediaInfo paramLocalMediaInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    QZLog.i("VideoJsPlugin", 1, "start copy from " + this.val$info.path);
    String str = MiniAppFileManager.getInstance().getTmpPath(this.val$suffix);
    if (str.contains(" "))
    {
      QLog.w("VideoJsPlugin", 1, "wrong copy path " + str);
      str = MiniAppFileManager.getInstance().getWxFilePath(this.val$info.path);
      VideoJsPlugin.access$800(this.this$0, str, this.val$info.fileSize, this.val$info);
      return;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (FileUtils.copyFile(new File(this.val$info.path), localFile))
    {
      this.val$info.path = str;
      VideoJsPlugin.access$700(this.this$0, this.val$info, this.val$changeSize);
      return;
    }
    QLog.w("VideoJsPlugin", 1, "copy file failed");
    str = MiniAppFileManager.getInstance().getWxFilePath(this.val$info.path);
    VideoJsPlugin.access$800(this.this$0, str, this.val$info.fileSize, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */