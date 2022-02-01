package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$4
  implements View.OnClickListener
{
  PgcShortContentProteusItem$4(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.k();
    ((AbsBaseArticleInfo)localObject).clickArea = 8;
    RIJFrameworkReportManager.a(this.b.getContext(), (AbsBaseArticleInfo)localObject, (int)((AbsBaseArticleInfo)localObject).mChannelID);
    QLog.d("PgcShortContentProteusItem", 1, "click single image blank area");
    localObject = this.c.y().c();
    if (localObject != null) {
      ((OnSubRegionClickListener)localObject).a(paramView, this.a.k(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.4
 * JD-Core Version:    0.7.0.1
 */