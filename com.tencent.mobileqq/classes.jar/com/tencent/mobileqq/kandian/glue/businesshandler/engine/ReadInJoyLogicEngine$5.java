package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Locale;

class ReadInJoyLogicEngine$5
  implements Runnable
{
  ReadInJoyLogicEngine$5(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public void run()
  {
    Pair localPair = ReadInJoyHelper.a(ReadInJoyLogicEngine.a(this.this$0));
    if (this.a == 40677) {
      localPair = ReadInJoyHelper.b(ReadInJoyLogicEngine.a(this.this$0));
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L - ((Long)localPair.first).longValue();
    long l3 = ReadInJoyLogicEngine.a() / 1000L;
    Object localObject2 = (Long)ReadInJoyLogicEngine.b().get(Integer.valueOf(this.a));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    if ((!(BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity)) && ((!ReadInJoyHelper.m()) || (!RIJAppSetting.b())) && (l1 - ((Long)localObject1).longValue() >= ((Long)localPair.first).longValue()))
    {
      l3 = l1 - l3;
      if (l3 >= ReadInJoyPageItemCache.a / 1000)
      {
        if (l3 < ((Long)localPair.first).longValue()) {
          return;
        }
        if (ReadInJoyLogicEngine.a(this.this$0) != null) {
          ReadInJoyLogicEngine.a(this.this$0).a().a(this.a, l2, ((Integer)localPair.second).intValue());
        }
        localObject2 = this.this$0.a().createEntityManager();
        localObject1 = String.format(Locale.CHINA, "delete from %s where mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { "ArticleInfo", "ArticleInfo", Integer.valueOf(this.a), localPair.second, Long.valueOf(l2), Integer.valueOf(this.a) });
        if (!((EntityManager)localObject2).execSQL((String)localObject1))
        {
          QLog.d("ArticleInfoModule", 2, "delete main outdated article fail !");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete outdated article successful ! Sql is : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", nowTime : ");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(", interval : ");
          ((StringBuilder)localObject2).append(localPair.first);
          ((StringBuilder)localObject2).append(", feedsCnt : ");
          ((StringBuilder)localObject2).append(localPair.second);
          QLog.d("ArticleInfoModule", 2, ((StringBuilder)localObject2).toString());
        }
        ReadInJoyLogicEngine.b().put(Integer.valueOf(this.a), Long.valueOf(l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine.5
 * JD-Core Version:    0.7.0.1
 */