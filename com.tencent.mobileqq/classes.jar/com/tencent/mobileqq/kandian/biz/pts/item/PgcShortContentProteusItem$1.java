package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentPgcShortContentGridImage;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;

class PgcShortContentProteusItem$1
  extends ComponentContentPgcShortContentGridImage
{
  PgcShortContentProteusItem$1(PgcShortContentProteusItem paramPgcShortContentProteusItem, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramContext);
  }
  
  protected int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a != null)) {
      return 11;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.1
 * JD-Core Version:    0.7.0.1
 */