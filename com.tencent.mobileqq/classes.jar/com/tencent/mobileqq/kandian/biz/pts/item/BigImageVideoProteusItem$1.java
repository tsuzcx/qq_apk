package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BigImageVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  BigImageVideoProteusItem$1(BigImageVideoProteusItem paramBigImageVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramViewBase != null) && (paramViewBase.columnEntrances != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.columnEntrances.isEmpty()) {
        return;
      }
      paramViewBase = new StringBuilder();
      paramViewBase.append("");
      paramViewBase.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.columnEntrances);
      QLog.i("BigImageVideoProteusItem", 1, paramViewBase.toString());
      paramViewBase = (VideoColumnInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.columnEntrances.get(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramViewBase);
      QLog.i("BigImageVideoProteusItem", 1, localStringBuilder.toString());
      if ((paramViewBase.a != null) && (paramViewBase.a.a != 3)) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().getContext(), paramViewBase.a);
      }
      paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      ProteusSupportUtil.a(paramViewBase, paramViewBase.mProteusTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
      RIJDtReportHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BigImageVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */