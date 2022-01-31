package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import bgrq;
import bgrr;
import bgrs;
import bgrt;
import bgru;
import bgrv;
import bgrw;
import bgrx;
import bgry;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import java.io.FileDescriptor;
import java.util.Map;

public class OskReliableVideoPlayerImpl
  implements bgrq
{
  private OskExoMediaPlayer player = new OskExoMediaPlayer();
  
  public int getAudioSessionId()
  {
    return this.player.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    return this.player.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    return this.player.getDataSource();
  }
  
  public long getDuration()
  {
    return this.player.getDuration();
  }
  
  public int getScore()
  {
    return this.player.getScore();
  }
  
  public int getVideoHeight()
  {
    return this.player.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.player.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.player.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    return this.player.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.player.isLooping();
  }
  
  public boolean isPlayable()
  {
    return this.player.isPlayable();
  }
  
  public boolean isPlaying()
  {
    return this.player.isPlaying();
  }
  
  public void pause()
  {
    this.player.pause();
  }
  
  public void prepareAsync()
  {
    this.player.prepareAsync();
  }
  
  public void release()
  {
    this.player.release();
  }
  
  public void reset()
  {
    this.player.reset();
  }
  
  public void seekTo(long paramLong)
  {
    this.player.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.player.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.player.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.player.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    this.player.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    this.player.setDataSource(paramString);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.player.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.player.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.player.setLogEnabled(paramBoolean);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.player.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(bgrq parambgrq)
  {
    if ((parambgrq instanceof OskReliableVideoPlayerImpl)) {
      this.player.setNextMediaPlayer(((OskReliableVideoPlayerImpl)parambgrq).player);
    }
  }
  
  public void setOnBufferingUpdateListener(bgrr parambgrr)
  {
    this.player.setOnBufferingUpdateListener(new OskReliableVideoPlayerImpl.4(this, parambgrr));
  }
  
  public void setOnCompletionListener(bgrs parambgrs)
  {
    this.player.setOnCompletionListener(new OskReliableVideoPlayerImpl.3(this, parambgrs));
  }
  
  public void setOnErrorListener(bgrt parambgrt)
  {
    this.player.setOnErrorListener(new OskReliableVideoPlayerImpl.7(this, parambgrt));
  }
  
  public void setOnInfoListener(bgru parambgru)
  {
    this.player.setOnInfoListener(new OskReliableVideoPlayerImpl.8(this, parambgru));
  }
  
  public void setOnLoopStartListener(bgrv parambgrv)
  {
    this.player.setOnLoopStartListener(new OskReliableVideoPlayerImpl.1(this, parambgrv));
  }
  
  public void setOnPreparedListener(bgrw parambgrw)
  {
    this.player.setOnPreparedListener(new OskReliableVideoPlayerImpl.2(this, parambgrw));
  }
  
  public void setOnSeekCompleteListener(bgrx parambgrx)
  {
    this.player.setOnSeekCompleteListener(new OskReliableVideoPlayerImpl.5(this, parambgrx));
  }
  
  public void setOnVideoSizeChangedListener(bgry parambgry)
  {
    this.player.setOnVideoSizeChangedListener(new OskReliableVideoPlayerImpl.6(this, parambgry));
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.player.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.player.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.player.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.player.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    this.player.start();
  }
  
  public void stop()
  {
    this.player.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */