package com.tencent.qqmini.proxyimpl;

import bgnt;
import bjtz;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;

class VideoJsProxyImpl$5
  implements Runnable
{
  VideoJsProxyImpl$5(VideoJsProxyImpl paramVideoJsProxyImpl, LocalMediaInfo paramLocalMediaInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    QZLog.i("VideoJsPlugin", 1, "start copy from " + this.val$info.path);
    String str = bgnt.a().b(this.val$suffix);
    if (str.contains(" "))
    {
      QLog.w("VideoJsPlugin", 1, "wrong copy path " + str);
      str = bgnt.a().e(this.val$info.path);
      VideoJsProxyImpl.access$800(this.this$0, str, this.val$info.fileSize, this.val$info);
      return;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (bjtz.a(new File(this.val$info.path), localFile))
    {
      this.val$info.path = str;
      VideoJsProxyImpl.access$700(this.this$0, this.val$info, this.val$changeSize);
      return;
    }
    QLog.w("VideoJsPlugin", 1, "copy file failed");
    str = bgnt.a().e(this.val$info.path);
    VideoJsProxyImpl.access$800(this.this$0, str, this.val$info.fileSize, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */