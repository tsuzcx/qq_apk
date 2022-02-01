package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeUgcPlainSocial$2
  implements View.OnClickListener
{
  FeedItemCellTypeUgcPlainSocial$2(FeedItemCellTypeUgcPlainSocial paramFeedItemCellTypeUgcPlainSocial) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.a.e, ((IReadInJoyModel)this.a.b).k(), 2, false, 2, false);
    RIJFrameworkReportManager.b(((IReadInJoyModel)this.a.b).k(), ((IReadInJoyModel)this.a.b).m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcPlainSocial.2
 * JD-Core Version:    0.7.0.1
 */