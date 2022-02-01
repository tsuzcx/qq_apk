package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

final class RIJReportDataCollectionManager$2
  implements Runnable
{
  RIJReportDataCollectionManager$2(RIJDataManager paramRIJDataManager, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().b(this.a.a().B(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager.2
 * JD-Core Version:    0.7.0.1
 */