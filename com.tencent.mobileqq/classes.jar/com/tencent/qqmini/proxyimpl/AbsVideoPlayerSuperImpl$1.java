package com.tencent.qqmini.proxyimpl;

import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.superplayer.api.SuperPlayerFactory;

class AbsVideoPlayerSuperImpl$1
  implements SDKInitListener
{
  AbsVideoPlayerSuperImpl$1(AbsVideoPlayerSuperImpl paramAbsVideoPlayerSuperImpl, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("superPlayer onSDKInited :");
    localStringBuilder.append(paramBoolean);
    QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      AbsVideoPlayerSuperImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAbsVideoPlayerSuperImpl, SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext()));
      AbsVideoPlayerSuperImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAbsVideoPlayerSuperImpl, SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, AbsVideoPlayerSuperImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAbsVideoPlayerSuperImpl)));
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener != null) && ((AbsVideoPlayerSuperImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAbsVideoPlayerSuperImpl) instanceof View))) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener.onVideoViewInit((View)AbsVideoPlayerSuperImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAbsVideoPlayerSuperImpl));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl.1
 * JD-Core Version:    0.7.0.1
 */