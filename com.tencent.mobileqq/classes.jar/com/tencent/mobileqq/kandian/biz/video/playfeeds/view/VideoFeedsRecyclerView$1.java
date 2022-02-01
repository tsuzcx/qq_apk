package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class VideoFeedsRecyclerView$1
  extends RecyclerView.OnScrollListener
{
  VideoFeedsRecyclerView$1(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.a;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    VideoFeedsRecyclerView.a(paramRecyclerView, bool);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */