package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import bgnj;
import bgnk;
import bgnl;
import bgnm;
import bgnn;
import bgno;
import bgnp;
import bgnq;
import bgnr;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import java.io.FileDescriptor;
import java.util.Map;

public class OskReliableVideoPlayerImpl
  implements bgnj
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
  
  public void setNextMediaPlayer(bgnj parambgnj)
  {
    if ((parambgnj instanceof OskReliableVideoPlayerImpl)) {
      this.player.setNextMediaPlayer(((OskReliableVideoPlayerImpl)parambgnj).player);
    }
  }
  
  public void setOnBufferingUpdateListener(bgnk parambgnk)
  {
    this.player.setOnBufferingUpdateListener(new OskReliableVideoPlayerImpl.4(this, parambgnk));
  }
  
  public void setOnCompletionListener(bgnl parambgnl)
  {
    this.player.setOnCompletionListener(new OskReliableVideoPlayerImpl.3(this, parambgnl));
  }
  
  public void setOnErrorListener(bgnm parambgnm)
  {
    this.player.setOnErrorListener(new OskReliableVideoPlayerImpl.7(this, parambgnm));
  }
  
  public void setOnInfoListener(bgnn parambgnn)
  {
    this.player.setOnInfoListener(new OskReliableVideoPlayerImpl.8(this, parambgnn));
  }
  
  public void setOnLoopStartListener(bgno parambgno)
  {
    this.player.setOnLoopStartListener(new OskReliableVideoPlayerImpl.1(this, parambgno));
  }
  
  public void setOnPreparedListener(bgnp parambgnp)
  {
    this.player.setOnPreparedListener(new OskReliableVideoPlayerImpl.2(this, parambgnp));
  }
  
  public void setOnSeekCompleteListener(bgnq parambgnq)
  {
    this.player.setOnSeekCompleteListener(new OskReliableVideoPlayerImpl.5(this, parambgnq));
  }
  
  public void setOnVideoSizeChangedListener(bgnr parambgnr)
  {
    this.player.setOnVideoSizeChangedListener(new OskReliableVideoPlayerImpl.6(this, parambgnr));
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