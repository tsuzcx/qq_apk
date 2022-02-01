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
    if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
      if (!this.this$0.mThrowException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setMediaPlayerState to PLAYBACK_COMPLETED in illegalState ");
        ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
        ((StringBuilder)localObject).append(this.this$0);
        ((StringBuilder)localObject).append("\n: stack\n");
        ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
      }
      else
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("setMediaPlayerState to PLAYBACK_COMPLETED in illegalState ");
        paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
        paramIMediaPlayer.append(this.this$0);
        throw new StateMediaPlayerException(paramIMediaPlayer.toString());
      }
    }
    Object localObject = this.val$listener;
    if (localObject != null) {
      ((IMediaPlayer.OnCompletionListener)localObject).onCompletion(paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */