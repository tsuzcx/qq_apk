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
      AbsVideoPlayerSuperImpl.a(this.b, SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext()));
      AbsVideoPlayerSuperImpl.a(this.b, SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, AbsVideoPlayerSuperImpl.a(this.b)));
      if ((this.a != null) && ((AbsVideoPlayerSuperImpl.a(this.b) instanceof View))) {
        this.a.onVideoViewInit((View)AbsVideoPlayerSuperImpl.a(this.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl.1
 * JD-Core Version:    0.7.0.1
 */