package com.tencent.qgplayer.rtmpsdk;

import android.support.annotation.Nullable;
import java.util.List;

public abstract interface QGPlayer
{
  public abstract int getCurrentTime();
  
  public abstract float getDownloadAvgSpeed();
  
  @Nullable
  public abstract QGAVDownloadProfile getDownloadProfile();
  
  public abstract int getDuration();
  
  public abstract List<QGMediaStream> getMediaStreams();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isStarted();
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract boolean seek(int paramInt);
  
  public abstract void setCookie(String paramString);
  
  public abstract void setEnableFetchVideoFrameExtraData(boolean paramBoolean);
  
  public abstract void setEnableNativeAudioPlayer(boolean paramBoolean);
  
  public abstract void setHWVideoDec(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setPlayListener(IQGPlayListener paramIQGPlayListener);
  
  public abstract void setPlayerView(QGPlayerView paramQGPlayerView);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void start(String paramString, int paramInt1, int paramInt2);
  
  public abstract void start(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void start(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void start(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void stop(boolean paramBoolean);
  
  public abstract boolean switchClarify(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGPlayer
 * JD-Core Version:    0.7.0.1
 */