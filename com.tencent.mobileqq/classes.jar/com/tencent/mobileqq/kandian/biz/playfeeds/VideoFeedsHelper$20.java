package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;

final class VideoFeedsHelper$20
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  VideoFeedsHelper$20(TextView paramTextView, RichTitleInfo paramRichTitleInfo, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRichTitleInfo.d);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRichTitleInfo.a == 1)
      {
        VideoFeedsReporter.a.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
        return;
      }
      VideoFeedsReporter.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRichTitleInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.20
 * JD-Core Version:    0.7.0.1
 */