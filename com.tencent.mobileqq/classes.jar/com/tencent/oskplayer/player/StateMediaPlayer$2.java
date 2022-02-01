package com.tencent.oskplayer.player;

import com.tencent.oskplayer.util.PlayerUtils;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class StateMediaPlayer$2
  implements IMediaPlayer.OnCompletionListener
{
  StateMediaPlayer$2(StateMediaPlayer paramStateMediaPlayer, IMediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      if (this.this$0.mThrowException) {
        throw new StateMediaPlayerException("setMediaPlayerState to PLAYBACK_COMPLETED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "setMediaPlayerState to PLAYBACK_COMPLETED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0 + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (this.val$listener != null) {
      this.val$listener.onCompletion(paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */