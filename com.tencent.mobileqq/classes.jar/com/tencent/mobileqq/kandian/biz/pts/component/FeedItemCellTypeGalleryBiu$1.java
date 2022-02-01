package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class FeedItemCellTypeGalleryBiu$1
  implements View.OnClickListener
{
  FeedItemCellTypeGalleryBiu$1(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter == null) {
      return;
    }
    paramView = ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a();
    if (paramView == null) {
      return;
    }
    int i = ComponentContentGalleryBiu.a(paramView, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    OnGalleryImageClickListener localOnGalleryImageClickListener = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a().a();
    if (localOnGalleryImageClickListener != null) {
      localOnGalleryImageClickListener.a(this.a.jdField_a_of_type_AndroidContentContext, paramView, 0, paramView.innerUniqueID, i, this.a.jdField_a_of_type_Int, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryBiu.1
 * JD-Core Version:    0.7.0.1
 */