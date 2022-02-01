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

class NewPolymericMultiVideoProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  NewPolymericMultiVideoProteusItem$2(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    paramTemplateBean = new StringBuilder();
    paramTemplateBean.append("position : ");
    paramTemplateBean.append(paramInt);
    QLog.d("NewPolymericMultiVideoProteusItem", 1, paramTemplateBean.toString());
    NewPolymericMultiVideoProteusItem.a(this.c, this.a, paramInt);
    ((ReadInJoyBaseAdapter)this.b.u()).y().b().a(this.a, paramViewBase.getNativeView(), paramInt, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NewPolymericMultiVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */