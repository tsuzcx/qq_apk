package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1
  implements Runnable
{
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1(ColumnTwoVideoProteusItem.ColumnSubscriptionCallback paramColumnSubscriptionCallback) {}
  
  public void run()
  {
    ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.a(this.this$0).invalidateProteusTemplateBean();
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1
 * JD-Core Version:    0.7.0.1
 */