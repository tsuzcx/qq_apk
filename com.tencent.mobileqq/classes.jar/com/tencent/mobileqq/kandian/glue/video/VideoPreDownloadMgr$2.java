package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader.Listener;
import com.tencent.qphone.base.util.QLog;

class VideoPreDownloadMgr$2
  implements IPlayerPreloader.Listener
{
  VideoPreDownloadMgr$2(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      String str = VideoPreDownloadMgr.e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("预下载回调 vid:");
      localStringBuilder.append(VideoPreDownloadMgr.b(this.a));
      QLog.i(str, 2, localStringBuilder.toString());
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      String str = VideoPreDownloadMgr.e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("预下载回调 vid:");
      localStringBuilder.append(VideoPreDownloadMgr.b(this.a));
      localStringBuilder.append(" SUCCESS");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */