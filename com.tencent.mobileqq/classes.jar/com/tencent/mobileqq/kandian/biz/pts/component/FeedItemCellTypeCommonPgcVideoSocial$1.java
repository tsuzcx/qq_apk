package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeCommonPgcVideoSocial$1
  implements View.OnClickListener
{
  FeedItemCellTypeCommonPgcVideoSocial$1(FeedItemCellTypeCommonPgcVideoSocial paramFeedItemCellTypeCommonPgcVideoSocial) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.g.y().c();
    if (paramView != null) {
      paramView.a(null, ((IReadInJoyModel)this.a.b).k(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeCommonPgcVideoSocial.1
 * JD-Core Version:    0.7.0.1
 */