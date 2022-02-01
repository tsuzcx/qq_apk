package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypePgcGrid$1
  implements ComponentContentGridImage.OnNoItemClickListener
{
  FeedItemCellTypePgcGrid$1(FeedItemCellTypePgcGrid paramFeedItemCellTypePgcGrid) {}
  
  public void a()
  {
    OnSubRegionClickListener localOnSubRegionClickListener = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a().a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcGrid.1
 * JD-Core Version:    0.7.0.1
 */