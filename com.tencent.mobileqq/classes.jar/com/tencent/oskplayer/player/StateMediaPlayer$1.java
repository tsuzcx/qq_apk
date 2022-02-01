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
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PREPARED)) {
      if (!this.this$0.mThrowException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setMediaPlayerState to PREPARED in illegalState ");
        ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
        ((StringBuilder)localObject).append(this.this$0);
        ((StringBuilder)localObject).append("\n: stack\n");
        ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
      }
      else
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("setMediaPlayerState to PREPARED in illegalState ");
        paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
        paramIMediaPlayer.append(this.this$0);
        throw new StateMediaPlayerException(paramIMediaPlayer.toString());
      }
    }
    Object localObject = this.val$listener;
    if (localObject != null) {
      ((IMediaPlayer.OnPreparedListener)localObject).onPrepared(paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */