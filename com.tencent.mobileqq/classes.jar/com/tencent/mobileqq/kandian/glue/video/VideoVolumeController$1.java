package com.tencent.mobileqq.kandian.glue.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class VideoVolumeController$1
  implements Runnable
{
  VideoVolumeController$1(VideoVolumeController paramVideoVolumeController) {}
  
  public void run()
  {
    if (VideoVolumeController.access$200(this.this$0))
    {
      if (VideoVolumeController.access$300(this.this$0) != null) {
        VideoVolumeController.access$300(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    else if (VideoVolumeController.access$300(this.this$0) != null) {
      VideoVolumeController.access$300(this.this$0).abandonAudioFocus(null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRequestOrAbandonAudioFocusCallBack isFocusAudio:");
      localStringBuilder.append(VideoVolumeController.access$200(this.this$0));
      QLog.d("VideoVolumeController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.1
 * JD-Core Version:    0.7.0.1
 */