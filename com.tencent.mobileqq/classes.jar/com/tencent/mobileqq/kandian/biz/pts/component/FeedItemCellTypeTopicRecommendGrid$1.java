package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeTopicRecommendGrid$1
  implements ComponentContentGridImage.OnNoItemClickListener
{
  FeedItemCellTypeTopicRecommendGrid$1(FeedItemCellTypeTopicRecommendGrid paramFeedItemCellTypeTopicRecommendGrid) {}
  
  public void a()
  {
    OnSubRegionClickListener localOnSubRegionClickListener = this.a.g.y().c();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.a.b).k(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendGrid.1
 * JD-Core Version:    0.7.0.1
 */