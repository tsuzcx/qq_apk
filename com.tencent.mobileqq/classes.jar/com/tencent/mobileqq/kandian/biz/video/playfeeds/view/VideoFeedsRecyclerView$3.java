package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.pull2refresh.PagerSnapHelper;

class VideoFeedsRecyclerView$3
  implements View.OnLayoutChangeListener
{
  VideoFeedsRecyclerView$3(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    if (VideoFeedsRecyclerView.h(this.a) != null) {
      VideoFeedsRecyclerView.e(this.a).b(VideoFeedsRecyclerView.h(this.a).itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView.3
 * JD-Core Version:    0.7.0.1
 */