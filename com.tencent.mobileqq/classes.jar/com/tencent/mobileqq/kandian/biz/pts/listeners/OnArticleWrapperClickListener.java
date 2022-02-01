package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class OnArticleWrapperClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private ReadInJoyBaseAdapter b;
  
  public OnArticleWrapperClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramReadInJoyBaseAdapter;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.b.y().c();
    if (paramViewBase != null) {
      paramViewBase.a(null, this.a, 2);
    }
    paramViewBase = this.a;
    if (paramViewBase != null) {
      paramViewBase.invalidateProteusTemplateBean();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnArticleWrapperClickListener
 * JD-Core Version:    0.7.0.1
 */