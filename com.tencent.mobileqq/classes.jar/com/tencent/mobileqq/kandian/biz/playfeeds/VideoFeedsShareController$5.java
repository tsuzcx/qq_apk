package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class VideoFeedsShareController$5
  implements DialogInterface.OnDismissListener
{
  VideoFeedsShareController$5(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((VideoFeedsShareController.a(this.a) != null) && (VideoFeedsShareController.a(this.a).b()) && (VideoFeedsShareController.b(this.a)) && (!VideoFeedsShareController.c(this.a)) && (VideoFeedsShareController.a(this.a)) && (!VideoFeedsShareController.d(this.a))) {
      VideoFeedsShareController.a(this.a).c();
    }
    if (VideoFeedsShareController.a(this.a) != null) {
      VideoFeedsShareController.a(this.a).g();
    }
    VideoFeedsShareController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.5
 * JD-Core Version:    0.7.0.1
 */