package com.tencent.oskplayer.player;

import com.tencent.oskplayer.util.PlayerUtils;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class StateMediaPlayer$3
  implements IMediaPlayer.OnErrorListener
{
  StateMediaPlayer$3(StateMediaPlayer paramStateMediaPlayer, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.ERROR))
    {
      if (this.this$0.mThrowException) {
        throw new StateMediaPlayerException("setMediaPlayerState to ERROR in illegalState " + this.this$0.getMediaPlayerState() + this.this$0);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "setMediaPlayerState to ERROR in illegalState " + this.this$0.getMediaPlayerState() + this.this$0 + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (this.val$listener != null) {
      return this.val$listener.onError(paramIMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */