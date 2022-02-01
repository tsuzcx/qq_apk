package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$5
  implements View.OnClickListener
{
  PgcShortContentProteusItem$5(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.k();
    paramView.clickArea = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.a.k().mSocialFeedInfo.L.a == 3)
    {
      paramView.clickJumpTarget = PGCShortContentUtils.a(this.a.k().mSocialFeedInfo.L.c.l, "-1");
      RIJJumpUtils.a(this.b.getContext(), this.a.k().mSocialFeedInfo.L.c.l, null);
    }
    else
    {
      paramView.clickJumpTarget = PGCShortContentUtils.a(this.a.k().mSocialFeedInfo.L.b.d, "-1");
      RIJJumpUtils.a(this.b.getContext(), this.a.k().mSocialFeedInfo.L.b.d, null);
    }
    RIJFrameworkReportManager.a(this.c.getContext(), paramView, (int)paramView.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.5
 * JD-Core Version:    0.7.0.1
 */