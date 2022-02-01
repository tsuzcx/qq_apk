package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import java.util.Map;

class ReadInJoyFeedsActivity$7
  extends ReadInJoyObserver
{
  ReadInJoyFeedsActivity$7(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void b_(int paramInt1, int paramInt2)
  {
    if (ReadInJoyFeedsActivity.a(this.a) == 1)
    {
      ((KandianMergeManager)this.a.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).c(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.a, paramInt1);
    ((KanDianViewController)this.a.p.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).m();
  }
  
  public void m_(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void n_(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.a, paramInt);
    if ((paramInt > 0) && (ReadInJoyFeedsActivity.a(this.a) == 0)) {
      ((KanDianViewController)this.a.p.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity.7
 * JD-Core Version:    0.7.0.1
 */