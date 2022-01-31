package com.tencent.qqmini.sdk.core.proxy;

import android.media.MediaPlayer;
import com.tencent.qqmini.sdk.core.model.SongInfo;
import java.io.IOException;

public class MusicPlayerProxyDefault
  implements MusicPlayerProxy
{
  private MusicPlayerProxy.MusicPlayerListener mListener;
  private MediaPlayer player;
  
  public SongInfo getCurrentSong()
  {
    return null;
  }
  
  public int getCurrentSongPosition()
  {
    if (this.player != null) {
      return this.player.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.player != null) {
      return this.player.getDuration();
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener)
  {
    this.mListener = paramMusicPlayerListener;
    if (this.player != null)
    {
      this.player.release();
      this.player = null;
    }
    this.player = new MediaPlayer();
  }
  
  public boolean isInit()
  {
    return this.player != null;
  }
  
  public boolean isPlaying()
  {
    if (this.player != null) {
      return this.player.isPlaying();
    }
    return false;
  }
  
  public void pause()
  {
    if (this.player != null) {
      this.player.pause();
    }
  }
  
  public void resume()
  {
    if (this.player != null) {
      this.player.start();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.player != null) {
      this.player.seekTo(paramInt);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    if ((this.player != null) && (100 == paramInt)) {
      this.player.setLooping(false);
    }
  }
  
  public void startPlay(SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (this.player != null) {
      paramArrayOfSongInfo = paramArrayOfSongInfo[paramInt];
    }
    try
    {
      this.player.setDataSource(paramArrayOfSongInfo.b);
      this.player.prepareAsync();
      this.player.setOnPreparedListener(new MusicPlayerProxyDefault.1(this));
      return;
    }
    catch (IOException paramArrayOfSongInfo)
    {
      paramArrayOfSongInfo.printStackTrace();
    }
  }
  
  public void stop()
  {
    if (this.player != null) {
      this.player.stop();
    }
  }
  
  public void unInit()
  {
    if (this.player != null) {
      this.player.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxyDefault
 * JD-Core Version:    0.7.0.1
 */