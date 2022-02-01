package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import java.io.IOException;

public class VideoShelfPlayer
  implements IVideoShelfPlayer
{
  private final String TAG = "VideoShelfPlayer";
  private MediaPlayer mMediaPlayer = new MediaPlayer();
  private VideoShelfPlayer.MediaPlayerListener mMediaPlayerListener = new VideoShelfPlayer.MediaPlayerListener(this);
  MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new VideoShelfPlayer.1(this);
  int mVideoHeight = 0;
  private IVideoShelfPlayerListener mVideoShelfPlayerListener;
  int mVideoWidth = 0;
  
  public VideoShelfPlayer()
  {
    this.mMediaPlayer.setOnErrorListener(this.mMediaPlayerListener);
    this.mMediaPlayer.setOnCompletionListener(this.mMediaPlayerListener);
    this.mMediaPlayer.setOnPreparedListener(this.mMediaPlayerListener);
    this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
  }
  
  public void flush()
  {
    Log.i("VideoShelfPlayView", "VideoshelfPlayer-flush");
    seekTo(getCurrentPosition());
  }
  
  public int getCurrentPosition()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public long getDuration()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public boolean isPlaying()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      return localMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void pause()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.pause();
    }
  }
  
  public void prepare()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.prepare();
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IOException localIOException) {}
      localIOException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(VideoShelfPlayer.class.getSimpleName());
      localStringBuilder.append("]mVideoPlayer.prepare, error msg = ");
      localStringBuilder.append(localIOException.toString());
      ReportUtil.report(localStringBuilder.toString());
    }
  }
  
  public void reset()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.reset();
    }
  }
  
  public void seekTo(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.seekTo(paramInt);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(VideoShelfPlayer.class.getSimpleName());
        localStringBuilder.append("]mVideoPlayer.seekTo, error msg = ");
        localStringBuilder.append(localIllegalStateException.toString());
        ReportUtil.report(localStringBuilder.toString());
      }
    }
  }
  
  public void setDataSource(AssetManager paramAssetManager, String paramString)
  {
    if ((this.mMediaPlayer != null) && (paramAssetManager != null) && (paramString != null)) {
      try
      {
        paramAssetManager = paramAssetManager.openFd(paramString);
        this.mMediaPlayer.setDataSource(paramAssetManager.getFileDescriptor(), paramAssetManager.getStartOffset(), paramAssetManager.getLength());
        return;
      }
      catch (IOException paramAssetManager)
      {
        paramAssetManager.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(VideoShelfPlayer.class.getSimpleName());
        localStringBuilder.append("] mVideoPlayer.setDataSource(assets file) path = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", error msg = ");
        localStringBuilder.append(paramAssetManager.toString());
        ReportUtil.report(localStringBuilder.toString());
      }
    }
  }
  
  public void setDataSource(String paramString)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if ((localMediaPlayer != null) && (paramString != null)) {
      try
      {
        localMediaPlayer.setDataSource(paramString);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(VideoShelfPlayer.class.getSimpleName());
        localStringBuilder.append("] mVideoPlayer.setDataSource path = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", error msg = ");
        localStringBuilder.append(localIOException.toString());
        ReportUtil.report(localStringBuilder.toString());
      }
    }
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  public void setParam(String paramString, Object... paramVarArgs) {}
  
  public void setSurface(Surface paramSurface)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setSurface(paramSurface);
    }
  }
  
  public void setVideoShelfPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener)
  {
    this.mVideoShelfPlayerListener = paramIVideoShelfPlayerListener;
  }
  
  public void start()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.start();
    }
  }
  
  public void stop()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer.setOnErrorListener(null);
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.setOnPreparedListener(null);
      this.mMediaPlayer.setOnVideoSizeChangedListener(null);
    }
  }
  
  public void surfaceUpdateSize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer
 * JD-Core Version:    0.7.0.1
 */