package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class VideoFeedsRecommendFragment$ScrollEventListenerImpl
  extends RecyclerView.OnScrollListener
  implements RecyclerView.OnItemTouchListener
{
  private boolean b = false;
  private boolean c = false;
  private int d = 0;
  
  private VideoFeedsRecommendFragment$ScrollEventListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.b = false;
      return false;
    }
    this.b = true;
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.b().a("list_video_feeds", false);
    } else {
      DropFrameMonitor.b().a("list_video_feeds");
    }
    int i;
    if ((this.b) && (this.d == 0) && (paramInt == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.c = true;
      VideoFeedsRecommendFragment.j(this.a);
    }
    if ((!this.b) && (this.d == 0) && (paramInt == 2)) {
      this.c = false;
    }
    this.d = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = VideoFeedsRecommendFragment.c(this.a).f();
    if (paramRecyclerView != null)
    {
      paramRecyclerView = VideoFeedsRecommendFragment.c(this.a).getChildViewHolder(paramRecyclerView);
      RecyclerView.ViewHolder localViewHolder1 = VideoFeedsRecommendFragment.c(this.a).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() - 1);
      RecyclerView.ViewHolder localViewHolder2 = VideoFeedsRecommendFragment.c(this.a).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() + 1);
      if ((paramRecyclerView instanceof BaseItemHolder)) {
        ((BaseItemHolder)paramRecyclerView).a(VideoFeedsRecommendFragment.d(this.a), VideoFeedsRecommendFragment.i(this.a), true);
      }
      if ((localViewHolder1 instanceof BaseItemHolder)) {
        ((BaseItemHolder)localViewHolder1).a(VideoFeedsRecommendFragment.d(this.a), VideoFeedsRecommendFragment.i(this.a), false);
      }
      if ((localViewHolder2 instanceof BaseItemHolder)) {
        ((BaseItemHolder)localViewHolder2).a(VideoFeedsRecommendFragment.d(this.a), VideoFeedsRecommendFragment.i(this.a), false);
      }
    }
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.ScrollEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */