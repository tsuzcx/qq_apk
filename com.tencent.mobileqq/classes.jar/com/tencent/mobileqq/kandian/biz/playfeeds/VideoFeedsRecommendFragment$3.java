package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class VideoFeedsRecommendFragment$3
  implements View.OnLayoutChangeListener
{
  private int c;
  
  VideoFeedsRecommendFragment$3(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, Configuration paramConfiguration) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((VideoFeedsRecommendFragment.b(this.b).getHeight() != this.c) && (VideoFeedsRecommendFragment.c(this.b) != null) && (VideoFeedsRecommendFragment.d(this.b) != null))
    {
      VideoFeedsRecommendFragment.d(this.b).a(VideoFeedsRecommendFragment.c(this.b), VideoFeedsRecommendFragment.e(this.b));
      VideoFeedsRecommendFragment.c(this.b).e();
      VideoFeedsRecommendFragment.f(this.b).b();
      if ((VideoFeedsRecommendFragment.f(this.b).k()) && (VideoFeedsRecommendFragment.g(this.b) != null)) {
        VideoFeedsRecommendFragment.g(this.b).aA.e(true);
      }
      if (VideoFeedsRecommendFragment.h(this.b) != null) {
        VideoFeedsRecommendFragment.h(this.b).a(this.a);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onConfigurationChanged onLayoutChange: ");
        paramView.append(Arrays.toString(VideoFeedsHelper.c(this.b.getBaseActivity())));
        QLog.d("VideoFeedsRecommendFragment", 2, paramView.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onConfigurationChanged onLayoutChange: screen size unchanged ");
      paramView.append(Arrays.toString(VideoFeedsHelper.c(this.b.getBaseActivity())));
      QLog.d("VideoFeedsRecommendFragment", 2, paramView.toString());
    }
    this.c = VideoFeedsRecommendFragment.b(this.b).getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */