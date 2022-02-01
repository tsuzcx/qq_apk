import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class psp
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile psq jdField_a_of_type_Psq;
  
  public psp(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static psp a()
  {
    Object localObject = (QQAppInterface)ozs.a();
    if (localObject != null)
    {
      localObject = ((pfg)((QQAppInterface)localObject).getManager(163)).a();
      if (localObject != null) {
        return ((pfa)localObject).a();
      }
    }
    return null;
  }
  
  private boolean a(List<Long> paramList1, List<Long> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramList1 == null) || (paramList2 == null)) {
      if (paramList1 == paramList2) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label93;
      }
      bool1 = bool2;
      if (!((Long)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  psq a(qft paramqft)
  {
    if (paramqft != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Psq != null) && (this.jdField_a_of_type_Psq.a != null))
        {
          Object localObject = this.jdField_a_of_type_Psq.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(pqj.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(pqj.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramqft.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramqft.jdField_b_of_type_Long) });
              if ((l1 == paramqft.a) && (l2 == paramqft.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramqft = null;
              return paramqft;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramqft = paramqft.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramqft != null) && (paramqft.size() > 0))
          {
            if (a(paramqft, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramqft = this.jdField_a_of_type_Psq.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramqft = this.jdField_a_of_type_Psq.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramqft = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Psq = null;
  }
  
  public void a(psq parampsq)
  {
    if (parampsq != null) {}
    try
    {
      this.jdField_a_of_type_Psq = parampsq;
      return;
    }
    finally
    {
      parampsq = finally;
      throw parampsq;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Psq = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psp
 * JD-Core Version:    0.7.0.1
 */