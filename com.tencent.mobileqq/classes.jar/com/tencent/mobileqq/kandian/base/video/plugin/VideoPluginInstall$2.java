package com.tencent.mobileqq.kandian.base.video.plugin;

import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.qphone.base.util.QLog;

class VideoPluginInstall$2
  implements Runnable
{
  VideoPluginInstall$2(VideoPluginInstall paramVideoPluginInstall) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    if (!VideoPluginInstall.d()) {
      VideoPluginInstall.a(this.this$0);
    }
    try
    {
      VideoPluginInstall.c(this.this$0).a(new VideoPluginInstall.SDKInstallListener(VideoPluginInstall.b(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoSDKMgr.installPlugin ERROR e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e("Q.readinjoy.video", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */