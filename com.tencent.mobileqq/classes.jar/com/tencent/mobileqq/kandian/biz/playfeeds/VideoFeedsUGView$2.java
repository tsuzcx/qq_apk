package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;

class VideoFeedsUGView$2
  implements Runnable
{
  VideoFeedsUGView$2(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f.equals(this.a.d)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.this$0.b.setVisibility(8);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.2
 * JD-Core Version:    0.7.0.1
 */