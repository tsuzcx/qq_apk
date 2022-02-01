package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.view.View;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;

class MiniAppVideoController$1
  implements AbsVideoPlayer.OnVideoViewInitListener
{
  MiniAppVideoController$1(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onVideoViewInit(View paramView)
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoController.1.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.1
 * JD-Core Version:    0.7.0.1
 */