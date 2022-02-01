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
    if (VideoFeedsCommentManager.a(this.a) != null) {
      VideoFeedsCommentManager.a(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    VideoFeedsCommentManager.a(this.a).e = paramInt;
    VideoFeedsCommentManager.a(this.a).a(VideoFeedsCommentManager.a(this.a));
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
    if (paramView.getId() != 2131364710) {
      return;
    }
    this.a.a(0);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCommentManager.2
 * JD-Core Version:    0.7.0.1
 */