package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.VideoUrlValidator;

public class StateSegmentMediaPlayer
  extends StateMediaPlayer
  implements ISegmentMediaPlayer
{
  public StateSegmentMediaPlayer(ISegmentMediaPlayer paramISegmentMediaPlayer, boolean paramBoolean)
  {
    super(paramISegmentMediaPlayer, paramBoolean);
  }
  
  public String getCurrentProxySegmentUrl()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPROXYSEGMENTURL))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getCurrentProxySegmentUrl in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getCurrentProxySegmentUrl in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    return ((ISegmentMediaPlayer)this.mInternalMediaPlayer).getCurrentProxySegmentUrl();
  }
  
  public String getCurrentSegmentUrl()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTSEGMENTURL))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getCurrentSegmentUrl in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getCurrentSegmentUrl in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    return ((ISegmentMediaPlayer)this.mInternalMediaPlayer).getCurrentSegmentUrl();
  }
  
  public ISegmentMediaPlayer getInternalMediaPlayer()
  {
    return (ISegmentMediaPlayer)this.mInternalMediaPlayer;
  }
  
  public int getSegmentCount()
  {
    if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.RELEASED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.IDLE))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getSegmentCount in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getSegmentCount in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    return ((ISegmentMediaPlayer)this.mInternalMediaPlayer).getSegmentCount();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (!sVideoUrlValidator.isValid(paramStreamInfo))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("VideoUrlValidationError " + paramStreamInfo + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "VideoUrlValidationError " + paramStreamInfo + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    ((ISegmentMediaPlayer)this.mInternalMediaPlayer).setDataSource(paramStreamInfo);
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (!sVideoUrlValidator.isValid(paramStreamInfo))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("VideoUrlValidationError " + paramStreamInfo + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "VideoUrlValidationError " + paramStreamInfo + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    ((ISegmentMediaPlayer)this.mInternalMediaPlayer).setDataSource(paramStreamInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateSegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */