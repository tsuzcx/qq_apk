import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class oyc
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<oxx> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      oxx localoxx = a(j);
      if (localoxx == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localoxx.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localoxx);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<oxx> paramSparseArray, oyd paramoyd)
  {
    if (paramoyd == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramoyd.a((oxx)paramSparseArray.valueAt(j));
      if (paramoyd.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = paramoyd.a;
        i = ((oxx)paramSparseArray.valueAt(j)).a();
        paramoyd.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", paramoyd.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((oxx)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static oxx a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new nyj();
    case 2: 
      return new oxz();
    case 0: 
      return new oye();
    case 3: 
      return new oxy();
    }
    return new oys();
  }
  
  public static void a(SparseArray<oxx> paramSparseArray, oyd paramoyd)
  {
    if (paramoyd == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramoyd.a((oxx)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", paramoyd.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyc
 * JD-Core Version:    0.7.0.1
 */