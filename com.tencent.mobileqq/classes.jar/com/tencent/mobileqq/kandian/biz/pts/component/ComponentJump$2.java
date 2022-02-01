package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ComponentJump$2
  implements View.OnClickListener
{
  ComponentJump$2(ComponentJump paramComponentJump, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelInfoId, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelInfoName, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelInfoType, 1);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.hasChannelInfo()) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("feeds_channel_entrance", i);
      paramView = paramView.toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", paramView, false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentJump.2
 * JD-Core Version:    0.7.0.1
 */