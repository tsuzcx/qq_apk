package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;

class MultiVideoColumnProteusItem$3
  implements ViewBase.OnClickListener
{
  MultiVideoColumnProteusItem$3(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.multiVideoColumnInfo.q;
    if (paramViewBase != null)
    {
      VideoFeedsHelper.a(this.b.getContext(), paramViewBase);
      MultiVideoColumnProteusItem.a(this.c, this.a, 1, paramViewBase.f, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem.3
 * JD-Core Version:    0.7.0.1
 */