import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.2;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class qkq
{
  private static volatile qkq jdField_a_of_type_Qkq;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  private pwk jdField_a_of_type_Pwk = new qkr(this);
  
  public static qkq a()
  {
    if (jdField_a_of_type_Qkq == null) {}
    try
    {
      if (jdField_a_of_type_Qkq == null) {
        jdField_a_of_type_Qkq = new qkq();
      }
      return jdField_a_of_type_Qkq;
    }
    finally {}
  }
  
  private void a(qkp paramqkp, long paramLong)
  {
    paramqkp = new FeedsPreloadManager.4(this, paramqkp, paramLong);
    pno.b().post(paramqkp);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
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
      ((pvp)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a(0, (List)localObject, i, true, false, 1, null, -1L, null, 0, l1, l2, str, 1, false, null, 256);
      if ((localObject != null) && (((List)localObject).size() > 0)) {}
      for (localObject = (Serializable)((List)localObject).get(0);; localObject = "")
      {
        QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l1), ", strategyID = ", Long.valueOf(l2), ", articleID = ", localObject, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", str });
        return;
      }
    }
  }
  
  public qkp a(qxs paramqxs)
  {
    boolean bool2 = false;
    qko localqko = qko.a();
    if (localqko != null)
    {
      qkp localqkp = localqko.a(paramqxs);
      localqko.b();
      if (localqkp != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        if (localqkp.jdField_a_of_type_JavaUtilList != null) {}
        for (int i = localqkp.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          boolean bool1 = bool2;
          if (paramqxs.b != null)
          {
            bool1 = bool2;
            if (paramqxs.b.size() > 0) {
              bool1 = true;
            }
          }
          qks.a(bool1, i);
          return localqkp;
        }
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
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
  
  public void a(qkp paramqkp)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", paramqkp });
    long l;
    int i;
    if (paramqkp != null)
    {
      Object localObject = paramqkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
      l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(paramqkp, l);
      qku.b();
      if (paramqkp.jdField_a_of_type_JavaUtilList == null) {
        break label135;
      }
      i = paramqkp.jdField_a_of_type_JavaUtilList.size();
      if (paramqkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramqkp = (List)paramqkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("SubscriptionArticles");; paramqkp = null)
    {
      boolean bool1 = bool2;
      if (paramqkp != null)
      {
        bool1 = bool2;
        if (paramqkp.size() > 0) {
          bool1 = true;
        }
      }
      qks.a(bool1, i, l);
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
    if (jdField_a_of_type_Qkq != null) {
      try
      {
        jdField_a_of_type_Qkq.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
        jdField_a_of_type_Qkq.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        pwf.b(this.jdField_a_of_type_Pwk);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkq
 * JD-Core Version:    0.7.0.1
 */