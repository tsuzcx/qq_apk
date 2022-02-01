package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnVideoSizeChangedListener;
import java.io.FileDescriptor;
import java.util.Map;

public class OskReliableVideoPlayerImpl
  implements ReliableVideoPlayer
{
  private OskExoMediaPlayer a;
  
  public OskReliableVideoPlayerImpl()
  {
    if (!PlayerConfig.hasInit())
    {
      Context localContext = AppLoaderFactory.g().getContext();
      if (localContext != null)
      {
        PlayerConfig.init(localContext);
        PlayerConfig.g().setLogger(new EmbeddedVideoLogger());
      }
      else
      {
        throw new RuntimeException("BaseApplicationImpl ctx is null");
      }
    }
    if (!VideoManager.hasInit()) {
      VideoManager.init(AppLoaderFactory.g().getContext());
    }
    ChannelProxyImpl.a(AppLoaderFactory.g().getContext());
    this.a = new OskExoMediaPlayer();
  }
  
  public int getAudioSessionId()
  {
    return this.a.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    return this.a.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    return this.a.getDataSource();
  }
  
  public long getDuration()
  {
    return this.a.getDuration();
  }
  
  public int getScore()
  {
    return this.a.getScore();
  }
  
  public int getVideoHeight()
  {
    return this.a.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.a.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.a.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    return this.a.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.a.isLooping();
  }
  
  public boolean isPlayable()
  {
    return this.a.isPlayable();
  }
  
  public boolean isPlaying()
  {
    return this.a.isPlaying();
  }
  
  public void pause()
  {
    this.a.pause();
  }
  
  public void prepareAsync()
  {
    this.a.prepareAsync();
  }
  
  public void release()
  {
    this.a.release();
  }
  
  public void reset()
  {
    this.a.reset();
  }
  
  public void seekTo(long paramLong)
  {
    this.a.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.a.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.a.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    this.a.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    this.a.setDataSource(paramString);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.a.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.a.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.a.setLogEnabled(paramBoolean);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(ReliableVideoPlayer paramReliableVideoPlayer)
  {
    if ((paramReliableVideoPlayer instanceof OskReliableVideoPlayerImpl)) {
      this.a.setNextMediaPlayer(((OskReliableVideoPlayerImpl)paramReliableVideoPlayer).a);
    }
  }
  
  public void setOnBufferingUpdateListener(ReliableVideoPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.a.setOnBufferingUpdateListener(new OskReliableVideoPlayerImpl.4(this, paramOnBufferingUpdateListener));
  }
  
  public void setOnCompletionListener(ReliableVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new OskReliableVideoPlayerImpl.3(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(ReliableVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new OskReliableVideoPlayerImpl.7(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(ReliableVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new OskReliableVideoPlayerImpl.8(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(ReliableVideoPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.a.setOnLoopStartListener(new OskReliableVideoPlayerImpl.1(this, paramOnLoopStartListener));
  }
  
  public void setOnPreparedListener(ReliableVideoPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.a.setOnPreparedListener(new OskReliableVideoPlayerImpl.2(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(ReliableVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.a.setOnSeekCompleteListener(new OskReliableVideoPlayerImpl.5(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(ReliableVideoPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.a.setOnVideoSizeChangedListener(new OskReliableVideoPlayerImpl.6(this, paramOnVideoSizeChangedListener));
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.a.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.a.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.a.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    this.a.start();
  }
  
  public void stop()
  {
    this.a.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */