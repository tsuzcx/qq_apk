package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
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
  private final String TAG = "VideoPlayerDefault";
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
    if ((this.mOnCaptureImageListenerList != null) && (this.mOnCaptureImageListenerList.size() > 0))
    {
      Iterator localIterator = this.mOnCaptureImageListenerList.iterator();
      while (localIterator.hasNext())
      {
        AbsVideoPlayer.OnCaptureImageListener localOnCaptureImageListener = (AbsVideoPlayer.OnCaptureImageListener)localIterator.next();
        if (localOnCaptureImageListener != null) {
          localOnCaptureImageListener.onCaptureImageFailed();
        }
      }
    }
  }
  
  private void callbackCaptureImageSucceed(Bitmap paramBitmap)
  {
    if ((this.mOnCaptureImageListenerList != null) && (this.mOnCaptureImageListenerList.size() > 0))
    {
      Iterator localIterator = this.mOnCaptureImageListenerList.iterator();
      while (localIterator.hasNext())
      {
        AbsVideoPlayer.OnCaptureImageListener localOnCaptureImageListener = (AbsVideoPlayer.OnCaptureImageListener)localIterator.next();
        if (localOnCaptureImageListener != null) {
          localOnCaptureImageListener.onCaptureImageSucceed(paramBitmap);
        }
      }
    }
  }
  
  private void setFitToFillAspectRatio(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Integer localInteger;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramMediaPlayer != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramMediaPlayer = Integer.valueOf(this.textureView.getWidth());
      localInteger = Integer.valueOf(this.textureView.getHeight());
      localLayoutParams = this.textureView.getLayoutParams();
      if (paramInt1 <= paramInt2) {
        break label81;
      }
      localLayoutParams.width = paramMediaPlayer.intValue();
    }
    for (localLayoutParams.height = (paramMediaPlayer.intValue() * paramInt2 / paramInt1);; localLayoutParams.height = localInteger.intValue())
    {
      this.textureView.setLayoutParams(localLayoutParams);
      return;
      label81:
      localLayoutParams.width = (localInteger.intValue() * paramInt1 / paramInt2);
    }
  }
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.player != null)
      {
        int i = this.player.getCurrentPosition();
        Object localObject = new MediaMetadataRetriever();
        if (URLUtil.isNetworkUrl(this.url)) {
          ((MediaMetadataRetriever)localObject).setDataSource(this.url, new HashMap());
        }
        for (;;)
        {
          Bitmap localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(i, 3);
          if ((localBitmap == null) || (localBitmap.isRecycled())) {
            break;
          }
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
          return 0;
          ((MediaMetadataRetriever)localObject).setDataSource(this.url);
        }
        callbackCaptureImageFailed();
      }
    }
    catch (Throwable localThrowable)
    {
      callbackCaptureImageFailed();
      return 0;
    }
    return 0;
  }
  
  public void createVideoView(Context paramContext, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
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
    this.textureView.setSurfaceTextureListener(new VideoPlayerDefault.2(this));
    if (paramOnVideoViewInitListener != null) {
      paramOnVideoViewInitListener.onVideoViewInit(this.textureView);
    }
  }
  
  public long getCurrentPostion()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.player != null)
    {
      l1 = l2;
      if (!this.prepared) {}
    }
    try
    {
      int i = this.player.getCurrentPosition();
      l1 = i;
      return l1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    long l = 0L;
    if (this.player != null) {}
    try
    {
      int i = this.player.getDuration();
      l = i;
      return l;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QMLog.i("VideoPlayerDefault", "getDuration", localIllegalStateException);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.player != null)
    {
      bool1 = bool2;
      if (!this.prepared) {}
    }
    try
    {
      bool1 = this.player.isPlaying();
      return bool1;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    if (this.player != null) {}
    try
    {
      this.url = paramString;
      this.player.setDataSource(paramString);
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
  
  public void pause()
  {
    if ((this.player != null) && (this.prepared)) {}
    try
    {
      this.player.pause();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QMLog.i("VideoPlayerDefault", "pause", localIllegalStateException);
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
    if (this.player != null) {
      this.player.setOnCompletionListener(new VideoPlayerDefault.4(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener)
  {
    if (this.player != null) {}
  }
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    if (this.player != null) {
      this.player.setOnErrorListener(new VideoPlayerDefault.5(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    if (this.player != null) {
      this.player.setOnInfoListener(new VideoPlayerDefault.6(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (this.player != null) {
      this.player.setOnSeekCompleteListener(new VideoPlayerDefault.7(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    if (this.player != null) {
      this.player.setOnPreparedListener(new VideoPlayerDefault.3(this, paramOnVideoPreparedListener));
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
    if ((this.player != null) && (this.prepared) && (!this.player.isPlaying())) {
      this.player.start();
    }
  }
  
  public void startPlayDanmu() {}
  
  public void stop()
  {
    try
    {
      if ((this.player != null) && (this.prepared)) {
        this.player.stop();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QMLog.i("VideoPlayerDefault", "stop", localIllegalStateException);
    }
  }
  
  public void stopPlayDanmu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault
 * JD-Core Version:    0.7.0.1
 */