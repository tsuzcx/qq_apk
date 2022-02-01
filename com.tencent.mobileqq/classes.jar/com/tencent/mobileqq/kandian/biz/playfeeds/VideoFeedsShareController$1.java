package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class VideoFeedsShareController$1
  implements DialogInterface.OnDismissListener
{
  VideoFeedsShareController$1(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    localStringBuilder.append(VideoFeedsShareController.a(this.a) ^ true);
    VideoFeedsShareController.a(paramDialogInterface, localStringBuilder.toString());
    if ((VideoFeedsShareController.a(this.a) != null) && (VideoFeedsShareController.a(this.a).b()) && (VideoFeedsShareController.b(this.a)) && (VideoFeedsShareController.a(this.a))) {
      VideoFeedsShareController.a(this.a).c();
    }
    if (VideoFeedsShareController.a(this.a) != null) {
      VideoFeedsShareController.a(this.a).g();
    }
    VideoFeedsShareController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.1
 * JD-Core Version:    0.7.0.1
 */