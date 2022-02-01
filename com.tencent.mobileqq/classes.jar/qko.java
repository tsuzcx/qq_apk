import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class qko
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile qkp jdField_a_of_type_Qkp;
  
  public qko(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static qko a()
  {
    Object localObject = (QQAppInterface)pkh.a();
    if (localObject != null)
    {
      localObject = ((pvp)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a();
      if (localObject != null) {
        return ((pvj)localObject).a();
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
  
  qkp a(qxs paramqxs)
  {
    if (paramqxs != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Qkp != null) && (this.jdField_a_of_type_Qkp.a != null))
        {
          Object localObject = this.jdField_a_of_type_Qkp.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(qhj.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(qhj.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramqxs.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramqxs.jdField_b_of_type_Long) });
              if ((l1 == paramqxs.a) && (l2 == paramqxs.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramqxs = null;
              return paramqxs;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramqxs = paramqxs.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramqxs != null) && (paramqxs.size() > 0))
          {
            if (a(paramqxs, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramqxs = this.jdField_a_of_type_Qkp.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramqxs = this.jdField_a_of_type_Qkp.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramqxs = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qkp = null;
  }
  
  public void a(qkp paramqkp)
  {
    if (paramqkp != null) {}
    try
    {
      this.jdField_a_of_type_Qkp = paramqkp;
      return;
    }
    finally
    {
      paramqkp = finally;
      throw paramqkp;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Qkp = null;
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
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */