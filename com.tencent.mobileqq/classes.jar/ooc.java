import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ooc
{
  private static final Map<String, ooc> jdField_a_of_type_JavaUtilMap = new HashMap();
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
  
  public static ooc a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (ooc)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private static ooc a(String paramString, boolean paramBoolean)
  {
    ooc localooc2 = a(paramString);
    ooc localooc1 = localooc2;
    if (localooc2 == null)
    {
      localooc2 = new ooc();
      localooc1 = localooc2;
      if (paramBoolean)
      {
        a(paramString, localooc2);
        localooc1 = localooc2;
      }
    }
    return localooc1;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, ooc paramooc)
  {
    if ((paramString == null) || (paramooc == null)) {
      return;
    }
    jdField_a_of_type_JavaUtilMap.put(paramString, paramooc);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      long l = SystemClock.elapsedRealtime() - this.b;
      if (l >= 0L) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      }
    }
    else
    {
      return;
    }
    actn.a("", "", new IllegalArgumentException());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.b = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ooc
 * JD-Core Version:    0.7.0.1
 */