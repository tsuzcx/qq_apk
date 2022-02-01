package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class DoubleVideoProteusItem$2
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$2(DoubleVideoProteusItem paramDoubleVideoProteusItem, int paramInt, IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    if (this.a == 1165) {
      bool = true;
    } else {
      bool = false;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)this.b.u();
    if (bool) {
      paramViewBase = this.c;
    } else {
      paramViewBase = this.d;
    }
    localReadInJoyBaseAdapter.a(bool, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */