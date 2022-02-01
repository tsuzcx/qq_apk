package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.widget.ActionSheet.WatchDismissActions;

class VideoFeedsShareController$8
  implements ActionSheet.WatchDismissActions
{
  VideoFeedsShareController$8(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onDismissOperations()
  {
    if (VideoFeedsShareController.b(this.a)) {
      VideoFeedsShareController.a(this.a).c();
    }
    if (VideoFeedsShareController.a(this.a) != null) {
      VideoFeedsShareController.a(this.a).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.8
 * JD-Core Version:    0.7.0.1
 */