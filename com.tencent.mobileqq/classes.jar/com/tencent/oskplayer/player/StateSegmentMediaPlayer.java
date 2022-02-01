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
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentProxySegmentUrl in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentProxySegmentUrl in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return ((ISegmentMediaPlayer)this.mInternalMediaPlayer).getCurrentProxySegmentUrl();
  }
  
  public String getCurrentSegmentUrl()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTSEGMENTURL))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentSegmentUrl in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentSegmentUrl in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
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
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getSegmentCount in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
    }
    else {
      return ((ISegmentMediaPlayer)this.mInternalMediaPlayer).getSegmentCount();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call getSegmentCount in illegalState ");
    localStringBuilder.append(getMediaPlayerState());
    localStringBuilder.append(this);
    throw new StateMediaPlayerException(localStringBuilder.toString());
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    StringBuilder localStringBuilder;
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramStreamInfo = new StringBuilder();
        paramStreamInfo.append("call setDataSource in illegalState ");
        paramStreamInfo.append(getMediaPlayerState());
        paramStreamInfo.append(this);
        throw new StateMediaPlayerException(paramStreamInfo.toString());
      }
    }
    if (!sVideoUrlValidator.isValid(paramStreamInfo)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramStreamInfo);
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramStreamInfo);
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    ((ISegmentMediaPlayer)this.mInternalMediaPlayer).setDataSource(paramStreamInfo);
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramStreamInfo = new StringBuilder();
        paramStreamInfo.append("call setDataSource in illegalState ");
        paramStreamInfo.append(getMediaPlayerState());
        paramStreamInfo.append(this);
        throw new StateMediaPlayerException(paramStreamInfo.toString());
      }
    }
    if (!sVideoUrlValidator.isValid(paramStreamInfo)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramStreamInfo);
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramStreamInfo);
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    ((ISegmentMediaPlayer)this.mInternalMediaPlayer).setDataSource(paramStreamInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateSegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */