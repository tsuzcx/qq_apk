package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.widget.share.ShareActionSheet;

class VideoFeedsShareController$6
  implements DialogInterface.OnShowListener
{
  VideoFeedsShareController$6(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a().getWindow().getDecorView().setSystemUiVisibility(VideoFeedsShareController.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
    this.a.a.a().getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.6
 * JD-Core Version:    0.7.0.1
 */