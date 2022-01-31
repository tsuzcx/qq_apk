package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCompletionListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnControllerClickListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnVideoPreparedListener;
import java.io.IOException;

public class VideoPlayerProxyDefault
  extends VideoPlayerProxy
{
  private Context context;
  private boolean isMute;
  private MediaPlayer player;
  private boolean prepared;
  private int scale = 1;
  private TextureView textureView;
  private int videoHeight;
  private int videoWidth;
  
  private void setFitToFillAspectRatio(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Integer localInteger;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer = Integer.valueOf(this.textureView.getWidth());
      localInteger = Integer.valueOf(this.textureView.getHeight());
      localLayoutParams = this.textureView.getLayoutParams();
      if (paramInt1 <= paramInt2) {
        break label73;
      }
      localLayoutParams.width = paramMediaPlayer.intValue();
    }
    for (localLayoutParams.height = (paramMediaPlayer.intValue() * paramInt2 / paramInt1);; localLayoutParams.height = localInteger.intValue())
    {
      this.textureView.setLayoutParams(localLayoutParams);
      return;
      label73:
      localLayoutParams.width = (localInteger.intValue() * paramInt1 / paramInt2);
    }
  }
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public View createVideoView(Context paramContext)
  {
    if (this.player != null)
    {
      this.player.release();
      this.player = null;
    }
    this.player = new MediaPlayer();
    this.isMute = false;
    this.prepared = false;
    this.context = paramContext;
    this.textureView = new TextureView(paramContext);
    this.textureView.setSurfaceTextureListener(new VideoPlayerProxyDefault.2(this));
    return this.textureView;
  }
  
  public long getCurrentPostion()
  {
    if ((this.player != null) && (this.prepared)) {
      return this.player.getCurrentPosition();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    if (this.player != null) {
      return this.player.getDuration();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    return this.isMute;
  }
  
  public int getVideoHeight()
  {
    if (this.player != null) {
      return this.player.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.player != null) {
      return this.player.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    if (this.player != null) {
      return this.player.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    if (this.player != null) {}
    try
    {
      this.player.setDataSource(paramString);
      this.player.prepareAsync();
      this.player.seekTo((int)paramLong);
      this.player.setOnVideoSizeChangedListener(new VideoPlayerProxyDefault.1(this));
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void pause()
  {
    if ((this.player != null) && (this.prepared)) {
      this.player.pause();
    }
  }
  
  public void release()
  {
    if (this.player != null) {
      this.player.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.player != null) {
      this.player.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.player != null) {
      this.player.setLooping(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(VideoPlayerProxy.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void setOnCompletionListener(VideoPlayerProxy.OnCompletionListener paramOnCompletionListener)
  {
    if (this.player != null) {
      this.player.setOnCompletionListener(new VideoPlayerProxyDefault.4(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(VideoPlayerProxy.OnControllerClickListener paramOnControllerClickListener)
  {
    if (this.player != null) {}
  }
  
  public void setOnErrorListener(VideoPlayerProxy.OnErrorListener paramOnErrorListener)
  {
    if (this.player != null) {
      this.player.setOnErrorListener(new VideoPlayerProxyDefault.5(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(VideoPlayerProxy.OnInfoListener paramOnInfoListener)
  {
    if (this.player != null) {
      this.player.setOnInfoListener(new VideoPlayerProxyDefault.6(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(VideoPlayerProxy.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (this.player != null) {
      this.player.setOnSeekCompleteListener(new VideoPlayerProxyDefault.7(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(VideoPlayerProxy.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    if (this.player != null) {
      this.player.setOnPreparedListener(new VideoPlayerProxyDefault.3(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    if (this.player != null)
    {
      this.isMute = paramBoolean;
      if (paramBoolean) {
        this.player.setVolume(0.0F, 0.0F);
      }
      for (;;)
      {
        return true;
        this.player.setVolume(0.8F, 0.8F);
      }
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    this.scale = paramInt;
  }
  
  public void start()
  {
    if ((this.player != null) && (this.prepared)) {
      this.player.start();
    }
  }
  
  public void startPlayDanmu() {}
  
  public void stop()
  {
    if ((this.player != null) && (this.prepared)) {
      this.player.stop();
    }
  }
  
  public void stopPlayDanmu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault
 * JD-Core Version:    0.7.0.1
 */