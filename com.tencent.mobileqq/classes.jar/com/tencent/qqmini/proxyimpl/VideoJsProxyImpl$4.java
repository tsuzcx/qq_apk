package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

class VideoJsProxyImpl$4
  implements Runnable
{
  VideoJsProxyImpl$4(VideoJsProxyImpl paramVideoJsProxyImpl, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt) {}
  
  public void run()
  {
    VideoJsProxyImpl.access$900(this.this$0, "正在获取视频封面，请稍后");
    boolean bool = VideoJsProxyImpl.access$1100(this.this$0, VideoJsProxyImpl.access$1000(this.this$0, this.val$path), this.val$info);
    QLog.d("VideoJsPlugin", 2, "saveThumbnail : " + bool);
    VideoJsProxyImpl.access$1200(this.this$0);
    VideoJsProxyImpl.access$1300(this.this$0, this.val$path, this.val$size, this.val$info, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */