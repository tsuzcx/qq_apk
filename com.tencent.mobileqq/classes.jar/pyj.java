import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class pyj
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile pyk jdField_a_of_type_Pyk;
  
  public pyj(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static pyj a()
  {
    Object localObject = (QQAppInterface)pay.a();
    if (localObject != null)
    {
      localObject = ((pks)((QQAppInterface)localObject).getManager(163)).a();
      if (localObject != null) {
        return ((pkm)localObject).a();
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
  
  pyk a(qln paramqln)
  {
    if (paramqln != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Pyk != null) && (this.jdField_a_of_type_Pyk.a != null))
        {
          Object localObject = this.jdField_a_of_type_Pyk.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(pwd.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(pwd.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramqln.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramqln.jdField_b_of_type_Long) });
              if ((l1 == paramqln.a) && (l2 == paramqln.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramqln = null;
              return paramqln;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramqln = paramqln.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramqln != null) && (paramqln.size() > 0))
          {
            if (a(paramqln, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramqln = this.jdField_a_of_type_Pyk.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramqln = this.jdField_a_of_type_Pyk.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramqln = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pyk = null;
  }
  
  public void a(pyk parampyk)
  {
    if (parampyk != null) {}
    try
    {
      this.jdField_a_of_type_Pyk = parampyk;
      return;
    }
    finally
    {
      parampyk = finally;
      throw parampyk;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Pyk = null;
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
 * Qualified Name:     pyj
 * JD-Core Version:    0.7.0.1
 */