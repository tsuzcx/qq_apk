import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.2;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class psr
{
  private static volatile psr jdField_a_of_type_Psr;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  private pgb jdField_a_of_type_Pgb = new pss(this);
  
  public static psr a()
  {
    if (jdField_a_of_type_Psr == null) {}
    try
    {
      if (jdField_a_of_type_Psr == null) {
        jdField_a_of_type_Psr = new psr();
      }
      return jdField_a_of_type_Psr;
    }
    finally {}
  }
  
  private void a(psq parampsq, long paramLong)
  {
    parampsq = new FeedsPreloadManager.4(this, parampsq, paramLong);
    ozs.b().post(parampsq);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if (localKandianMergeManager == null)
    {
      QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp, km is null.");
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    String str = null;
    int i = -1;
    Object localObject = localKandianMergeManager.a();
    if ((localObject != null) && (((List)localObject).size() > 2))
    {
      l1 = ((Long)((List)localObject).get(((List)localObject).size() - 2)).longValue();
      l2 = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue();
      localObject = ((List)localObject).subList(0, ((List)localObject).size() - 2);
      i = 1;
      str = localKandianMergeManager.a();
    }
    for (;;)
    {
      ((pfg)localQQAppInterface.getManager(163)).a().a(0, (List)localObject, i, true, false, 1, null, -1L, null, 0, l1, l2, str, 1, false, null, 256);
      if ((localObject != null) && (((List)localObject).size() > 0)) {}
      for (localObject = (Serializable)((List)localObject).get(0);; localObject = "")
      {
        QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l1), ", strategyID = ", Long.valueOf(l2), ", articleID = ", localObject, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", str });
        return;
      }
    }
  }
  
  public psq a(qft paramqft)
  {
    boolean bool2 = false;
    psp localpsp = psp.a();
    if (localpsp != null)
    {
      psq localpsq = localpsp.a(paramqft);
      localpsp.b();
      if (localpsq != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        if (localpsq.jdField_a_of_type_JavaUtilList != null) {}
        for (int i = localpsq.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          boolean bool1 = bool2;
          if (paramqft.b != null)
          {
            bool1 = bool2;
            if (paramqft.b.size() > 0) {
              bool1 = true;
            }
          }
          pst.a(bool1, i);
          return localpsq;
        }
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
    if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
    {
      QLog.d("FeedsPreloadManager", 1, "app is null or not login, don't do feeds preload.");
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "start, feeds preload.");
    a(false);
    ThreadManager.getSubThreadHandler().postDelayed(new FeedsPreloadManager.2(this), 3000L);
  }
  
  public void a(Runnable paramRunnable)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("FeedsPreloadManager", 1, "runOnSingleThreadPool, executorService is not available, init a new one.");
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(paramRunnable);
  }
  
  public void a(psq parampsq)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", parampsq });
    long l;
    int i;
    if (parampsq != null)
    {
      Object localObject = parampsq.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
      l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(parampsq, l);
      psv.b();
      if (parampsq.jdField_a_of_type_JavaUtilList == null) {
        break label135;
      }
      i = parampsq.jdField_a_of_type_JavaUtilList.size();
      if (parampsq.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) {
        break label140;
      }
    }
    label135:
    label140:
    for (parampsq = (List)parampsq.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("SubscriptionArticles");; parampsq = null)
    {
      boolean bool1 = bool2;
      if (parampsq != null)
      {
        bool1 = bool2;
        if (parampsq.size() > 0) {
          bool1 = true;
        }
      }
      pst.a(bool1, i, l);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(new FeedsPreloadManager.3(this, paramBoolean));
  }
  
  public void b()
  {
    QLog.d("FeedsPreloadManager", 1, "reset, feeds preload.");
    if (jdField_a_of_type_Psr != null) {
      try
      {
        jdField_a_of_type_Psr.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
        jdField_a_of_type_Psr.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        pfw.b(this.jdField_a_of_type_Pgb);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psr
 * JD-Core Version:    0.7.0.1
 */