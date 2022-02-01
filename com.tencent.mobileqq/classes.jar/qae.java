import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class qae
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile qaf jdField_a_of_type_Qaf;
  
  public qae(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static qae a()
  {
    Object localObject = (QQAppInterface)pha.a();
    if (localObject != null)
    {
      localObject = ((pmm)((QQAppInterface)localObject).getManager(163)).a();
      if (localObject != null) {
        return ((pmh)localObject).a();
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
  
  qaf a(qni paramqni)
  {
    if (paramqni != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Qaf != null) && (this.jdField_a_of_type_Qaf.a != null))
        {
          Object localObject = this.jdField_a_of_type_Qaf.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(pxz.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(pxz.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramqni.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramqni.jdField_b_of_type_Long) });
              if ((l1 == paramqni.a) && (l2 == paramqni.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramqni = null;
              return paramqni;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramqni = paramqni.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramqni != null) && (paramqni.size() > 0))
          {
            if (a(paramqni, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramqni = this.jdField_a_of_type_Qaf.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramqni = this.jdField_a_of_type_Qaf.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramqni = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qaf = null;
  }
  
  public void a(qaf paramqaf)
  {
    if (paramqaf != null) {}
    try
    {
      this.jdField_a_of_type_Qaf = paramqaf;
      return;
    }
    finally
    {
      paramqaf = finally;
      throw paramqaf;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Qaf = null;
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
 * Qualified Name:     qae
 * JD-Core Version:    0.7.0.1
 */