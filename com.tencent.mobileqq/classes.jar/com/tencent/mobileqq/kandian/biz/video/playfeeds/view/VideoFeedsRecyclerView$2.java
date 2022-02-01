package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.pull2refresh.PagerSnapHelper;

class VideoFeedsRecyclerView$2
  implements View.OnLayoutChangeListener
{
  VideoFeedsRecyclerView$2(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    paramView = VideoFeedsRecyclerView.a(this.a);
    paramInt2 = 0;
    if ((paramView != null) && (VideoFeedsRecyclerView.b(this.a)))
    {
      if (VideoFeedsRecyclerView.c(this.a) == 0)
      {
        double d = this.a.getHeight();
        Double.isNaN(d);
        paramInt1 = (int)(d * 0.3D);
      }
      else
      {
        VideoFeedsRecyclerView.c(this.a);
        paramInt1 = 0;
      }
      paramView = VideoFeedsRecyclerView.a(this.a).getLayoutParams();
      paramView.height = paramInt1;
      VideoFeedsRecyclerView.a(this.a).setLayoutParams(paramView);
    }
    if (VideoFeedsRecyclerView.c(this.a) == 0)
    {
      paramView = this.a.getLayoutManager().findViewByPosition(1);
      if ((paramView != null) && (paramView.getHeight() > 0) && (VideoFeedsRecyclerView.d(this.a)))
      {
        paramInt1 = paramView.getHeight();
        paramInt1 = (int)(this.a.getHeight() / 2.0F - paramInt1 / 2.0F);
        VideoFeedsRecyclerView.a(this.a, paramInt1);
        paramInt1 = paramInt2;
        if (VideoFeedsRecyclerView.e(this.a).c(1))
        {
          paramInt1 = paramInt2;
          if (VideoFeedsRecyclerView.e(this.a).i() != 1) {
            paramInt1 = 1;
          }
        }
        if ((paramInt1 == 0) && (VideoFeedsRecyclerView.f(this.a) != null) && (VideoFeedsRecyclerView.e(this.a).i() != 1))
        {
          VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.a;
          localVideoFeedsRecyclerView.a(localVideoFeedsRecyclerView.getChildViewHolder(paramView));
        }
      }
    }
    else if (VideoFeedsRecyclerView.c(this.a) == 1)
    {
      paramView = this.a;
      VideoFeedsRecyclerView.a(paramView, VideoFeedsRecyclerView.g(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */