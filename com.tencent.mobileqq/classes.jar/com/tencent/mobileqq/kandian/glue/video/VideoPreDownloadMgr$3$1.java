package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPreDownloadMgr$3$1
  implements Runnable
{
  VideoPreDownloadMgr$3$1(VideoPreDownloadMgr.3 param3, VideoUrlInfo paramVideoUrlInfo) {}
  
  public void run()
  {
    if (this.a.b.equals(VideoPreDownloadMgr.b(this.b.b)))
    {
      if (this.b.b.a(this.a.a, this.a.b))
      {
        if (QLog.isColorLevel())
        {
          String str = VideoPreDownloadMgr.e();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
          localStringBuilder.append(this.a.b);
          QLog.i(str, 2, localStringBuilder.toString());
        }
        VideoPreDownloadMgr.a(this.b.b, null);
        VideoPreDownloadMgr.c(this.b.b);
        return;
      }
      VideoPreDownloadMgr.a(this.b.b, this.a.a, this.a.b, this.a.m, this.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */