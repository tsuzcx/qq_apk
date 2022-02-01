package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataModule.PreloadCache;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadExposeReport;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class RIJGetArticleListHandler$3
  implements Runnable
{
  RIJGetArticleListHandler$3(RIJGetArticleListHandler paramRIJGetArticleListHandler, long paramLong1, long paramLong2, FeedsPreloadDataModule.PreloadCache paramPreloadCache, long paramLong3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, loadingTime = ", Long.valueOf(this.a) });
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, schedule cost = ", Long.valueOf(l - this.b) });
    this.c.a.getAttributes().put("hitFeedsPreloadCache", Boolean.valueOf(true));
    this.c.a.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.d));
    RIJGetArticleListHandler.a(this.this$0, this.c.a, this.c.d, this.c.b, this.c.c, this.c.e, this.c.f, this.c.g, this.c.h);
    FeedsPreloadExposeReport.a(this.c.d, this.c.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler.3
 * JD-Core Version:    0.7.0.1
 */