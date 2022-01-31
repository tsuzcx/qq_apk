import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class oyf
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<oya> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      oya localoya = a(j);
      if (localoya == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localoya.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localoya);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<oya> paramSparseArray, oyg paramoyg)
  {
    if (paramoyg == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramoyg.a((oya)paramSparseArray.valueAt(j));
      if (paramoyg.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = paramoyg.a;
        i = ((oya)paramSparseArray.valueAt(j)).a();
        paramoyg.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", paramoyg.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((oya)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static oya a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new nym();
    case 2: 
      return new oyc();
    case 0: 
      return new oyh();
    case 3: 
      return new oyb();
    }
    return new oyv();
  }
  
  public static void a(SparseArray<oya> paramSparseArray, oyg paramoyg)
  {
    if (paramoyg == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramoyg.a((oya)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", paramoyg.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyf
 * JD-Core Version:    0.7.0.1
 */