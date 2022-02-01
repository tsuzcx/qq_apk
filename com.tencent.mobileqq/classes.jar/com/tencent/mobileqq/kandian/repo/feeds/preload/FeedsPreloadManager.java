package com.tencent.mobileqq.kandian.repo.feeds.preload;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class FeedsPreloadManager
{
  private static volatile FeedsPreloadManager a;
  private ExecutorService b = MonitorTimeExecutor.a();
  private IForeBackGroundCallback c = new FeedsPreloadManager.1(this);
  
  public static FeedsPreloadManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FeedsPreloadManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache, long paramLong)
  {
    paramPreloadCache = new FeedsPreloadManager.4(this, paramPreloadCache, paramLong);
    RIJThreadHandler.b().post(paramPreloadCache);
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    Object localObject1 = (KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localObject1 == null)
    {
      QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp, km is null.");
      return;
    }
    int i = -1;
    Object localObject2 = ((KandianMergeManager)localObject1).g();
    long l2 = 0L;
    long l1;
    if ((localObject2 != null) && (((List)localObject2).size() > 2))
    {
      l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
      l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
      localObject2 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
      localObject1 = ((KandianMergeManager)localObject1).h();
      i = 1;
    }
    else
    {
      localObject1 = null;
      l1 = 0L;
    }
    ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(0, (List)localObject2, i, true, false, 1, null, -1L, null, 0, l2, l1, (String)localObject1, 1, false, null, 256);
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      localObject2 = ((List)localObject2).get(0);
    } else {
      localObject2 = "";
    }
    QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l2), ", strategyID = ", Long.valueOf(l1), ", articleID = ", localObject2, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", localObject1 });
  }
  
  public FeedsPreloadDataModule.PreloadCache a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    FeedsPreloadDataModule localFeedsPreloadDataModule = FeedsPreloadDataModule.a();
    if (localFeedsPreloadDataModule != null)
    {
      FeedsPreloadDataModule.PreloadCache localPreloadCache = localFeedsPreloadDataModule.a(paramRequest0x68bParams);
      localFeedsPreloadDataModule.c();
      boolean bool = true;
      if (localPreloadCache != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        int i;
        if (localPreloadCache.d != null) {
          i = localPreloadCache.d.size();
        } else {
          i = 0;
        }
        if ((paramRequest0x68bParams.i == null) || (paramRequest0x68bParams.i.size() <= 0)) {
          bool = false;
        }
        FeedsPreloadDataReport.a(bool, i);
        return localPreloadCache;
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void a(FeedsPreloadDataModule.PreloadCache paramPreloadCache)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", paramPreloadCache });
    if (paramPreloadCache != null)
    {
      Object localObject = paramPreloadCache.a;
      long l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(paramPreloadCache, l);
      FeedsPreloadHelper.b();
      int i;
      if (paramPreloadCache.d != null) {
        i = paramPreloadCache.d.size();
      } else {
        i = 0;
      }
      if (paramPreloadCache.a != null) {
        paramPreloadCache = (List)paramPreloadCache.a.getAttribute("SubscriptionArticles");
      } else {
        paramPreloadCache = null;
      }
      boolean bool1 = bool2;
      if (paramPreloadCache != null)
      {
        bool1 = bool2;
        if (paramPreloadCache.size() > 0) {
          bool1 = true;
        }
      }
      FeedsPreloadDataReport.a(bool1, i, l);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((this.b.isShutdown()) || (this.b.isTerminated()))
    {
      QLog.d("FeedsPreloadManager", 1, "runOnSingleThreadPool, executorService is not available, init a new one.");
      this.b = MonitorTimeExecutor.a();
    }
    this.b.execute(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    a(new FeedsPreloadManager.3(this, paramBoolean));
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if ((localQQAppInterface != null) && (localQQAppInterface.isLogin()))
    {
      QLog.d("FeedsPreloadManager", 1, "start, feeds preload.");
      a(false);
      ThreadManager.getSubThreadHandler().postDelayed(new FeedsPreloadManager.2(this), 3000L);
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "app is null or not login, don't do feeds preload.");
  }
  
  public void c()
  {
    QLog.d("FeedsPreloadManager", 1, "reset, feeds preload.");
    if (a != null) {
      try
      {
        a.b.shutdownNow();
        a.b = MonitorTimeExecutor.a();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        ReadinjoySPEventReport.ForeBackGround.b(this.c);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager
 * JD-Core Version:    0.7.0.1
 */