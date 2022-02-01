package com.tencent.qqmini.sdk.widget.media;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class IVideoPlayerImpl$1$1
  implements Runnable
{
  IVideoPlayerImpl$1$1(IVideoPlayerImpl.1 param1, View paramView) {}
  
  public void run()
  {
    int i = 0;
    if (this.val$view == null)
    {
      QMLog.e("IVideoPlayerImpl", "initPlayer videoView is null, return.");
      return;
    }
    IVideoPlayerImpl.access$000(this.this$1.this$0).setXYaxis(0);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setLoopback(this.this$1.val$config.loop);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnControllerClickListener(this.this$1.val$controllerClickListener);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnVideoPreparedListener(this.this$1.val$onVideoPreparedListener);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnCompletionListener(this.this$1.val$onCompletionListener);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnErrorListener(this.this$1.val$onErrorListener);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnInfoListener(this.this$1.val$onInfoListener);
    IVideoPlayerImpl.access$000(this.this$1.this$0).setOnSeekCompleteListener(this.this$1.val$onSeekCompleteListener);
    AbsVideoPlayer localAbsVideoPlayer = IVideoPlayerImpl.access$000(this.this$1.this$0);
    if (this.this$1.val$config.objectFit.equals("contain")) {}
    for (;;)
    {
      localAbsVideoPlayer.setXYaxis(i);
      if (this.this$1.val$onVideoViewInitListener == null) {
        break;
      }
      this.this$1.val$onVideoViewInitListener.onVideoViewInit(this.val$view);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */