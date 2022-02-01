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
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private VideoFeedsRecommendFragment$ScrollEventListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.a().a("list_video_feeds", false);
    } else {
      DropFrameMonitor.a().a("list_video_feeds");
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (paramInt == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.b = true;
      VideoFeedsRecommendFragment.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (paramInt == 2)) {
      this.b = false;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a();
    if (paramRecyclerView != null)
    {
      paramRecyclerView = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).getChildViewHolder(paramRecyclerView);
      RecyclerView.ViewHolder localViewHolder1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() - 1);
      RecyclerView.ViewHolder localViewHolder2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() + 1);
      if ((paramRecyclerView instanceof BaseItemHolder)) {
        ((BaseItemHolder)paramRecyclerView).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), true);
      }
      if ((localViewHolder1 instanceof BaseItemHolder)) {
        ((BaseItemHolder)localViewHolder1).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), false);
      }
      if ((localViewHolder2 instanceof BaseItemHolder)) {
        ((BaseItemHolder)localViewHolder2).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), false);
      }
    }
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.ScrollEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */