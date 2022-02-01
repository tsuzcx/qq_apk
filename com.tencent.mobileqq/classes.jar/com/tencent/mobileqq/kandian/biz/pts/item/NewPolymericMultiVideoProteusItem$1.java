package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.OnStateChangeListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

class NewPolymericMultiVideoProteusItem$1
  implements ProteusRecycleView.OnStateChangeListener
{
  NewPolymericMultiVideoProteusItem$1(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Container paramContainer) {}
  
  public void a()
  {
    if (this.a.mNewPolymericInfo.m != null)
    {
      UrlJumpInfo localUrlJumpInfo = this.a.mNewPolymericInfo.m;
      VideoFeedsHelper.a(this.b.getContext(), localUrlJumpInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NewPolymericMultiVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */