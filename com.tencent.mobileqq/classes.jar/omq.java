import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class omq
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<oml> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      oml localoml = a(j);
      if (localoml == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localoml.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localoml);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<oml> paramSparseArray, omr paramomr)
  {
    if (paramomr == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramomr.a((oml)paramSparseArray.valueAt(j));
      if (paramomr.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = paramomr.a;
        i = ((oml)paramSparseArray.valueAt(j)).a();
        paramomr.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", paramomr.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((oml)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static oml a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new nnb();
    case 2: 
      return new omn();
    case 0: 
      return new oms();
    case 3: 
      return new omm();
    }
    return new ong();
  }
  
  public static void a(SparseArray<oml> paramSparseArray, omr paramomr)
  {
    if (paramomr == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramomr.a((oml)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", paramomr.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omq
 * JD-Core Version:    0.7.0.1
 */