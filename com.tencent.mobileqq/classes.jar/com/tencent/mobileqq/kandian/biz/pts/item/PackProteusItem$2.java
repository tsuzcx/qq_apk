package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnHorizontalSubArticleClick;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PackProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  PackProteusItem$2(PackProteusItem paramPackProteusItem, List paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.invalidateProteusTemplateBean();
        paramTemplateBean = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()).a().a().a(paramTemplateBean, paramViewBase.getNativeView(), paramInt, paramInt);
        return;
      }
      catch (Exception paramViewBase)
      {
        paramTemplateBean = new StringBuilder();
        paramTemplateBean.append("[onItemClick], e = ");
        paramTemplateBean.append(paramViewBase);
        QLog.e("PackProteusItem", 1, paramTemplateBean.toString());
        return;
      }
    }
    paramViewBase = new StringBuilder();
    paramViewBase.append("[onItemClick] position overflow, position = ");
    paramViewBase.append(paramInt);
    paramViewBase.append(", size = ");
    paramViewBase.append(this.jdField_a_of_type_JavaUtilList.size());
    QLog.i("PackProteusItem", 1, paramViewBase.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PackProteusItem.2
 * JD-Core Version:    0.7.0.1
 */