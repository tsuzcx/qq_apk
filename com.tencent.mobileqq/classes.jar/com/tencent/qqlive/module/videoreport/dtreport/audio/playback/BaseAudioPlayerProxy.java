package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

class BaseAudioPlayerProxy
  implements IAudioPlayerProxy
{
  @NonNull
  private IAudioPlayListener mAudioPlayListener;
  @NonNull
  IAudioPlayer mAudioPlayer;
  @Nullable
  private AudioListeners.OnPlayCompletionListener mBizCompletionListener;
  @Nullable
  private AudioListeners.OnPlayErrorListener mBizErrorListener;
  @Nullable
  private AudioListeners.OnPlayInfoListener mBizInfoListener;
  @Nullable
  private AudioListeners.OnPlayPreparedListener mBizPreparedListener;
  private int mState = -1;
  @NonNull
  private AudioProgressTimer mTimer;
  
  BaseAudioPlayerProxy(@NonNull IAudioPlayer paramIAudioPlayer)
  {
    this.mAudioPlayer = paramIAudioPlayer;
    this.mAudioPlayListener = new AudioPlayerListenerImpl(this.mAudioPlayer);
    this.mTimer = new AudioProgressTimer(paramIAudioPlayer, this);
  }
  
  public boolean isPaused()
  {
    return this.mState == 3;
  }
  
  public void onAudioCompletion(IAudioPlayer paramIAudioPlayer)
  {
    this.mAudioPlayListener.onAudioComplete(this.mAudioPlayer);
    this.mTimer.stop();
    if (this.mBizCompletionListener != null) {
      this.mBizCompletionListener.onAudioPlayComplete(this.mAudioPlayer);
    }
  }
  
  public boolean onAudioError(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    this.mState = 5;
    this.mAudioPlayListener.onAudioError(this.mAudioPlayer, paramInt1, paramInt2);
    this.mTimer.stop();
    if (this.mBizErrorListener != null) {
      return this.mBizErrorListener.onAudioError(this.mAudioPlayer, paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean onAudioInfo(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 701) {
      this.mAudioPlayListener.onBufferingStart(this.mAudioPlayer);
    }
    while (this.mBizInfoListener != null)
    {
      return this.mBizInfoListener.onAudioInfo(this.mAudioPlayer, paramInt1, paramInt2);
      if (paramInt1 == 702) {
        this.mAudioPlayListener.onBufferingEnd(this.mAudioPlayer);
      }
    }
    return false;
  }
  
  public void onAudioPrepared(IAudioPlayer paramIAudioPlayer)
  {
    if (this.mAudioPlayer.isAudioPlayer__()) {
      this.mState = 1;
    }
    if (this.mBizPreparedListener != null) {
      this.mBizPreparedListener.onAudioPlayPrepared(this.mAudioPlayer);
    }
  }
  
  public void onAudioProgressChanged(IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    this.mAudioPlayListener.onAudioProgressChanged(paramIAudioPlayer, paramInt1, paramInt2);
  }
  
  public void pause()
  {
    if (this.mState != -1)
    {
      this.mAudioPlayListener.onAudioPause(this.mAudioPlayer);
      this.mState = 3;
      this.mTimer.stop();
    }
  }
  
  public void prepare()
  {
    this.mState = -1;
  }
  
  public void reset()
  {
    if (this.mState != -1)
    {
      this.mAudioPlayListener.onAudioStop(this.mAudioPlayer);
      this.mState = -1;
      this.mTimer.stop();
    }
  }
  
  public void setOnCompletionListener(AudioListeners.OnPlayCompletionListener paramOnPlayCompletionListener)
  {
    this.mBizCompletionListener = paramOnPlayCompletionListener;
  }
  
  public void setOnErrorListener(AudioListeners.OnPlayErrorListener paramOnPlayErrorListener)
  {
    this.mBizErrorListener = paramOnPlayErrorListener;
  }
  
  public void setOnInfoListener(AudioListeners.OnPlayInfoListener paramOnPlayInfoListener)
  {
    this.mBizInfoListener = paramOnPlayInfoListener;
  }
  
  public void setOnPreparedListener(AudioListeners.OnPlayPreparedListener paramOnPlayPreparedListener)
  {
    this.mBizPreparedListener = paramOnPlayPreparedListener;
  }
  
  public void start()
  {
    if (this.mState == 1)
    {
      this.mState = 2;
      this.mAudioPlayListener.onAudioStart(true, this.mAudioPlayer);
      this.mTimer.start();
    }
    if (this.mState == 3)
    {
      this.mState = 2;
      this.mAudioPlayListener.onAudioStart(false, this.mAudioPlayer);
      this.mTimer.start();
    }
  }
  
  public void stop()
  {
    if (this.mState != -1)
    {
      this.mAudioPlayListener.onAudioStop(this.mAudioPlayer);
      this.mState = 4;
      this.mTimer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.BaseAudioPlayerProxy
 * JD-Core Version:    0.7.0.1
 */