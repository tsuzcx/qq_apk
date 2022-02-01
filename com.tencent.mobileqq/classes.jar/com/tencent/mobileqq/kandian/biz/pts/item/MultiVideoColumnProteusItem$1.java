package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.OnStateChangeListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;

class MultiVideoColumnProteusItem$1
  implements ProteusRecycleView.OnStateChangeListener
{
  MultiVideoColumnProteusItem$1(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Container paramContainer) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.multiVideoColumnInfo.a != null)
    {
      UrlJumpInfo localUrlJumpInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.multiVideoColumnInfo.a;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localUrlJumpInfo);
      MultiVideoColumnProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemMultiVideoColumnProteusItem, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 1, localUrlJumpInfo.e, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem.1
 * JD-Core Version:    0.7.0.1
 */