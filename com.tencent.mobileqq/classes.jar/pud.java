import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class pud
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<ptx> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      ptx localptx = a(j);
      if (localptx == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localptx.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localptx);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<ptx> paramSparseArray, pue parampue)
  {
    if (parampue == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampue.a((ptx)paramSparseArray.valueAt(j));
      if (parampue.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = parampue.a;
        i = ((ptx)paramSparseArray.valueAt(j)).a();
        parampue.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", parampue.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((ptx)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static ptx a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ong();
    case 2: 
      return new ptz();
    case 0: 
      return new puf();
    case 3: 
      return new pty();
    }
    return new pus();
  }
  
  public static void a(SparseArray<ptx> paramSparseArray, pue parampue)
  {
    if (parampue == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampue.a((ptx)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", parampue.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pud
 * JD-Core Version:    0.7.0.1
 */