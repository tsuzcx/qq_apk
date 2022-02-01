package com.tencent.mobileqq.now.recommend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.utils.NowRoomUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class NowQQLiveRecommendAnchorHandler$1
  implements View.OnClickListener
{
  NowQQLiveRecommendAnchorHandler$1(FragmentActivity paramFragmentActivity, RecommendAnchorInfo paramRecommendAnchorInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    NowRoomUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorInfo.e, this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorInfo.b, 60011);
    NowQQLiveDataReport.b(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorInfo.f, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler.1
 * JD-Core Version:    0.7.0.1
 */