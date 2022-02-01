package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.open.base.MD5Utils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class AbsVideoPlayerSuperImpl
  extends AbsVideoPlayer
{
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      try
      {
        paramInt1 = localISuperPlayer.captureImageInTime(-1L, paramInt1, paramInt2);
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
    if (QQVideoPlaySDKManager.a())
    {
      QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "createVideoView: superPlayer sdk is ready");
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      if (paramOnVideoViewInitListener != null)
      {
        paramContext = this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
        if ((paramContext instanceof View)) {
          paramOnVideoViewInitListener.onVideoViewInit((View)paramContext);
        }
      }
    }
    else
    {
      QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer sdk no ready when doing createVideoView");
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new AbsVideoPlayerSuperImpl.1(this, paramOnVideoViewInitListener));
    }
  }
  
  public long getCurrentPostion()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public int getVideoHeight()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 104, MD5Utils.toMD5(paramString));
      SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
      localSuperPlayerOption.enableCodecReuse = false;
      localSuperPlayerOption.isPrePlay = false;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(paramContext, paramString, paramLong);
    }
  }
  
  public void pause()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.pause();
    }
  }
  
  public void release()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnCaptureImageListener(new AbsVideoPlayerSuperImpl.7(this, paramOnCaptureImageListener));
    }
  }
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnCompletionListener(new AbsVideoPlayerSuperImpl.3(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener) {}
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnErrorListener(new AbsVideoPlayerSuperImpl.4(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnInfoListener(new AbsVideoPlayerSuperImpl.5(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnSeekCompleteListener(new AbsVideoPlayerSuperImpl.6(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOnVideoPreparedListener(new AbsVideoPlayerSuperImpl.2(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.setOutputMute(paramBoolean);
      return true;
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.start();
    }
  }
  
  public void startPlayDanmu()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  }
  
  public void stop()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
  }
  
  public void stopPlayDanmu()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl
 * JD-Core Version:    0.7.0.1
 */