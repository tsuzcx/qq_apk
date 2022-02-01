package com.tencent.mobileqq.kandian.glue.video;

import android.media.AudioManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class VideoVolumeControl$1
  implements Runnable
{
  VideoVolumeControl$1(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    Object localObject1;
    if (VideoVolumeControl.access$000(this.this$0))
    {
      if (VideoVolumeControl.access$100(this.this$0) != null) {
        VideoVolumeControl.access$100(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    else if (VideoVolumeControl.access$100(this.this$0) != null)
    {
      Object localObject2 = VideoVolumeControl.access$200(this.this$0).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (VideoPlayManager)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((VideoPlayManager)localObject1).g()) && (!((VideoPlayManager)localObject1).p()))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkPlayState  IsPlaying & not Mute When abandonAudioFocus:");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
      }
      localObject2 = VideoVolumeControl.access$300(this.this$0).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (VideoFeedsPlayManager)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((VideoFeedsPlayManager)localObject1).k()) && (!((VideoFeedsPlayManager)localObject1).j()))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkPlayState  IsPlaying & not Mute When abandonAudioFocus:");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
      }
      VideoVolumeControl.access$100(this.this$0).abandonAudioFocus(null);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mRequestOrAbandonAudioFocusCallBack isFocusAudio:");
      ((StringBuilder)localObject1).append(VideoVolumeControl.access$000(this.this$0));
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */