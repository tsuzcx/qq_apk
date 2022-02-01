package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;

class VideoFeedsAdapter$13
  implements Runnable
{
  VideoFeedsAdapter$13(VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.a.k(this.a);
    }
    if ((this.a) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d()) && (VideoFeedsAdapter.a(this.this$0) != null))
    {
      VideoFeedsAdapter.a(this.this$0).a();
      return;
    }
    if ((!this.a) && (VideoFeedsHelper.b())) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.13
 * JD-Core Version:    0.7.0.1
 */