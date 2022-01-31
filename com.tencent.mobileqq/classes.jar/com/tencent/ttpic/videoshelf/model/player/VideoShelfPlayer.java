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
    if (this.mMediaPlayer != null) {
      return this.mMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public long getDuration()
  {
    if (this.mMediaPlayer != null) {
      return this.mMediaPlayer.getDuration();
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
    if (this.mMediaPlayer != null) {
      return this.mMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void pause()
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.pause();
    }
  }
  
  public void prepare()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.prepare();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "]mVideoPlayer.prepare, error msg = " + localIllegalStateException.toString());
      return;
    }
    catch (IOException localIOException)
    {
      label16:
      break label16;
    }
  }
  
  public void reset()
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.reset();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "]mVideoPlayer.seekTo, error msg = " + localIllegalStateException.toString());
    }
  }
  
  public void setDataSource(AssetManager paramAssetManager, String paramString)
  {
    if ((this.mMediaPlayer != null) && (paramAssetManager != null) && (paramString != null)) {}
    try
    {
      paramAssetManager = paramAssetManager.openFd(paramString);
      this.mMediaPlayer.setDataSource(paramAssetManager.getFileDescriptor(), paramAssetManager.getStartOffset(), paramAssetManager.getLength());
      return;
    }
    catch (IOException paramAssetManager)
    {
      paramAssetManager.printStackTrace();
      ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource(assets file) path = " + paramString + ", error msg = " + paramAssetManager.toString());
    }
  }
  
  public void setDataSource(String paramString)
  {
    if ((this.mMediaPlayer != null) && (paramString != null)) {}
    try
    {
      this.mMediaPlayer.setDataSource(paramString);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource path = " + paramString + ", error msg = " + localIOException.toString());
    }
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  public void setParam(String paramString, Object... paramVarArgs) {}
  
  public void setSurface(Surface paramSurface)
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.setSurface(paramSurface);
    }
  }
  
  public void setVideoShelfPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener)
  {
    this.mVideoShelfPlayerListener = paramIVideoShelfPlayerListener;
  }
  
  public void start()
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.start();
    }
  }
  
  public void stop()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer.setOnErrorListener(null);
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.setOnPreparedListener(null);
      this.mMediaPlayer.setOnVideoSizeChangedListener(null);
    }
  }
  
  public void surfaceUpdateSize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer
 * JD-Core Version:    0.7.0.1
 */