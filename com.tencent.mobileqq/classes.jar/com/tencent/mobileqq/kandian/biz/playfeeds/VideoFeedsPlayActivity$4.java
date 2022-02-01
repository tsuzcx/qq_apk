package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class VideoFeedsPlayActivity$4
  implements OnColorNoteAnimFinishListener
{
  VideoFeedsPlayActivity$4(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    this.a.d();
    if ((VideoFeedsPlayActivity.f(this.a) != null) && (VideoFeedsPlayActivity.f(this.a).isColorNoteExist())) {
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.4
 * JD-Core Version:    0.7.0.1
 */