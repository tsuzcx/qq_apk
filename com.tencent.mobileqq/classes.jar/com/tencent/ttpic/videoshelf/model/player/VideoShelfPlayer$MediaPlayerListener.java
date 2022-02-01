package com.tencent.ttpic.videoshelf.model.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;

class VideoShelfPlayer$MediaPlayerListener
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  VideoShelfPlayer$MediaPlayerListener(VideoShelfPlayer paramVideoShelfPlayer) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VideoShelfPlayer.access$000(this.this$0) != null) {
      VideoShelfPlayer.access$000(this.this$0).onCompletion();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (VideoShelfPlayer.access$000(this.this$0) != null) {
      VideoShelfPlayer.access$000(this.this$0).onError(paramInt1, "Mediaplayer播放失败。", paramMediaPlayer);
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (VideoShelfPlayer.access$000(this.this$0) != null) {
      VideoShelfPlayer.access$000(this.this$0).onPrepared(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer.MediaPlayerListener
 * JD-Core Version:    0.7.0.1
 */