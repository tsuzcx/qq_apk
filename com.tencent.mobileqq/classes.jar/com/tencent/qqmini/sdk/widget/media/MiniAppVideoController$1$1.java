package com.tencent.qqmini.sdk.widget.media;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppVideoController$1$1
  implements Runnable
{
  MiniAppVideoController$1$1(MiniAppVideoController.1 param1, View paramView) {}
  
  public void run()
  {
    if (this.val$view == null) {
      QMLog.e("MiniAppVideoController", "onVideoViewInit view is null?!");
    }
    do
    {
      return;
      MiniAppVideoController.access$200(this.this$1.this$0).setupPlayer(MiniAppVideoController.access$000(this.this$1.this$0), MiniAppVideoController.access$100(this.this$1.this$0));
      MiniAppVideoController.access$300(this.this$1.this$0).setUpVideoView(this.val$view, MiniAppVideoController.access$000(this.this$1.this$0));
      MiniAppVideoController.access$300(this.this$1.this$0).updateCenterBtn(MiniAppVideoController.access$000(this.this$1.this$0));
      MiniAppVideoController.access$400(this.this$1.this$0, MiniAppVideoController.access$000(this.this$1.this$0));
    } while ((MiniAppVideoController.access$500(this.this$1.this$0) <= 0L) || (!this.this$1.this$0.isWifiConnect()));
    QMLog.d("MiniAppVideoController", "play current pos is: " + MiniAppVideoController.access$500(this.this$1.this$0));
    this.this$1.this$0.play(MiniAppVideoController.access$500(this.this$1.this$0));
    IVideoPlayerUI localIVideoPlayerUI = MiniAppVideoController.access$300(this.this$1.this$0);
    if (!MiniAppVideoController.access$600(this.this$1.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localIVideoPlayerUI.resetControlIvDrawable(bool);
      MiniAppVideoController.access$702(this.this$1.this$0, MiniAppVideoController.access$600(this.this$1.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */