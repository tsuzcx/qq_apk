package com.tencent.mobileqq.kandian.glue.viola.videonew;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class VideoPlayManager$1
  implements Runnable
{
  VideoPlayManager$1(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    Object localObject = this.a;
    VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject, VideoPlayManager.a(this.this$0, (VideoPlayManager.VideoPlayParam)localObject));
    if ((VideoPlayManager.VideoPlayParam.a(this.a) != null) && (VideoPlayManager.a(this.this$0) != null))
    {
      VideoPlayManager.VideoPlayParam.a(this.a).a(this.a.c);
      VideoPlayManager.b(this.this$0).add(VideoPlayManager.VideoPlayParam.a(this.a));
      VideoPlayManager.a(this.this$0).post(new VideoPlayManager.1.1(this));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = ");
      ((StringBuilder)localObject).append(VideoPlayManager.VideoPlayParam.a(this.a));
      ((StringBuilder)localObject).append(", mUIHandler = ");
      ((StringBuilder)localObject).append(VideoPlayManager.a(this.this$0));
      QLog.d("Viola.VideoPlayManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.1
 * JD-Core Version:    0.7.0.1
 */