package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;

class ColumnTwoVideoProteusItem$4
  implements ViewBase.OnClickListener
{
  ColumnTwoVideoProteusItem$4(ColumnTwoVideoProteusItem paramColumnTwoVideoProteusItem, MultiVideoColumnInfo paramMultiVideoColumnInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    if (this.a.j) {
      i = 2;
    } else {
      i = 1;
    }
    ColumnTwoVideoProteusItem.a(this.c, this.b, i);
    ColumnTwoVideoProteusItem.a(this.c, this.b, true ^ this.a.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.4
 * JD-Core Version:    0.7.0.1
 */