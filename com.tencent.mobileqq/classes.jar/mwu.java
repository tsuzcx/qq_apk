import android.os.Looper;
import com.tencent.avgame.business.observer.ObserverCenter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mwu
{
  private static int jdField_a_of_type_Int;
  private static mwu jdField_a_of_type_Mwu;
  private static int jdField_b_of_type_Int = -1;
  private final List<anil> jdField_a_of_type_JavaUtilList = new ArrayList(4);
  private final mww jdField_a_of_type_Mww = new mww(Looper.getMainLooper());
  private final List<anil> jdField_b_of_type_JavaUtilList = new ArrayList(4);
  private final mww jdField_b_of_type_Mww = new mww(ThreadManager.getSubThreadHandler());
  
  public static mwu a()
  {
    if (jdField_a_of_type_Mwu == null) {}
    try
    {
      jdField_a_of_type_Mwu = new mwu();
      return jdField_a_of_type_Mwu;
    }
    finally {}
  }
  
  private void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, boolean paramBoolean3, anil paramanil, mww parammww)
  {
    paramObject = new ObserverCenter.1(this, paramanil, paramInt, parammww, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      parammww.a(paramObject, paramBoolean3);
      return;
    }
    parammww.b(paramObject, paramBoolean3);
  }
  
  private void a(Class<? extends anil> paramClass, List<anil> paramList1, List<anil> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    try
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        anil localanil = (anil)localIterator.next();
        if ((paramClass != null) && (paramClass.isAssignableFrom(localanil.getClass()))) {
          paramList2.add(localanil);
        }
      }
    }
    finally {}
  }
  
  public List<anil> a(int paramInt)
  {
    List localList = null;
    if (paramInt == 1) {
      localList = this.jdField_a_of_type_JavaUtilList;
    }
    while (paramInt != 2) {
      return localList;
    }
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<anil> a(Class<? extends anil> paramClass, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ObserverCenter", 4, "getBusinessObserver, cls[" + paramClass + "], flag[" + paramInt + "]");
    }
    if (paramClass == null) {}
    do
    {
      return null;
      if (paramInt == 1)
      {
        localArrayList = new ArrayList();
        a(paramClass, this.jdField_a_of_type_JavaUtilList, localArrayList);
        return localArrayList;
      }
    } while ((paramInt == 0) || (paramInt != 2));
    ArrayList localArrayList = new ArrayList();
    a(paramClass, this.jdField_b_of_type_JavaUtilList, localArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.i("ObserverCenter", 2, "clear");
    }
  }
  
  public void a(anil paramanil)
  {
    a(paramanil, true);
  }
  
  public void a(anil paramanil, boolean paramBoolean)
  {
    if (paramanil == null) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          if (!???.contains(paramanil)) {
            ???.add(paramanil);
          }
          return;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (Throwable paramanil) {}
      QLog.i("ObserverCenter", 4, "addObserver", paramanil);
      return;
      ??? = this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public final void a(Class<? extends anil> paramClass, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramClass, paramInt, paramBoolean, paramObject, false, false);
  }
  
  public void a(Class<? extends anil> paramClass, int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = a(paramClass, 1);
    Iterator localIterator;
    anil localanil;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localanil = (anil)localIterator.next();
          if ((paramClass != null) && (paramClass.isAssignableFrom(localanil.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localanil, this.jdField_a_of_type_Mww);
          }
        }
      }
      finally {}
    }
    localList = a(paramClass, 2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localanil = (anil)localIterator.next();
          if ((paramClass != null) && (paramClass.isAssignableFrom(localanil.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localanil, this.jdField_b_of_type_Mww);
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void b(anil paramanil)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 28	mwu:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 28	mwu:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   16: aload_1
    //   17: invokeinterface 186 2 0
    //   22: pop
    //   23: aload_2
    //   24: monitorexit
    //   25: aload_0
    //   26: getfield 26	mwu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   29: astore_2
    //   30: aload_2
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 26	mwu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   36: aload_1
    //   37: invokeinterface 186 2 0
    //   42: pop
    //   43: aload_2
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: invokestatic 116	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   55: ifeq -51 -> 4
    //   58: ldc 118
    //   60: iconst_4
    //   61: ldc 167
    //   63: aload_1
    //   64: invokestatic 170	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   67: return
    //   68: astore_1
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	mwu
    //   0	73	1	paramanil	anil
    // Exception table:
    //   from	to	target	type
    //   32	45	46	finally
    //   47	49	46	finally
    //   5	12	51	java/lang/Throwable
    //   25	32	51	java/lang/Throwable
    //   49	51	51	java/lang/Throwable
    //   71	73	51	java/lang/Throwable
    //   12	25	68	finally
    //   69	71	68	finally
  }
  
  public final void b(Class<? extends anil> paramClass, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramClass, paramInt, paramBoolean, paramObject, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwu
 * JD-Core Version:    0.7.0.1
 */