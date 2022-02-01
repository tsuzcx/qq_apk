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
  private int jdField_a_of_type_Int;
  
  VideoFeedsRecommendFragment$3(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, Configuration paramConfiguration) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).getHeight() != this.jdField_a_of_type_Int) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null))
    {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment));
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).c();
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).c();
      if ((VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).b()) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null)) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a.d(true);
      }
      if (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment) != null) {
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).a(this.jdField_a_of_type_AndroidContentResConfiguration);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onConfigurationChanged onLayoutChange: ");
        paramView.append(Arrays.toString(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.getBaseActivity())));
        QLog.d("VideoFeedsRecommendFragment", 2, paramView.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onConfigurationChanged onLayoutChange: screen size unchanged ");
      paramView.append(Arrays.toString(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.getBaseActivity())));
      QLog.d("VideoFeedsRecommendFragment", 2, paramView.toString());
    }
    this.jdField_a_of_type_Int = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */