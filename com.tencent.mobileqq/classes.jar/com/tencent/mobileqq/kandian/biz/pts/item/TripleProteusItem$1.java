package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;

class TripleProteusItem$1
  implements ViewBase.OnClickListener
{
  TripleProteusItem$1(TripleProteusItem paramTripleProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    Object localObject2 = new ReportModelDC02528().module("all_result").action("clk_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(localAbsBaseArticleInfo.mArticleContentUrl);
    boolean bool = paramViewBase instanceof ReadInjoyTextView;
    String str1 = "";
    if (bool) {
      localObject1 = ((ReadInjoyTextView)paramViewBase).getText();
    } else {
      localObject1 = "";
    }
    Object localObject1 = ((ReportModelDC02528)localObject2).ver4((String)localObject1).ver5(localAbsBaseArticleInfo.mTitle).ver6(ByteStringMicro.copyFromUtf8(localAbsBaseArticleInfo.innerUniqueID).toStringUtf8());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{jumpurl:");
    ((StringBuilder)localObject2).append(paramViewBase.getEventAttachedData());
    ((StringBuilder)localObject2).append(",clk_index:");
    ((StringBuilder)localObject2).append(paramViewBase.getClickEvnet().substring(18));
    ((StringBuilder)localObject2).append("}");
    UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()).session_id(localAbsBaseArticleInfo.mSearchWordSessionId));
    SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase.getEventAttachedData());
    localObject2 = (UniteSearchHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str2 = localAbsBaseArticleInfo.mSearchWordSessionId;
    String str3 = localAbsBaseArticleInfo.mArticleContentUrl;
    localObject1 = str1;
    if (bool) {
      localObject1 = ((ReadInjoyTextView)paramViewBase).getText();
    }
    ((UniteSearchHandler)localObject2).a(localQQAppInterface, "clk_Kdfeedsback_list", str2, str3, (String)localObject1, localAbsBaseArticleInfo.mTitle, ByteStringMicro.copyFromUtf8(localAbsBaseArticleInfo.innerUniqueID).toStringUtf8());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.TripleProteusItem.1
 * JD-Core Version:    0.7.0.1
 */