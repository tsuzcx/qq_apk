package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;

class ColumnTwoVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  ColumnTwoVideoProteusItem$1(ColumnTwoVideoProteusItem paramColumnTwoVideoProteusItem, Context paramContext, MultiVideoColumnInfo paramMultiVideoColumnInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    VideoFeedsHelper.a(this.a, this.b.q);
    ColumnTwoVideoProteusItem.a(this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */