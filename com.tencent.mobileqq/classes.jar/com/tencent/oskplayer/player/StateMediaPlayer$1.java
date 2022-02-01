package com.tencent.oskplayer.player;

import com.tencent.oskplayer.util.PlayerUtils;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class StateMediaPlayer$1
  implements IMediaPlayer.OnPreparedListener
{
  StateMediaPlayer$1(StateMediaPlayer paramStateMediaPlayer, IMediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PREPARED))
    {
      if (this.this$0.mThrowException) {
        throw new StateMediaPlayerException("setMediaPlayerState to PREPARED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "setMediaPlayerState to PREPARED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0 + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (this.val$listener != null) {
      this.val$listener.onPrepared(paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */