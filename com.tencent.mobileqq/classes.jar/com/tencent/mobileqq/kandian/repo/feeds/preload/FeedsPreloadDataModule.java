package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class FeedsPreloadDataModule
{
  private volatile FeedsPreloadDataModule.PreloadCache a;
  private ExecutorService b;
  
  public FeedsPreloadDataModule(ExecutorService paramExecutorService)
  {
    this.b = paramExecutorService;
  }
  
  static FeedsPreloadDataModule a()
  {
    Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
      if (localObject != null) {
        return ((ReadInJoyLogicEngine)localObject).h();
      }
    }
    return null;
  }
  
  private boolean a(List<Long> paramList1, List<Long> paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      if (paramList1.size() == paramList2.size())
      {
        int i = 0;
        while (i < paramList1.size())
        {
          if (!((Long)paramList1.get(i)).equals(paramList2.get(i))) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    return paramList1 == paramList2;
  }
  
  FeedsPreloadDataModule.PreloadCache a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if (paramRequest0x68bParams != null) {}
    for (;;)
    {
      try
      {
        if ((this.a != null) && (this.a.a != null))
        {
          Object localObject = this.a.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute("BeginSeq");
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute("EndSeq");
          long l2 = -1L;
          if (localLong1 == null) {
            break label330;
          }
          l1 = localLong1.longValue();
          if (localLong2 != null) {
            l2 = localLong2.longValue();
          }
          QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramRequest0x68bParams.c), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramRequest0x68bParams.d) });
          if ((l1 == paramRequest0x68bParams.c) && (l2 == paramRequest0x68bParams.d))
          {
            paramRequest0x68bParams = paramRequest0x68bParams.i;
            localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
            if ((paramRequest0x68bParams != null) && (paramRequest0x68bParams.size() > 0))
            {
              if (a(paramRequest0x68bParams, (List)localObject))
              {
                QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
                paramRequest0x68bParams = this.a.a();
                return paramRequest0x68bParams;
              }
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
            }
            else if ((localObject != null) && (((List)localObject).size() != 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
            }
            else
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramRequest0x68bParams = this.a.a();
              return paramRequest0x68bParams;
            }
          }
          else
          {
            QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
            return null;
          }
        }
      }
      finally {}
      return null;
      label330:
      long l1 = -1L;
    }
  }
  
  void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache)
  {
    if (paramPreloadCache != null) {}
    try
    {
      this.a = paramPreloadCache;
    }
    finally {}
  }
  
  public void b()
  {
    this.a = null;
  }
  
  void c()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataModule
 * JD-Core Version:    0.7.0.1
 */