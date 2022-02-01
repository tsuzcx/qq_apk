package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.TopicInfo;

class RIJRefreshTopicInfoHandler$2
  implements Runnable
{
  RIJRefreshTopicInfoHandler$2(RIJRefreshTopicInfoHandler paramRIJRefreshTopicInfoHandler, int paramInt, Set paramSet, List paramList) {}
  
  public void run()
  {
    ConcurrentMap localConcurrentMap = this.this$0.a.i().d(this.a);
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localConcurrentMap.get(Long.valueOf(((Long)localIterator1.next()).longValue()));
      if ((localAbsBaseArticleInfo != null) && (RIJFeedsType.L(localAbsBaseArticleInfo)) && (localAbsBaseArticleInfo.mNewPolymericInfo.p != null))
      {
        Iterator localIterator2 = localAbsBaseArticleInfo.mNewPolymericInfo.p.iterator();
        while (localIterator2.hasNext())
        {
          NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localIterator2.next();
          if (localPackArticleInfo.p != null)
          {
            Iterator localIterator3 = this.c.iterator();
            while (localIterator3.hasNext())
            {
              oidb_cmd0xa6e.TopicInfo localTopicInfo = (oidb_cmd0xa6e.TopicInfo)localIterator3.next();
              if (localPackArticleInfo.p.d == localTopicInfo.uint64_topic_id.get()) {
                localPackArticleInfo.p.a = localTopicInfo.uint32_pv.get();
              }
            }
          }
        }
        localAbsBaseArticleInfo.invalidateProteusTemplateBean();
        this.this$0.a.updateEntity(localAbsBaseArticleInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJRefreshTopicInfoHandler.2
 * JD-Core Version:    0.7.0.1
 */