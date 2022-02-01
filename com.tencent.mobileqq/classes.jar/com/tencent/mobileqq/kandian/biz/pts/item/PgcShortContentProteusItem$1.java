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
  
  protected int getClickArea()
  {
    if ((this.d.mSocialFeedInfo != null) && (this.d.mSocialFeedInfo.L != null)) {
      return 11;
    }
    return super.getClickArea();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.1
 * JD-Core Version:    0.7.0.1
 */