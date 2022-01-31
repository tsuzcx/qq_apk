package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.view.View;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCompletionListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnControllerClickListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnVideoPreparedListener;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.List;

public class VideoPlayerProxyImpl
  extends VideoPlayerProxy
{
  private static final String TAG = "VideoPlayerProxyImpl";
  private static final String TVK_TAG = "MiniAppVideoPlayer_TVK_IMediaPlayer";
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private TVK_IMediaPlayer mVideoPlayer;
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    if (this.mVideoPlayer != null) {
      try
      {
        paramInt1 = this.mVideoPlayer.captureImageInTime(paramInt1, paramInt2);
        return paramInt1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    return 0;
  }
  
  public View createVideoView(Context paramContext)
  {
    Object localObject;
    if (this.mVideoPlayer == null)
    {
      localObject = new OskPlayerConfig();
      ((OskPlayerConfig)localObject).setEnableHLSCache(true);
      ((OskPlayerConfig)localObject).setDebugVersion(true);
      ((OskPlayerConfig)localObject).setLogger(new DefaultLogger());
      ((OskPlayerConfig)localObject).setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), (OskPlayerConfig)localObject);
      localObject = PlayerConfig.g().getContentTypeList();
      if (localObject == null) {
        break label166;
      }
    }
    label166:
    TVK_IProxyFactory localTVK_IProxyFactory;
    do
    {
      for (;;)
      {
        try
        {
          ((List)localObject).addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
          PlayerConfig.g().setContentTypeList((List)localObject);
          TVK_SDKMgr.setDebugEnable(true);
          TVK_SDKMgr.setOnLogListener(new VideoPlayerProxyImpl.1(this));
          TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
          if (TVK_SDKMgr.isInstalled(paramContext)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoPlayerProxyImpl", 2, "TVK_SDK is not installed");
          }
          return null;
        }
        catch (Exception localException)
        {
          QLog.e("VideoPlayerProxyImpl", 2, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + localException);
          continue;
        }
        QLog.e("VideoPlayerProxyImpl", 2, "getContentTypeList null");
      }
      localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    } while (localTVK_IProxyFactory == null);
    IVideoViewBase localIVideoViewBase = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
    this.mVideoPlayer = localTVK_IProxyFactory.createMediaPlayer(paramContext, localIVideoViewBase);
    return (View)localIVideoViewBase;
  }
  
  public long getCurrentPostion()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getDuration();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getOutputMute();
    }
    return false;
  }
  
  public int getVideoHeight()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if (this.mVideoPlayer != null)
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
        break label154;
      }
      if (!paramString.toLowerCase().contains(".m3u8")) {
        break label85;
      }
      localTVK_PlayerVideoInfo.setPlayType(1);
      if (!paramString.startsWith("https")) {
        break label160;
      }
      paramString = OskPlayerCore.getInstance().getUrl(paramString);
    }
    label154:
    label160:
    for (;;)
    {
      this.mVideoPlayer.openMediaPlayerByUrl(paramContext, paramString, paramLong, 0L, localTVK_PlayerVideoInfo);
      return;
      label85:
      QLog.d("VideoPlayerProxyImpl", 1, "OskPlayerCore.getInstance().getUrl: " + paramString);
      paramString = OskPlayerCore.getInstance().getUrl(paramString);
      QLog.d("VideoPlayerProxyImpl", 1, "OskPlayerCore.getInstance().getUrl done: " + paramString);
      localTVK_PlayerVideoInfo.setPlayType(5);
      continue;
      localTVK_PlayerVideoInfo.setPlayType(4);
    }
  }
  
  public void pause()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.pause();
    }
  }
  
  public void release()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(VideoPlayerProxy.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnCaptureImageListener(new VideoPlayerProxyImpl.8(this, paramOnCaptureImageListener));
    }
  }
  
  public void setOnCompletionListener(VideoPlayerProxy.OnCompletionListener paramOnCompletionListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnCompletionListener(new VideoPlayerProxyImpl.4(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(VideoPlayerProxy.OnControllerClickListener paramOnControllerClickListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnControllerClickListener(new VideoPlayerProxyImpl.2(this, paramOnControllerClickListener));
    }
  }
  
  public void setOnErrorListener(VideoPlayerProxy.OnErrorListener paramOnErrorListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnErrorListener(new VideoPlayerProxyImpl.5(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(VideoPlayerProxy.OnInfoListener paramOnInfoListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnInfoListener(new VideoPlayerProxyImpl.6(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(VideoPlayerProxy.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnSeekCompleteListener(new VideoPlayerProxyImpl.7(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(VideoPlayerProxy.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOnVideoPreparedListener(new VideoPlayerProxyImpl.3(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.setOutputMute(paramBoolean);
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.start();
    }
  }
  
  public void startPlayDanmu()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.startPlayDanmu();
    }
  }
  
  public void stop()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.stop();
    }
  }
  
  public void stopPlayDanmu()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.stopPlayDanmu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl
 * JD-Core Version:    0.7.0.1
 */