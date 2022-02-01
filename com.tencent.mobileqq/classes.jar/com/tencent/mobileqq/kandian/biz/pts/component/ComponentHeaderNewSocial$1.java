package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ComponentHeaderNewSocial$1
  implements View.OnClickListener
{
  ComponentHeaderNewSocial$1(ComponentHeaderNewSocial paramComponentHeaderNewSocial, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      paramView.put("feeds_source", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.a));
      paramView.put("tab_source", RIJTransMergeKanDianReport.a());
      paramView.put("kandian_mode", RIJAppSetting.a());
      paramView.put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      paramView = paramView.toString();
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      paramView = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID, "0X8007B63", "0X8007B63", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), "", paramView, false);
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.f);
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.getContext(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial.1
 * JD-Core Version:    0.7.0.1
 */