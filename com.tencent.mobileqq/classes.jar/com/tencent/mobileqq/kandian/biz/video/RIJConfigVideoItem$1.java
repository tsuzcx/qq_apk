package com.tencent.mobileqq.kandian.biz.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJConfigVideoItem$1
  implements View.OnClickListener
{
  RIJConfigVideoItem$1(String paramString, VideoFeedsViewHolder paramVideoFeedsViewHolder) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    VideoHandler.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderVideoFeedsViewHolder.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem.1
 * JD-Core Version:    0.7.0.1
 */