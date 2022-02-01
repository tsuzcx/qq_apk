package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VideoPlayerDefault
  extends AbsVideoPlayer
{
  private static final String TAG = "VideoPlayerDefault";
  private Context context = null;
  private boolean isMute = false;
  private List<AbsVideoPlayer.OnCaptureImageListener> mOnCaptureImageListenerList;
  private MediaPlayer player = null;
  private boolean prepared = false;
  private int scale = 1;
  private TextureView textureView = null;
  private String url = null;
  private int videoHeight;
  private int videoWidth;
  
  private void callbackCaptureImageFailed()
  {
    Object localObject = this.mOnCaptureImageListenerList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mOnCaptureImageListenerList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsVideoPlayer.OnCaptureImageListener localOnCaptureImageListener = (AbsVideoPlayer.OnCaptureImageListener)((Iterator)localObject).next();
        if (localOnCaptureImageListener != null) {
          localOnCaptureImageListener.onCaptureImageFailed();
        }
      }
    }
  }
  
  private void callbackCaptureImageSucceed(Bitmap paramBitmap)
  {
    Object localObject = this.mOnCaptureImageListenerList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mOnCaptureImageListenerList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsVideoPlayer.OnCaptureImageListener localOnCaptureImageListener = (AbsVideoPlayer.OnCaptureImageListener)((Iterator)localObject).next();
        if (localOnCaptureImageListener != null) {
          localOnCaptureImageListener.onCaptureImageSucceed(paramBitmap);
        }
      }
    }
  }
  
  private void setFitToFillAspectRatio(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramMediaPlayer != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramMediaPlayer = Integer.valueOf(this.textureView.getWidth());
      Integer localInteger = Integer.valueOf(this.textureView.getHeight());
      ViewGroup.LayoutParams localLayoutParams = this.textureView.getLayoutParams();
      if (paramInt1 > paramInt2)
      {
        localLayoutParams.width = paramMediaPlayer.intValue();
        localLayoutParams.height = (paramMediaPlayer.intValue() * paramInt2 / paramInt1);
      }
      else
      {
        localLayoutParams.width = (localInteger.intValue() * paramInt1 / paramInt2);
        localLayoutParams.height = localInteger.intValue();
      }
      this.textureView.setLayoutParams(localLayoutParams);
    }
  }
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.player == null) {
        break label186;
      }
      int i = this.player.getCurrentPosition();
      Object localObject = new MediaMetadataRetriever();
      if (URLUtil.isNetworkUrl(this.url)) {
        ((MediaMetadataRetriever)localObject).setDataSource(this.url, new HashMap());
      } else {
        ((MediaMetadataRetriever)localObject).setDataSource(this.url);
      }
      Bitmap localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(i, 3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        localObject = localBitmap;
        if (i != 0)
        {
          localObject = localBitmap;
          if (j != 0)
          {
            float f1 = paramInt1 / i;
            float f2 = paramInt2 / j;
            localObject = new Matrix();
            ((Matrix)localObject).postScale(f1, f2);
            localObject = Bitmap.createBitmap(localBitmap, 0, 0, paramInt1, paramInt2, (Matrix)localObject, true);
          }
        }
        callbackCaptureImageSucceed((Bitmap)localObject);
      }
      else
      {
        callbackCaptureImageFailed();
      }
    }
    catch (Throwable localThrowable)
    {
      label182:
      label186:
      break label182;
    }
    callbackCaptureImageFailed();
    return 0;
  }
  
  public void createVideoView(Context paramContext, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.player = null;
    }
    this.player = new ReportMediaPlayer();
    this.isMute = false;
    this.prepared = false;
    this.context = paramContext;
    this.textureView = new TextureView(paramContext);
    this.textureView.setSurfaceTextureListener(new VideoPlayerDefault.2(this));
    if (paramOnVideoViewInitListener != null) {
      paramOnVideoViewInitListener.onVideoViewInit(this.textureView);
    }
  }
  
  public long getCurrentPostion()
  {
    MediaPlayer localMediaPlayer = this.player;
    if ((localMediaPlayer != null) && (this.prepared)) {
      try
      {
        int i = localMediaPlayer.getCurrentPosition();
        return i;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    return 0L;
  }
  
  public long getDuration()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      try
      {
        int i = localMediaPlayer.getDuration();
        return i;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QMLog.i("VideoPlayerDefault", "getDuration", localIllegalStateException);
      }
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    return this.isMute;
  }
  
  public int getVideoHeight()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    MediaPlayer localMediaPlayer = this.player;
    if ((localMediaPlayer != null) && (this.prepared)) {}
    try
    {
      boolean bool = localMediaPlayer.isPlaying();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    paramContext = this.player;
    if (paramContext != null) {
      try
      {
        this.url = paramString;
        paramContext.setDataSource(paramString);
        this.player.prepareAsync();
        this.player.seekTo((int)paramLong);
        this.player.setOnVideoSizeChangedListener(new VideoPlayerDefault.1(this));
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void pause()
  {
    MediaPlayer localMediaPlayer = this.player;
    if ((localMediaPlayer != null) && (this.prepared)) {
      try
      {
        localMediaPlayer.pause();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QMLog.i("VideoPlayerDefault", "pause", localIllegalStateException);
      }
    }
  }
  
  public void release()
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (paramOnCaptureImageListener != null)
    {
      if (this.mOnCaptureImageListenerList == null) {
        this.mOnCaptureImageListenerList = new ArrayList();
      }
      if (!this.mOnCaptureImageListenerList.contains(paramOnCaptureImageListener)) {
        this.mOnCaptureImageListenerList.add(paramOnCaptureImageListener);
      }
    }
  }
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnCompletionListener(new VideoPlayerDefault.4(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener)
  {
    paramOnControllerClickListener = this.player;
  }
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnErrorListener(new VideoPlayerDefault.5(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnInfoListener(new VideoPlayerDefault.6(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnSeekCompleteListener(new VideoPlayerDefault.7(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnPreparedListener(new VideoPlayerDefault.3(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    MediaPlayer localMediaPlayer = this.player;
    if (localMediaPlayer != null)
    {
      this.isMute = paramBoolean;
      if (paramBoolean) {
        localMediaPlayer.setVolume(0.0F, 0.0F);
      } else {
        localMediaPlayer.setVolume(0.8F, 0.8F);
      }
      return true;
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    this.scale = paramInt;
  }
  
  public void start()
  {
    MediaPlayer localMediaPlayer = this.player;
    if ((localMediaPlayer != null) && (this.prepared) && (!localMediaPlayer.isPlaying())) {
      this.player.start();
    }
  }
  
  public void startPlayDanmu() {}
  
  public void stop()
  {
    try
    {
      if ((this.player != null) && (this.prepared))
      {
        this.player.stop();
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QMLog.i("VideoPlayerDefault", "stop", localIllegalStateException);
    }
  }
  
  public void stopPlayDanmu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault
 * JD-Core Version:    0.7.0.1
 */