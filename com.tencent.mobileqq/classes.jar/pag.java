import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class pag
{
  private static final Map<String, pag> jdField_a_of_type_JavaUtilMap = new HashMap();
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
  
  public static pag a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (pag)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private static pag a(String paramString, boolean paramBoolean)
  {
    pag localpag2 = a(paramString);
    pag localpag1 = localpag2;
    if (localpag2 == null)
    {
      localpag2 = new pag();
      localpag1 = localpag2;
      if (paramBoolean)
      {
        a(paramString, localpag2);
        localpag1 = localpag2;
      }
    }
    return localpag1;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, pag parampag)
  {
    if ((paramString == null) || (parampag == null)) {
      return;
    }
    jdField_a_of_type_JavaUtilMap.put(paramString, parampag);
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
    Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    Object localObject2 = ((List)localObject1).iterator();
    for (long l1 = 0L; ((Iterator)localObject2).hasNext(); l1 = ((Long)((Iterator)localObject2).next()).longValue() + l1) {}
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
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startMillis : ").append(this.jdField_a_of_type_Long).append("  during : ").append(l2).append("  :  ");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append((Long)((Iterator)localObject1).next()).append("  : ");
      }
      QLog.d("TimeSliceHelper", 2, ((StringBuilder)localObject2).toString());
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
    //   3: getfield 99	pag:jdField_a_of_type_Boolean	Z
    //   6: ifeq +37 -> 43
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 99	pag:jdField_a_of_type_Boolean	Z
    //   14: invokestatic 104	android/os/SystemClock:elapsedRealtime	()J
    //   17: aload_0
    //   18: getfield 34	pag:b	J
    //   21: lsub
    //   22: lstore_1
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: iflt +20 -> 46
    //   29: aload_0
    //   30: getfield 32	pag:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: lload_1
    //   34: invokestatic 149	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   37: invokeinterface 153 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: ldc 155
    //   48: ldc 155
    //   50: new 157	java/lang/IllegalArgumentException
    //   53: dup
    //   54: invokespecial 158	java/lang/IllegalArgumentException:<init>	()V
    //   57: invokestatic 163	agej:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   60: goto -17 -> 43
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	pag
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pag
 * JD-Core Version:    0.7.0.1
 */