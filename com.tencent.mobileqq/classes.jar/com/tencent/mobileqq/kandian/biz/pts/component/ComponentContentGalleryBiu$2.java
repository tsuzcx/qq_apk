package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentContentGalleryBiu$2
  implements View.OnClickListener
{
  ComponentContentGalleryBiu$2(ComponentContentGalleryBiu paramComponentContentGalleryBiu, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGalleryBiu) == null) {
      return;
    }
    int i = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGalleryBiu));
    paramView = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGalleryBiu).a().a();
    if (paramView != null) {
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGalleryBiu.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, i, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGalleryBiu), this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGalleryBiu.2
 * JD-Core Version:    0.7.0.1
 */