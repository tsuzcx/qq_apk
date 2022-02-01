package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;

class VideoVolumeControl$VideoStateListener
  implements OnPlayStateListener
{
  VideoVolumeControl$VideoStateListener(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 == 1) {
      return;
    }
    if (paramInt2 == 2) {
      return;
    }
    if (paramInt2 == 3)
    {
      paramVideoPlayParam = this.a;
      paramVideoPlayParam.setMute(paramVideoPlayParam.shouldMuteInReadInJoy(), "video playing", 1);
      if (!this.a.shouldMuteInReadInJoy()) {
        this.a.requestOrAbandonAudioFocus(true, "PLAY_STATE_PLAYING");
      }
    }
    else
    {
      if (paramInt2 == 4) {
        return;
      }
      if (paramInt2 == 5) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.VideoStateListener
 * JD-Core Version:    0.7.0.1
 */