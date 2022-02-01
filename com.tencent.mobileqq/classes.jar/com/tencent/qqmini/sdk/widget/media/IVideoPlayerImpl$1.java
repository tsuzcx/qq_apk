package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.view.View;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;

class IVideoPlayerImpl$1
  implements AbsVideoPlayer.OnVideoViewInitListener
{
  IVideoPlayerImpl$1(IVideoPlayerImpl paramIVideoPlayerImpl, MiniAppVideoConfig paramMiniAppVideoConfig, AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener, AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener, AbsVideoPlayer.OnCompletionListener paramOnCompletionListener, AbsVideoPlayer.OnErrorListener paramOnErrorListener, AbsVideoPlayer.OnInfoListener paramOnInfoListener, AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener) {}
  
  public void onVideoViewInit(View paramView)
  {
    ThreadManager.getUIHandler().post(new IVideoPlayerImpl.1.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */