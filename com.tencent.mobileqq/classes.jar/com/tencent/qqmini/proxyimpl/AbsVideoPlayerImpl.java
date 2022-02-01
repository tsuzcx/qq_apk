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
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.List;

public class AbsVideoPlayerImpl
  extends AbsVideoPlayer
{
  private static final String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      try
      {
        paramInt1 = localTVK_IMediaPlayer.captureImageInTime(paramInt1, paramInt2);
        return paramInt1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    return 0;
  }
  
  public void createVideoView(Context paramContext, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      Object localObject1 = new OskPlayerConfig();
      ((OskPlayerConfig)localObject1).setEnableHLSCache(true);
      ((OskPlayerConfig)localObject1).setDebugVersion(true);
      ((OskPlayerConfig)localObject1).setLogger(new DefaultLogger());
      ((OskPlayerConfig)localObject1).setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), (OskPlayerConfig)localObject1);
      localObject1 = PlayerConfig.g().getContentTypeList();
      if (localObject1 != null) {
        try
        {
          ((List)localObject1).addAll(Arrays.asList(jdField_a_of_type_JavaLangString.split("|")));
          PlayerConfig.g().setContentTypeList((List)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:");
          ((StringBuilder)localObject2).append(localException);
          QLog.e("AbsVideoPlayerImpl", 2, ((StringBuilder)localObject2).toString());
        }
      } else {
        QLog.e("AbsVideoPlayerImpl", 2, "getContentTypeList null");
      }
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new AbsVideoPlayerImpl.1(this));
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    }
    if (!TVK_SDKMgr.isInstalled(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsVideoPlayerImpl", 2, "TVK_SDK is not installed");
      }
      return;
    }
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory == null) {
      return;
    }
    Object localObject2 = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)localObject2);
    if (paramOnVideoViewInitListener != null) {
      paramOnVideoViewInitListener.onVideoViewInit((View)localObject2);
    }
  }
  
  public long getCurrentPostion()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getOutputMute();
    }
    return false;
  }
  
  public int getVideoHeight()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      Object localObject;
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
      {
        localTVK_PlayerVideoInfo.setPlayType(4);
        localObject = paramString;
      }
      else if (paramString.toLowerCase().contains(".m3u8"))
      {
        localTVK_PlayerVideoInfo.setPlayType(1);
        localObject = paramString;
        if (paramString.startsWith("https")) {
          localObject = OskPlayerCore.getInstance().getUrl(paramString);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OskPlayerCore.getInstance().getUrl: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AbsVideoPlayerImpl", 1, ((StringBuilder)localObject).toString());
        localObject = OskPlayerCore.getInstance().getUrl(paramString);
        paramString = new StringBuilder();
        paramString.append("OskPlayerCore.getInstance().getUrl done: ");
        paramString.append((String)localObject);
        QLog.d("AbsVideoPlayerImpl", 1, paramString.toString());
        localTVK_PlayerVideoInfo.setPlayType(5);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, (String)localObject, paramLong, 0L, localTVK_PlayerVideoInfo);
    }
  }
  
  public void pause()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void release()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnCaptureImageListener(new AbsVideoPlayerImpl.8(this, paramOnCaptureImageListener));
    }
  }
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnCompletionListener(new AbsVideoPlayerImpl.4(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnControllerClickListener(new AbsVideoPlayerImpl.2(this, paramOnControllerClickListener));
    }
  }
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnErrorListener(new AbsVideoPlayerImpl.5(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnInfoListener(new AbsVideoPlayerImpl.6(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnSeekCompleteListener(new AbsVideoPlayerImpl.7(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnVideoPreparedListener(new AbsVideoPlayerImpl.3(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public void startPlayDanmu()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.startPlayDanmu();
    }
  }
  
  public void stop()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.stop();
    }
  }
  
  public void stopPlayDanmu()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.stopPlayDanmu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */