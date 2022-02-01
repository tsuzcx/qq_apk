package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.OnGalleryItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.ArrayList;

class PgcProteusItem$5
  implements ComponentContentGridImage.OnGalleryItemClickListener
{
  PgcProteusItem$5(PgcProteusItem paramPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, int paramInt) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((PGCFeedsInfo)localObject).a;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return;
      }
      localObject = (PGCPicInfo)((PGCFeedsInfo)localObject).a.get(paramInt);
      PgcProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), (int)((PGCPicInfo)localObject).a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().innerUniqueID, this.jdField_a_of_type_Int, paramInt, (ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcProteusItem.5
 * JD-Core Version:    0.7.0.1
 */