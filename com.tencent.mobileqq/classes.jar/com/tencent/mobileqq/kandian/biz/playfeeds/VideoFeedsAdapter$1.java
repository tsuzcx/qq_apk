package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;

class VideoFeedsAdapter$1
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  VideoFeedsAdapter$1(VideoFeedsAdapter paramVideoFeedsAdapter, VideoPlayParam paramVideoPlayParam) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam == this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */