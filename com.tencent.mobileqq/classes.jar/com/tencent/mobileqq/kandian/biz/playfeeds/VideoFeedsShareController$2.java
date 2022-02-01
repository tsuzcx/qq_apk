package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.widget.ActionSheet;

class VideoFeedsShareController$2
  implements DialogInterface.OnShowListener
{
  VideoFeedsShareController$2(VideoFeedsShareController paramVideoFeedsShareController, ActionSheet paramActionSheet) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.b, "mShareActionSheet onShow()");
    this.a.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.2
 * JD-Core Version:    0.7.0.1
 */