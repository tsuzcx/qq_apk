package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class ComponentPolymericPullAnimatorView$1
  implements View.OnClickListener
{
  ComponentPolymericPullAnimatorView$1(ComponentPolymericPullAnimatorView paramComponentPolymericPullAnimatorView, AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericPullAnimatorView.a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.d);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
    paramView.append("");
    String str = paramView.toString();
    if (RIJFeedsType.F(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982B", "0X800982B", 0, 0, str, paramView, localStringBuilder.toString(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericPullAnimatorView.1
 * JD-Core Version:    0.7.0.1
 */