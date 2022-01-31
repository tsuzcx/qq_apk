import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class pcq
{
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile pcr jdField_a_of_type_Pcr;
  
  public pcq(ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
  
  public static pcq a()
  {
    Object localObject = (QQAppInterface)onh.a();
    if (localObject != null)
    {
      localObject = ((osl)((QQAppInterface)localObject).getManager(163)).a();
      if (localObject != null) {
        return ((osg)localObject).a();
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
  
  pcr a(pow parampow)
  {
    if (parampow != null) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Pcr != null) && (this.jdField_a_of_type_Pcr.a != null))
        {
          Object localObject = this.jdField_a_of_type_Pcr.a;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(pbe.d);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(pbe.e);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(parampow.a), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(parampow.jdField_b_of_type_Long) });
              if ((l1 == parampow.a) && (l2 == parampow.jdField_b_of_type_Long)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              parampow = null;
              return parampow;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          parampow = parampow.jdField_b_of_type_JavaUtilList;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((parampow != null) && (parampow.size() > 0))
          {
            if (a(parampow, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              parampow = this.jdField_a_of_type_Pcr.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              parampow = this.jdField_a_of_type_Pcr.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      parampow = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pcr = null;
  }
  
  public void a(pcr parampcr)
  {
    if (parampcr != null) {}
    try
    {
      this.jdField_a_of_type_Pcr = parampcr;
      return;
    }
    finally
    {
      parampcr = finally;
      throw parampcr;
    }
  }
  
  void b()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.jdField_a_of_type_Pcr = null;
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
 * Qualified Name:     pcq
 * JD-Core Version:    0.7.0.1
 */