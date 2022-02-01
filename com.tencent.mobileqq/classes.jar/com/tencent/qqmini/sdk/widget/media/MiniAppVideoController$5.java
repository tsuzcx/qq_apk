package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppVideoController$5
  implements AbsVideoPlayer.OnControllerClickListener
{
  MiniAppVideoController$5(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onAttationClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onBackClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    QMLog.d("MiniAppVideoController", "video player onBackClick");
    if (MiniAppVideoController.access$1200(this.this$0) == null) {}
    while (!MiniAppVideoController.access$000(this.this$0).isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onBackOnFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    QMLog.d("MiniAppVideoController", "video player onBackOnFullScreenClick");
    if (MiniAppVideoController.access$1200(this.this$0) == null) {}
    while (!MiniAppVideoController.access$000(this.this$0).isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onCacheClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onFeedbackClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    MiniAppVideoController.access$900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.5
 * JD-Core Version:    0.7.0.1
 */