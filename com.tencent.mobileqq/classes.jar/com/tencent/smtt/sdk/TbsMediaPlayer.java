package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;

public class TbsMediaPlayer
{
  private TbsMediaPlayerWizard mPlayerImpl = null;
  
  public TbsMediaPlayer(TbsMediaPlayerWizard paramTbsMediaPlayerWizard)
  {
    this.mPlayerImpl = paramTbsMediaPlayerWizard;
  }
  
  public void audio(int paramInt)
  {
    this.mPlayerImpl.audio(paramInt);
  }
  
  public void close()
  {
    this.mPlayerImpl.close();
  }
  
  public float getVolume()
  {
    return this.mPlayerImpl.getVolume();
  }
  
  public boolean isAvailable()
  {
    return this.mPlayerImpl.isAvailable();
  }
  
  public void pause()
  {
    this.mPlayerImpl.pause();
  }
  
  public void play()
  {
    this.mPlayerImpl.play();
  }
  
  public void seek(long paramLong)
  {
    this.mPlayerImpl.seek(paramLong);
  }
  
  public void setPlayerListener(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    this.mPlayerImpl.setPlayerListener(paramTbsMediaPlayerListener);
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.mPlayerImpl.setSurfaceTexture(paramSurfaceTexture);
  }
  
  public void setVolume(float paramFloat)
  {
    this.mPlayerImpl.setVolume(paramFloat);
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    this.mPlayerImpl.startPlay(paramString, paramBundle);
  }
  
  public void subtitle(int paramInt)
  {
    this.mPlayerImpl.subtitle(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */