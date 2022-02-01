import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class qda
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<qcu> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      qcu localqcu = a(j);
      if (localqcu == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localqcu.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localqcu);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<qcu> paramSparseArray, qdb paramqdb)
  {
    if (paramqdb == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramqdb.a((qcu)paramSparseArray.valueAt(j));
      if (paramqdb.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = paramqdb.a;
        i = ((qcu)paramSparseArray.valueAt(j)).a();
        paramqdb.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", paramqdb.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((qcu)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static qcu a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ugx();
    case 2: 
      return new qcw();
    case 0: 
      return new qdc();
    case 3: 
      return new qcv();
    }
    return new qdi();
  }
  
  public static void a(SparseArray<qcu> paramSparseArray, qdb paramqdb)
  {
    if (paramqdb == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramqdb.a((qcu)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", paramqdb.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qda
 * JD-Core Version:    0.7.0.1
 */