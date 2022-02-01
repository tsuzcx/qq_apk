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
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.ERROR)) {
      if (!this.this$0.mThrowException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setMediaPlayerState to ERROR in illegalState ");
        ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
        ((StringBuilder)localObject).append(this.this$0);
        ((StringBuilder)localObject).append("\n: stack\n");
        ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
      }
      else
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("setMediaPlayerState to ERROR in illegalState ");
        paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
        paramIMediaPlayer.append(this.this$0);
        throw new StateMediaPlayerException(paramIMediaPlayer.toString());
      }
    }
    Object localObject = this.val$listener;
    if (localObject != null) {
      return ((IMediaPlayer.OnErrorListener)localObject).onError(paramIMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */