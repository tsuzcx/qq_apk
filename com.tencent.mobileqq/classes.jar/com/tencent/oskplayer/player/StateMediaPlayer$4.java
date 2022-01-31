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
    if (paramInt1 == 701) {
      if ((StateMediaPlayer.access$000(this.this$0)) && (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED)))
      {
        if (this.this$0.mThrowException) {
          throw new StateMediaPlayerException("setMediaPlayerState to PASSIVE_PAUSED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0);
        }
        PlayerUtils.log(5, "StateMediaPlayer", "setMediaPlayerState to PASSIVE_PAUSED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0 + "\n: stack\n" + PlayerUtils.getStackTrace());
      }
    }
    while (this.val$listener != null)
    {
      return this.val$listener.onInfo(paramIMediaPlayer, paramInt1, paramInt2);
      if (paramInt1 == 3)
      {
        if ((StateMediaPlayer.access$100(this.this$0)) && (!StateMediaPlayer.access$200(this.this$0)))
        {
          if (this.this$0.mThrowException) {
            throw new StateMediaPlayerException("VIDEO_RENDERING_START start without a valid surface " + this.this$0.getMediaPlayerState() + this);
          }
          PlayerUtils.log(5, "StateMediaPlayer", "VIDEO_RENDERING_START start without a valid surface " + this.this$0.getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
        }
        if (!this.this$0.setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STARTED))
        {
          if (this.this$0.mThrowException) {
            throw new StateMediaPlayerException("setMediaPlayerState to STARTED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0);
          }
          PlayerUtils.log(5, "StateMediaPlayer", "setMediaPlayerState to STARTED in illegalState " + this.this$0.getMediaPlayerState() + this.this$0 + "\n: stack\n" + PlayerUtils.getStackTrace());
        }
        StateMediaPlayer.access$002(this.this$0, true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */