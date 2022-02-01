package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeCommonPgcVideo$1
  implements View.OnClickListener
{
  FeedItemCellTypeCommonPgcVideo$1(FeedItemCellTypeCommonPgcVideo paramFeedItemCellTypeCommonPgcVideo) {}
  
  public void onClick(View paramView)
  {
    OnSubRegionClickListener localOnSubRegionClickListener = this.a.g.y().c();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(paramView, ((IReadInJoyModel)this.a.b).k(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeCommonPgcVideo.1
 * JD-Core Version:    0.7.0.1
 */