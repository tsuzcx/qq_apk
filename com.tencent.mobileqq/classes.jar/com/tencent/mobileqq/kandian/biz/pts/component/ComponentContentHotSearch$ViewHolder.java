package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$ViewHolder
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  HotWordItem jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem;
  TextView b;
  
  protected ComponentContentHotSearch$ViewHolder(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    paramView = new ActivityURIRequest(this.b.getContext(), "/pubaccount/browser");
    paramView.extra().putString("url", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem.b);
    QRoute.startUri(paramView, null);
    paramView = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem.a, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).innerUniqueID, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).hotWordInfo.a.indexOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem) + 1);
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", paramView.toString(), false);
    }
    catch (Exception paramView)
    {
      localObject = ComponentContentHotSearch.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick, e = ");
      localStringBuilder.append(paramView);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch.getContext(), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch), (int)ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).mChannelID);
    paramView = new ArrayList();
    Object localObject = new ReportInfo();
    ((ReportInfo)localObject).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    ((ReportInfo)localObject).mOperation = 53;
    ((ReportInfo)localObject).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch).innerUniqueID;
    ((ReportInfo)localObject).mHotWord = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsHotWordItem.a;
    paramView.add(localObject);
    ReadInJoyLogicEngine.a().a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch.ViewHolder
 * JD-Core Version:    0.7.0.1
 */