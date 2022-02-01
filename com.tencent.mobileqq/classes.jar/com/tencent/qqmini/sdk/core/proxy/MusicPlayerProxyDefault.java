package com.tencent.qqmini.sdk.core.proxy;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import java.io.IOException;

@ProxyService(proxy=MusicPlayerProxy.class)
public class MusicPlayerProxyDefault
  implements MusicPlayerProxy
{
  private MusicPlayerProxy.MusicPlayerListener mListener = null;
  private MediaPlayer player = null;
  
  public SongInfo getCurrentSong()
  {
    return null;
  }
  
  public int getCurrentSongPosition()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2)
  {
    this.mListener = paramMusicPlayerListener;
    paramMusicPlayerListener = this.player;
    if (paramMusicPlayerListener != null)
    {
      paramMusicPlayerListener.release();
      this.player = null;
    }
    this.player = new ReportMediaPlayer();
  }
  
  public boolean isInit()
  {
    return this.player != null;
  }
  
  public boolean isPlaying()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      return localMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void pause()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.pause();
    }
  }
  
  public void resume()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.start();
    }
  }
  
  public void seekTo(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.player;
    if ((localMediaPlayer != null) && (100 == paramInt)) {
      localMediaPlayer.setLooping(false);
    }
  }
  
  public void startPlay(SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null)
    {
      paramArrayOfSongInfo = paramArrayOfSongInfo[paramInt];
      try
      {
        localMediaPlayer.setDataSource(paramArrayOfSongInfo.url);
        this.player.prepareAsync();
        this.player.setOnPreparedListener(new MusicPlayerProxyDefault.1(this));
        return;
      }
      catch (IOException paramArrayOfSongInfo)
      {
        paramArrayOfSongInfo.printStackTrace();
      }
    }
  }
  
  public void stop()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.stop();
    }
  }
  
  public void unInit()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxyDefault
 * JD-Core Version:    0.7.0.1
 */