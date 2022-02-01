package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MultiVideoColumnProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  MultiVideoColumnProteusItem$2(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Container paramContainer) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    paramViewBase = new StringBuilder();
    paramViewBase.append("position : ");
    paramViewBase.append(paramInt);
    QLog.d("multiVideoColumnInfo", 1, paramViewBase.toString());
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.multiVideoColumnInfo.a;
    if ((paramInt >= 0) && (paramInt < paramViewBase.size()) && (paramViewBase.get(paramInt) != null) && (((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null))
    {
      paramTemplateBean = ((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramTemplateBean);
      MultiVideoColumnProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemMultiVideoColumnProteusItem, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 2, paramTemplateBean.e, ((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem.2
 * JD-Core Version:    0.7.0.1
 */