package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.FileDescriptor;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.AudioEventListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class OskExoMediaPlayer
  implements AudioLevelSupport, IMediaPlayer
{
  public static final String LOG_TAG = "OskExoMediaPlayer";
  ExoMediaPlayer mPlayer = new ExoMediaPlayer(PlayerConfig.g().getAppContext());
  
  public double getAudioDuration()
  {
    return this.mPlayer.getAudioDuration();
  }
  
  public double getAudioEnergy()
  {
    return this.mPlayer.getAudioEnergy();
  }
  
  public double getAudioLevel()
  {
    return this.mPlayer.getAudioLevel();
  }
  
  public int getAudioSessionId()
  {
    return this.mPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    return this.mPlayer.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    return null;
  }
  
  public long getDuration()
  {
    return this.mPlayer.getDuration();
  }
  
  public MediaInfo getMediaInfo()
  {
    return null;
  }
  
  public int getScore()
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "getScore is not supported");
    return 0;
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "getTrackInfo is not supported");
    return new ITrackInfo[0];
  }
  
  public int getVideoHeight()
  {
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "getVideoSarDen is not supported");
    return 0;
  }
  
  public int getVideoSarNum()
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "getVideoSarNum is not supported");
    return 0;
  }
  
  public int getVideoWidth()
  {
    return this.mPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.mPlayer.isLooping();
  }
  
  public boolean isPlayable()
  {
    return true;
  }
  
  public boolean isPlaying()
  {
    return this.mPlayer.isPlaying();
  }
  
  public void pause()
  {
    this.mPlayer.pause();
  }
  
  public void prepareAsync()
  {
    this.mPlayer.prepareAsync();
  }
  
  public void release()
  {
    this.mPlayer.release();
  }
  
  public void reset()
  {
    this.mPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    this.mPlayer.seekTo(paramLong);
  }
  
  public void setAudioEventListener(IMediaPlayer.AudioEventListener paramAudioEventListener)
  {
    if (paramAudioEventListener != null)
    {
      this.mPlayer.setAudioEventListener(new OskExoMediaPlayer.9(this, paramAudioEventListener));
      return;
    }
    this.mPlayer.setAudioEventListener(null);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "setAudioStreamType is not supported");
  }
  
  public void setCalculateAudioLevel(boolean paramBoolean)
  {
    this.mPlayer.setCalculateAudioLevel(paramBoolean);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.mPlayer.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.mPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    throw new UnsupportedOperationException("setDataSource(FileDescriptor fd) is not supported");
  }
  
  public void setDataSource(String paramString)
  {
    this.mPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    throw new UnsupportedOperationException("setDataSource(IMediaDataSource mediaDataSource) is not supported");
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.mPlayer.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "setKeepInBackground is not supported");
  }
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    this.mPlayer.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    throw new UnsupportedOperationException("setNextMediaPlayer(IMediaPlayer nextMediaPlayer) is not supported");
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    if (paramOnBufferingUpdateListener != null)
    {
      this.mPlayer.setOnBufferingUpdateListener(new OskExoMediaPlayer.4(this, paramOnBufferingUpdateListener));
      return;
    }
    this.mPlayer.setOnBufferingUpdateListener(null);
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (paramOnCompletionListener != null)
    {
      this.mPlayer.setOnCompletionListener(new OskExoMediaPlayer.3(this, paramOnCompletionListener));
      return;
    }
    this.mPlayer.setOnCompletionListener(null);
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    if (paramOnErrorListener != null)
    {
      this.mPlayer.setOnErrorListener(new OskExoMediaPlayer.7(this, paramOnErrorListener));
      return;
    }
    this.mPlayer.setOnErrorListener(null);
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    if (paramOnInfoListener != null)
    {
      this.mPlayer.setOnInfoListener(new OskExoMediaPlayer.8(this, paramOnInfoListener));
      return;
    }
    this.mPlayer.setOnInfoListener(null);
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    if (paramOnLoopStartListener != null)
    {
      this.mPlayer.setOnLoopStartListener(new OskExoMediaPlayer.2(this, paramOnLoopStartListener));
      return;
    }
    this.mPlayer.setOnLoopStartListener(null);
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    if (paramOnPreparedListener != null)
    {
      this.mPlayer.setOnPreparedListener(new OskExoMediaPlayer.1(this, paramOnPreparedListener));
      return;
    }
    this.mPlayer.setOnPreparedListener(null);
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (paramOnSeekCompleteListener != null)
    {
      this.mPlayer.setOnSeekCompleteListener(new OskExoMediaPlayer.5(this, paramOnSeekCompleteListener));
      return;
    }
    this.mPlayer.setOnSeekCompleteListener(null);
  }
  
  public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener)
  {
    PlayerUtils.log(5, "OskExoMediaPlayer", "setOnTimedTextListener is not supported");
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    if (paramOnVideoSizeChangedListener != null)
    {
      this.mPlayer.setOnVideoSizeChangedListener(new OskExoMediaPlayer.6(this, paramOnVideoSizeChangedListener));
      return;
    }
    this.mPlayer.setOnVideoSizeChangedListener(null);
  }
  
  public void setRate(float paramFloat)
  {
    this.mPlayer.setRate(paramFloat);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    this.mPlayer.setSeekParameters(paramSeekParameters);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.mPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    this.mPlayer.start();
  }
  
  public void stop()
  {
    this.mPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer
 * JD-Core Version:    0.7.0.1
 */