import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class osk
{
  private static final Map<String, osk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_a_of_type_Long = -1L;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long b = -1L;
  
  public static long a(String paramString)
  {
    return a(paramString, false).a();
  }
  
  public static long a(String paramString, boolean paramBoolean)
  {
    return a(paramString, false).a(paramBoolean);
  }
  
  public static osk a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (osk)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private static osk a(String paramString, boolean paramBoolean)
  {
    osk localosk2 = a(paramString);
    osk localosk1 = localosk2;
    if (localosk2 == null)
    {
      localosk2 = new osk();
      localosk1 = localosk2;
      if (paramBoolean)
      {
        a(paramString, localosk2);
        localosk1 = localosk2;
      }
    }
    return localosk1;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, osk paramosk)
  {
    if ((paramString == null) || (paramosk == null)) {
      return;
    }
    jdField_a_of_type_JavaUtilMap.put(paramString, paramosk);
  }
  
  public static long b(String paramString)
  {
    return a(paramString, false).b();
  }
  
  public static void b(String paramString)
  {
    a(paramString, true).a();
  }
  
  public static void c(String paramString)
  {
    a(paramString, false).b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 = ((Long)((Iterator)localObject).next()).longValue() + l1) {}
    long l2 = l1;
    if (this.jdField_a_of_type_Boolean)
    {
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 + (SystemClock.elapsedRealtime() - this.b);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startMillis : " + this.jdField_a_of_type_Long + "  during : " + l2 + "  :  ");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ((StringBuilder)localObject).append(localLong + "  : ");
      }
      QLog.d("TimeSliceHelper", 1, ((StringBuilder)localObject).toString());
    }
    return l2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = SystemClock.elapsedRealtime();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return a(true);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	osk:jdField_a_of_type_Boolean	Z
    //   6: ifeq +37 -> 43
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 96	osk:jdField_a_of_type_Boolean	Z
    //   14: invokestatic 101	android/os/SystemClock:elapsedRealtime	()J
    //   17: aload_0
    //   18: getfield 34	osk:b	J
    //   21: lsub
    //   22: lstore_1
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: iflt +20 -> 46
    //   29: aload_0
    //   30: getfield 32	osk:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: lload_1
    //   34: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   37: invokeinterface 150 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: ldc 152
    //   48: ldc 152
    //   50: new 154	java/lang/IllegalArgumentException
    //   53: dup
    //   54: invokespecial 155	java/lang/IllegalArgumentException:<init>	()V
    //   57: invokestatic 160	aepi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   60: goto -17 -> 43
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	osk
    //   22	12	1	l	long
    //   63	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	63	finally
    //   29	43	63	finally
    //   46	60	63	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.b = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     osk
 * JD-Core Version:    0.7.0.1
 */