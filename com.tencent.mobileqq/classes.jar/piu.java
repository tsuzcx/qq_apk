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

public class piu
{
  private static volatile piu jdField_a_of_type_Piu;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  private oxx jdField_a_of_type_Oxx = new piv(this);
  
  public static piu a()
  {
    if (jdField_a_of_type_Piu == null) {}
    try
    {
      if (jdField_a_of_type_Piu == null) {
        jdField_a_of_type_Piu = new piu();
      }
      return jdField_a_of_type_Piu;
    }
    finally {}
  }
  
  private void a(pit parampit, long paramLong)
  {
    parampit = new FeedsPreloadManager.4(this, parampit, paramLong);
    ors.b().post(parampit);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
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
      ((oxd)localQQAppInterface.getManager(163)).a().a(0, (List)localObject, i, true, false, 1, null, -1L, null, 0, l1, l2, str, 1, false, null, 256);
      if ((localObject != null) && (((List)localObject).size() > 0)) {}
      for (localObject = (Serializable)((List)localObject).get(0);; localObject = "")
      {
        QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l1), ", strategyID = ", Long.valueOf(l2), ", articleID = ", localObject, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", str });
        return;
      }
    }
  }
  
  public pit a(pve parampve)
  {
    boolean bool2 = false;
    pis localpis = pis.a();
    if (localpis != null)
    {
      pit localpit = localpis.a(parampve);
      localpis.b();
      if (localpit != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        if (localpit.jdField_a_of_type_JavaUtilList != null) {}
        for (int i = localpit.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          boolean bool1 = bool2;
          if (parampve.b != null)
          {
            bool1 = bool2;
            if (parampve.b.size() > 0) {
              bool1 = true;
            }
          }
          piw.a(bool1, i);
          return localpit;
        }
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
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
  
  public void a(pit parampit)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", parampit });
    long l;
    int i;
    if (parampit != null)
    {
      Object localObject = parampit.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
      l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(parampit, l);
      piy.b();
      if (parampit.jdField_a_of_type_JavaUtilList == null) {
        break label135;
      }
      i = parampit.jdField_a_of_type_JavaUtilList.size();
      if (parampit.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) {
        break label140;
      }
    }
    label135:
    label140:
    for (parampit = (List)parampit.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("SubscriptionArticles");; parampit = null)
    {
      boolean bool1 = bool2;
      if (parampit != null)
      {
        bool1 = bool2;
        if (parampit.size() > 0) {
          bool1 = true;
        }
      }
      piw.a(bool1, i, l);
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
    if (jdField_a_of_type_Piu != null) {
      try
      {
        jdField_a_of_type_Piu.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
        jdField_a_of_type_Piu.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        oxs.b(this.jdField_a_of_type_Oxx);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     piu
 * JD-Core Version:    0.7.0.1
 */