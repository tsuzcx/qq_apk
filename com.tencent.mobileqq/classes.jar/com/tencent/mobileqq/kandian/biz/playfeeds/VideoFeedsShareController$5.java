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
    if ((VideoFeedsShareController.b(this.a) != null) && (VideoFeedsShareController.b(this.a).i()) && (VideoFeedsShareController.c(this.a)) && (!VideoFeedsShareController.h(this.a)) && (VideoFeedsShareController.a(this.a)) && (!VideoFeedsShareController.i(this.a))) {
      VideoFeedsShareController.b(this.a).h();
    }
    if (VideoFeedsShareController.d(this.a) != null) {
      VideoFeedsShareController.d(this.a).f();
    }
    VideoFeedsShareController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.5
 * JD-Core Version:    0.7.0.1
 */