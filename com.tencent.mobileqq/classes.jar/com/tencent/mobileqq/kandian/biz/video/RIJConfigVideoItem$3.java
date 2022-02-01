package com.tencent.mobileqq.kandian.biz.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJConfigVideoItem$3
  implements View.OnClickListener
{
  RIJConfigVideoItem$3(String paramString, BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    VideoHandler.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderBigImgVideoItemViewHolder.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem.3
 * JD-Core Version:    0.7.0.1
 */