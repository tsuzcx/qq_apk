package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

class VideoFeedsShareController$4
  implements DialogInterface.OnCancelListener
{
  VideoFeedsShareController$4(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.a, "mShareActionSheet cancle button OnClick");
    if (VideoFeedsShareController.a(this.a) != null) {
      VideoFeedsShareController.a(this.a).c();
    }
    paramDialogInterface = VideoFeedsShareController.a(this.a);
    VideoFeedsShareController localVideoFeedsShareController = this.a;
    localVideoFeedsShareController.a(paramDialogInterface, String.valueOf(localVideoFeedsShareController.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.4
 * JD-Core Version:    0.7.0.1
 */