package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;

class VideoFeedsUGView$9
  implements Runnable
{
  VideoFeedsUGView$9(VideoFeedsUGView paramVideoFeedsUGView, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j)))
    {
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j.equals(this.a)) {
        return;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.this$0.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.9
 * JD-Core Version:    0.7.0.1
 */