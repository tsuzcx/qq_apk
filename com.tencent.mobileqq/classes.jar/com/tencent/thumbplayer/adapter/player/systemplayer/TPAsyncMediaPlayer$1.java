package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

class TPAsyncMediaPlayer$1
  implements MediaPlayer.OnSeekCompleteListener
{
  TPAsyncMediaPlayer$1(TPAsyncMediaPlayer paramTPAsyncMediaPlayer) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    synchronized (TPAsyncMediaPlayer.access$000(this.this$0))
    {
      TPAsyncMediaPlayer.access$102(this.this$0, false);
      ??? = TPAsyncMediaPlayer.access$200(this.this$0);
      if (??? != null) {
        ((MediaPlayer.OnSeekCompleteListener)???).onSeekComplete(paramMediaPlayer);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPAsyncMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */