package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;

class PgcShortContentProteusItem$2
  extends ComponentPGCShortContentBig
{
  PgcShortContentProteusItem$2(PgcShortContentProteusItem paramPgcShortContentProteusItem, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramContext);
  }
  
  protected int getClickArea()
  {
    if ((this.h.mSocialFeedInfo != null) && (this.h.mSocialFeedInfo.L != null)) {
      return 11;
    }
    return super.getClickArea();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.2
 * JD-Core Version:    0.7.0.1
 */