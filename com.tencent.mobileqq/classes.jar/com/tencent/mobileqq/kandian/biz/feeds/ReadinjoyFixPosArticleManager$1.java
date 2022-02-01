package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadinjoyFixPosArticleManager$1
  implements Runnable
{
  ReadinjoyFixPosArticleManager$1(ReadinjoyFixPosArticleManager paramReadinjoyFixPosArticleManager, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b().iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if ((!ReadinjoyFixPosArticleManager.isFixPosArticleSeq(localAbsBaseArticleInfo.mRecommendSeq)) && (!RIJDataFetchManager.a(localAbsBaseArticleInfo)) && ((localAbsBaseArticleInfo instanceof BaseArticleInfo))) {
        localArrayList.add(localAbsBaseArticleInfo);
      }
    }
    RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_Int, localArrayList, localArrayList, 3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager.1
 * JD-Core Version:    0.7.0.1
 */