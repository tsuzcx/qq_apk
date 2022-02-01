import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class psd
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<prx> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      prx localprx = a(j);
      if (localprx == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localprx.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localprx);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<prx> paramSparseArray, pse parampse)
  {
    if (parampse == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampse.a((prx)paramSparseArray.valueAt(j));
      if (parampse.a == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = parampse.a;
        i = ((prx)paramSparseArray.valueAt(j)).a();
        parampse.a = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", parampse.a(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((prx)paramSparseArray.valueAt(j)).a());
      return localObject;
    }
  }
  
  public static prx a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new tsm();
    case 2: 
      return new prz();
    case 0: 
      return new psf();
    case 3: 
      return new pry();
    }
    return new psl();
  }
  
  public static void a(SparseArray<prx> paramSparseArray, pse parampse)
  {
    if (parampse == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampse.a((prx)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", parampse.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psd
 * JD-Core Version:    0.7.0.1
 */