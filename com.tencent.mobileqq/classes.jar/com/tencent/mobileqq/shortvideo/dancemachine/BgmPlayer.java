package com.tencent.mobileqq.shortvideo.dancemachine;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.io.IOException;

public class BgmPlayer
  implements MediaPlayer.OnPreparedListener
{
  private boolean mPausedAudio = false;
  private MediaPlayer mediaPlayer = new MediaPlayer();
  
  public boolean isPlaying()
  {
    return this.mediaPlayer.isPlaying();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.mediaPlayer.start();
  }
  
  public void pauseAudio()
  {
    if (isPlaying())
    {
      this.mediaPlayer.pause();
      this.mPausedAudio = true;
    }
  }
  
  public void playAsync(String paramString)
  {
    try
    {
      this.mediaPlayer.reset();
      this.mediaPlayer.setDataSource(paramString);
      if (this.mediaPlayer.isPlaying()) {
        return;
      }
      this.mediaPlayer.setOnPreparedListener(this);
      this.mediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void playSync(String paramString)
  {
    try
    {
      this.mediaPlayer.reset();
      this.mediaPlayer.setDataSource(paramString);
      if (this.mediaPlayer.isPlaying()) {
        return;
      }
      this.mediaPlayer.prepare();
      this.mediaPlayer.start();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void releaseResource()
  {
    MediaPlayer localMediaPlayer = this.mediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
  }
  
  public void resumeAudio()
  {
    if (this.mPausedAudio)
    {
      this.mediaPlayer.start();
      this.mPausedAudio = false;
    }
  }
  
  public void stop()
  {
    if (this.mediaPlayer.isPlaying()) {
      this.mediaPlayer.stop();
    }
    this.mPausedAudio = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BgmPlayer
 * JD-Core Version:    0.7.0.1
 */