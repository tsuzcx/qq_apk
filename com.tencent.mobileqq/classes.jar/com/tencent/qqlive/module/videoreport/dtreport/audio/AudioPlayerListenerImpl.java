package com.tencent.qqlive.module.videoreport.dtreport.audio;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;

public class AudioPlayerListenerImpl
  implements IAudioPlayListener
{
  private static final String TAG = "AudioPlayerListenerImpl";
  private Object mAudioPlayer;
  private AudioSession mCurrentAudioSession;
  private boolean mIsCanStartAudioTime;
  
  public AudioPlayerListenerImpl(IAudioPlayer paramIAudioPlayer)
  {
    this.mAudioPlayer = paramIAudioPlayer;
  }
  
  private void audioBufferingEnd()
  {
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    setCurrentAudioSessionBufferingEnd();
  }
  
  private void audioBufferingStart()
  {
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    setCurrentAudioSessionBufferingStart();
  }
  
  private void audioPause()
  {
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    pauseCurrentAudioSession();
  }
  
  private void audioResume()
  {
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    resumeCurrentAudioSession();
  }
  
  private void audioStart()
  {
    endCurrentAudioSession();
    this.mIsCanStartAudioTime = canStartAudioTime();
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    startAudioSession();
  }
  
  private void audioStop()
  {
    if (!this.mIsCanStartAudioTime) {
      return;
    }
    endCurrentAudioSession();
  }
  
  private boolean canStartAudioTime()
  {
    return AudioDataManager.getInstance().getAudioInfo(this.mAudioPlayer) != null;
  }
  
  private void endCurrentAudioSession()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if ((localAudioSession != null) && (!localAudioSession.isInEndState())) {
      this.mCurrentAudioSession.audioEnd();
    }
  }
  
  private void pauseCurrentAudioSession()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if (localAudioSession != null) {
      localAudioSession.audioPause();
    }
  }
  
  private void resumeCurrentAudioSession()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if (localAudioSession != null) {
      localAudioSession.audioResume();
    }
  }
  
  private void setCurrentAudioSessionBufferingEnd()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if (localAudioSession != null) {
      localAudioSession.onBufferingEnd();
    }
  }
  
  private void setCurrentAudioSessionBufferingStart()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if (localAudioSession != null) {
      localAudioSession.onBufferingStart();
    }
  }
  
  private void startAudioSession()
  {
    AudioSession localAudioSession = this.mCurrentAudioSession;
    if (localAudioSession == null) {
      this.mCurrentAudioSession = new AudioSession(this.mAudioPlayer);
    } else {
      localAudioSession.reset();
    }
    this.mCurrentAudioSession.audioStart();
  }
  
  public void onAudioComplete(@NonNull IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "complete");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.4(this));
  }
  
  public void onAudioError(@NonNull IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    paramIAudioPlayer = new StringBuilder();
    paramIAudioPlayer.append("error ");
    paramIAudioPlayer.append(paramInt1);
    paramIAudioPlayer.append(", ");
    paramIAudioPlayer.append(paramInt2);
    Log.i("AudioPlayerListenerImpl", paramIAudioPlayer.toString());
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.7(this));
  }
  
  public void onAudioPause(IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "Pause");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.2(this));
  }
  
  public void onAudioProgressChanged(@NonNull IAudioPlayer paramIAudioPlayer, int paramInt1, int paramInt2)
  {
    paramIAudioPlayer = new StringBuilder();
    paramIAudioPlayer.append("progress, ");
    paramIAudioPlayer.append(paramInt1);
    paramIAudioPlayer.append(", ");
    paramIAudioPlayer.append(paramInt2);
    Log.i("AudioPlayerListenerImpl", paramIAudioPlayer.toString());
  }
  
  public void onAudioStart(boolean paramBoolean, @NonNull IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "Start");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.1(this, paramBoolean));
  }
  
  public void onAudioStop(@NonNull IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "Stop");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.3(this));
  }
  
  public void onBufferingEnd(@NonNull IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "bufferEnd");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.6(this));
  }
  
  public void onBufferingStart(@NonNull IAudioPlayer paramIAudioPlayer)
  {
    Log.i("AudioPlayerListenerImpl", "bufferStart");
    ThreadUtils.runOnUiThread(new AudioPlayerListenerImpl.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl
 * JD-Core Version:    0.7.0.1
 */