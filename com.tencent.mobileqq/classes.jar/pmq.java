import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class pmq
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<pmk> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      pmk localpmk = a(j);
      if (localpmk == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localpmk.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localpmk);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<pmk> paramSparseArray, pmr parampmr)
  {
    if (parampmr == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampmr.a((pmk)paramSparseArray.valueAt(j));
      if (parampmr.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = parampmr.a;
        i = ((pmk)paramSparseArray.valueAt(j)).a();
        parampmr.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", parampmr.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((pmk)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static pmk a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new tmr();
    case 2: 
      return new pmm();
    case 0: 
      return new pms();
    case 3: 
      return new pml();
    }
    return new pnf();
  }
  
  public static void a(SparseArray<pmk> paramSparseArray, pmr parampmr)
  {
    if (parampmr == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampmr.a((pmk)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", parampmr.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmq
 * JD-Core Version:    0.7.0.1
 */