package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

class NewPolymericMultiVideoProteusItem$3
  implements ViewBase.OnClickListener
{
  NewPolymericMultiVideoProteusItem$3(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.a != null)
    {
      paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.a;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      NewPolymericMultiVideoProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemNewPolymericMultiVideoProteusItem, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramViewBase.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NewPolymericMultiVideoProteusItem.3
 * JD-Core Version:    0.7.0.1
 */