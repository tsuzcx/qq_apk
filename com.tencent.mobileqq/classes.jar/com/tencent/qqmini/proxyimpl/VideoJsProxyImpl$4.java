package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

class VideoJsProxyImpl$4
  implements Runnable
{
  VideoJsProxyImpl$4(VideoJsProxyImpl paramVideoJsProxyImpl, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt) {}
  
  public void run()
  {
    VideoJsProxyImpl.a(this.this$0, "正在获取视频封面，请稍候...");
    Object localObject = this.this$0;
    boolean bool = VideoJsProxyImpl.a((VideoJsProxyImpl)localObject, VideoJsProxyImpl.b((VideoJsProxyImpl)localObject, this.a), this.b);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveThumbnail : ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("VideoJsPlugin", 2, ((StringBuilder)localObject).toString());
    VideoJsProxyImpl.d(this.this$0);
    VideoJsProxyImpl.a(this.this$0, this.a, this.c, this.b, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */