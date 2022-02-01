package com.tencent.ttpic.videoshelf.model.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;

class VideoShelfPlayer$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoShelfPlayer$1(VideoShelfPlayer paramVideoShelfPlayer) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.this$0.mVideoWidth = paramMediaPlayer.getVideoWidth();
    this.this$0.mVideoHeight = paramMediaPlayer.getVideoHeight();
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("mVideoWidth:");
    paramMediaPlayer.append(this.this$0.mVideoWidth);
    paramMediaPlayer.append(",mVideoHeight:");
    paramMediaPlayer.append(this.this$0.mVideoHeight);
    TTPTLogger.i("VideoShelfPlayer", paramMediaPlayer.toString());
    if (VideoShelfPlayer.access$000(this.this$0) != null) {
      VideoShelfPlayer.access$000(this.this$0).onChangVideoSize(this.this$0.mVideoWidth, this.this$0.mVideoHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer.1
 * JD-Core Version:    0.7.0.1
 */