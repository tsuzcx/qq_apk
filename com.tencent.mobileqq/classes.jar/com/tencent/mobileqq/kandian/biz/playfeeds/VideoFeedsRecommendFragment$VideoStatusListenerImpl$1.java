package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;

class VideoFeedsRecommendFragment$VideoStatusListenerImpl$1
  implements View.OnLayoutChangeListener
{
  VideoFeedsRecommendFragment$VideoStatusListenerImpl$1(VideoFeedsRecommendFragment.VideoStatusListenerImpl paramVideoStatusListenerImpl) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    VideoFeedsRecommendFragment.c(this.a.a).removeOnLayoutChangeListener(this);
    VideoFeedsRecommendFragment.c(this.a.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.VideoStatusListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */