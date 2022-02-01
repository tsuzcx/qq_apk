package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class DoubleVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$1(DoubleVideoProteusItem paramDoubleVideoProteusItem, int paramInt, IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    if (this.a == 1167) {
      i = 1;
    } else {
      i = 0;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)this.b.u();
    if (i != 0) {
      paramViewBase = this.c;
    } else {
      paramViewBase = this.d;
    }
    localReadInJoyBaseAdapter.c(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */