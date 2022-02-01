package com.tencent.oskplayer.player;

import com.tencent.oskplayer.util.PlayerUtils;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class StateMediaPlayer$4
  implements IMediaPlayer.OnInfoListener
{
  StateMediaPlayer$4(StateMediaPlayer paramStateMediaPlayer, IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 701)
    {
      if ((StateMediaPlayer.access$000(this.this$0)) && (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))) {
        if (!this.this$0.mThrowException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setMediaPlayerState to PASSIVE_PAUSED in illegalState ");
          ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
          ((StringBuilder)localObject).append(this.this$0);
          ((StringBuilder)localObject).append("\n: stack\n");
          ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
          PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
        }
        else
        {
          paramIMediaPlayer = new StringBuilder();
          paramIMediaPlayer.append("setMediaPlayerState to PASSIVE_PAUSED in illegalState ");
          paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
          paramIMediaPlayer.append(this.this$0);
          throw new StateMediaPlayerException(paramIMediaPlayer.toString());
        }
      }
    }
    else if (paramInt1 == 3)
    {
      if ((StateMediaPlayer.access$100(this.this$0)) && (!StateMediaPlayer.access$200(this.this$0))) {
        if (!this.this$0.mThrowException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("VIDEO_RENDERING_START start without a valid surface ");
          ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append("\n: stack\n");
          ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
          PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
        }
        else
        {
          paramIMediaPlayer = new StringBuilder();
          paramIMediaPlayer.append("VIDEO_RENDERING_START start without a valid surface ");
          paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
          paramIMediaPlayer.append(this);
          throw new StateMediaPlayerException(paramIMediaPlayer.toString());
        }
      }
      if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STARTED)) {
        if (!this.this$0.mThrowException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setMediaPlayerState to STARTED in illegalState ");
          ((StringBuilder)localObject).append(this.this$0.getMediaPlayerState());
          ((StringBuilder)localObject).append(this.this$0);
          ((StringBuilder)localObject).append("\n: stack\n");
          ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
          PlayerUtils.log(5, "StateMediaPlayer", ((StringBuilder)localObject).toString());
        }
        else
        {
          paramIMediaPlayer = new StringBuilder();
          paramIMediaPlayer.append("setMediaPlayerState to STARTED in illegalState ");
          paramIMediaPlayer.append(this.this$0.getMediaPlayerState());
          paramIMediaPlayer.append(this.this$0);
          throw new StateMediaPlayerException(paramIMediaPlayer.toString());
        }
      }
      StateMediaPlayer.access$002(this.this$0, true);
    }
    Object localObject = this.val$listener;
    if (localObject != null) {
      return ((IMediaPlayer.OnInfoListener)localObject).onInfo(paramIMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */