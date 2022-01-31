import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class orr
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile ors jdField_a_of_type_Ors;
  
  public orr(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static orr a()
  {
    Object localObject = (QQAppInterface)obz.a();
    if (localObject != null)
    {
      localObject = ((ohd)((QQAppInterface)localObject).getManager(163)).a();
      if (localObject != null) {
        return ((ogy)localObject).a();
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
  
  ors a(pdh parampdh)
  {
    if (parampdh != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Ors != null) && (this.jdField_a_of_type_Ors.a != null))
        {
          Object localObject = this.jdField_a_of_type_Ors.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(oqg.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(oqg.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(parampdh.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(parampdh.jdField_b_of_type_Long) });
              if ((l1 == parampdh.a) && (l2 == parampdh.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              parampdh = null;
              return parampdh;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          parampdh = parampdh.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((parampdh != null) && (parampdh.size() > 0))
          {
            if (a(parampdh, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              parampdh = this.jdField_a_of_type_Ors.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              parampdh = this.jdField_a_of_type_Ors.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      parampdh = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ors = null;
  }
  
  public void a(ors paramors)
  {
    if (paramors != null) {}
    try
    {
      this.jdField_a_of_type_Ors = paramors;
      return;
    }
    finally
    {
      paramors = finally;
      throw paramors;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Ors = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */