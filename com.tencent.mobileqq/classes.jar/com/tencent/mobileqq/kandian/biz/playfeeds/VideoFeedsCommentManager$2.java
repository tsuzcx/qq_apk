package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;

class VideoFeedsCommentManager$2
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  VideoFeedsCommentManager$2(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void a()
  {
    if (VideoFeedsCommentManager.d(this.a) != null) {
      VideoFeedsCommentManager.d(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    VideoFeedsCommentManager.b(this.a).p = paramInt;
    VideoFeedsCommentManager.c(this.a).a(VideoFeedsCommentManager.b(this.a));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.a(true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131430816) {
      return;
    }
    this.a.a(0);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCommentManager.2
 * JD-Core Version:    0.7.0.1
 */