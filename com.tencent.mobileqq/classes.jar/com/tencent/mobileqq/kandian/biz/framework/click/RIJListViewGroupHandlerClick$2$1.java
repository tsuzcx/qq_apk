package com.tencent.mobileqq.kandian.biz.framework.click;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

class RIJListViewGroupHandlerClick$2$1
  implements Runnable
{
  RIJListViewGroupHandlerClick$2$1(RIJListViewGroupHandlerClick.2 param2, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    RIJListViewGroupHandlerClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder);
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder.a().getCount();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.b < i)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder.a().getItem(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.b);
      if ((localObject instanceof BaseArticleInfo))
      {
        localObject = (AbsBaseArticleInfo)localObject;
        BaseArticleInfoKt.a((AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJListViewGroupHandlerClick$Builder.a().getString(2131693523), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((AbsBaseArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick.2.1
 * JD-Core Version:    0.7.0.1
 */