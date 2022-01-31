import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class pdh
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<pdc> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      pdc localpdc = a(j);
      if (localpdc == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localpdc.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localpdc);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<pdc> paramSparseArray, pdi parampdi)
  {
    if (parampdi == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampdi.a((pdc)paramSparseArray.valueAt(j));
      if (parampdi.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = parampdi.a;
        i = ((pdc)paramSparseArray.valueAt(j)).a();
        parampdi.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", parampdi.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((pdc)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static pdc a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new obq();
    case 2: 
      return new pde();
    case 0: 
      return new pdj();
    case 3: 
      return new pdd();
    }
    return new pdw();
  }
  
  public static void a(SparseArray<pdc> paramSparseArray, pdi parampdi)
  {
    if (parampdi == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampdi.a((pdc)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", parampdi.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdh
 * JD-Core Version:    0.7.0.1
 */