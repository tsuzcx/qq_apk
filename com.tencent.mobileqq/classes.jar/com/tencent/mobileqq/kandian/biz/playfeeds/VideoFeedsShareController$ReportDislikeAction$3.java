package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.widget.ActionSheet;

class VideoFeedsShareController$ReportDislikeAction$3
  implements DialogInterface.OnShowListener
{
  VideoFeedsShareController$ReportDislikeAction$3(VideoFeedsShareController.ReportDislikeAction paramReportDislikeAction) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    VideoFeedsShareController.k(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportDislikeAction.3
 * JD-Core Version:    0.7.0.1
 */