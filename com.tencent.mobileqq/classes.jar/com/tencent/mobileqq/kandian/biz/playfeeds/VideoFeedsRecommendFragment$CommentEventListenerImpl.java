package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.view.widget.LifeCycleCallBack;
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
    if (VideoFeedsRecommendFragment.g(this.a) != null) {
      VideoFeedsRecommendFragment.g(this.a).aA.e(paramBoolean);
    }
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.c(this.a).setNeedDetectOrientation(this.a.getBaseActivity(), false);
    }
    else
    {
      VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.a;
      VideoFeedsRecommendFragment.a(localVideoFeedsRecommendFragment, VideoFeedsRecommendFragment.g(localVideoFeedsRecommendFragment));
    }
    if (!VideoFeedsRecommendFragment.k(this.a))
    {
      VideoFeedsRecommendFragment.c(this.a).setScrollable(paramBoolean ^ true);
      if ((!paramBoolean) && (VideoFeedsRecommendFragment.l(this.a)))
      {
        VideoFeedsRecommendFragment.c(this.a).b();
        VideoFeedsRecommendFragment.a(this.a, false);
      }
    }
    this.a.a(paramBoolean ^ true);
    if (VideoFeedsRecommendFragment.m(this.a) != null) {
      VideoFeedsRecommendFragment.m(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CommentEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */