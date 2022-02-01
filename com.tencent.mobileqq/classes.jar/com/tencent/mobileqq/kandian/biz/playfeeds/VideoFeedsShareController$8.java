package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.widget.ActionSheet.WatchDismissActions;

class VideoFeedsShareController$8
  implements ActionSheet.WatchDismissActions
{
  VideoFeedsShareController$8(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onDismissOperations()
  {
    if (VideoFeedsShareController.c(this.a)) {
      VideoFeedsShareController.b(this.a).h();
    }
    if (VideoFeedsShareController.d(this.a) != null) {
      VideoFeedsShareController.d(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.8
 * JD-Core Version:    0.7.0.1
 */