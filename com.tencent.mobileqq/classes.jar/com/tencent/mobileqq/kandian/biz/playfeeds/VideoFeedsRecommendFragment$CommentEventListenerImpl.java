package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsRecommendFragment$CommentEventListenerImpl
  implements VideoFeedsCommentManager.CommentEventListener
{
  private VideoFeedsRecommendFragment$CommentEventListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a()
  {
    this.a.b(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).a.d(paramBoolean);
    }
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.a(this.a).setNeedDetectOrientation(this.a.getBaseActivity(), false);
    }
    else
    {
      VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.a;
      VideoFeedsRecommendFragment.a(localVideoFeedsRecommendFragment, VideoFeedsRecommendFragment.a(localVideoFeedsRecommendFragment));
    }
    if (!VideoFeedsRecommendFragment.a(this.a))
    {
      VideoFeedsRecommendFragment.a(this.a).setScrollable(paramBoolean ^ true);
      if ((!paramBoolean) && (VideoFeedsRecommendFragment.b(this.a)))
      {
        VideoFeedsRecommendFragment.a(this.a).a();
        VideoFeedsRecommendFragment.a(this.a, false);
      }
    }
    this.a.a(paramBoolean ^ true);
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CommentEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */