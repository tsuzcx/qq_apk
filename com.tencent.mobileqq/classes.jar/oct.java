import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager.1;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager.2;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qapmsdk.common.util.Objects;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class oct
{
  private static Map<String, oct> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  private Map<String, Vector<Long>> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, Long> c = new ConcurrentHashMap();
  
  private oct(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = ozs.a().getApplication();
    a();
  }
  
  private Vector<Long> a(String paramString, long paramLong)
  {
    int i = 0;
    paramString = bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_key_" + paramString);
    if (bhsr.a(paramString)) {
      paramString = new Vector(0);
    }
    String[] arrayOfString;
    Vector localVector;
    long l;
    int j;
    do
    {
      return paramString;
      arrayOfString = paramString.split(",,");
      localVector = new Vector(arrayOfString.length);
      l = System.currentTimeMillis();
      j = arrayOfString.length;
      paramString = localVector;
    } while (i >= j);
    paramString = arrayOfString[i];
    if (l - Long.parseLong(paramString) > 1000L * paramLong) {}
    for (;;)
    {
      i += 1;
      break;
      localVector.add(Long.valueOf(Long.parseLong(paramString)));
    }
  }
  
  public static oct a()
  {
    String str = ozs.a().getAccount();
    if (jdField_a_of_type_JavaUtilMap.get(str) == null) {}
    try
    {
      if (jdField_a_of_type_JavaUtilMap.get(str) == null) {
        jdField_a_of_type_JavaUtilMap.put(str, new oct(str));
      }
      return (oct)jdField_a_of_type_JavaUtilMap.get(str);
    }
    finally {}
  }
  
  private void a()
  {
    try
    {
      this.c = b();
      if (this.c.isEmpty()) {
        return;
      }
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.put(localEntry.getKey(), a((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue()));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SoftAdExpoStatManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    ThreadManagerV2.excute(new SoftAdExpoStatManager.3(this, paramRunnable), 64, null, true);
  }
  
  private Map<String, Long> b()
  {
    Object localObject = bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_key_timewindow");
    if (bhsr.a((String)localObject)) {
      localObject = new ConcurrentHashMap(0);
    }
    String[] arrayOfString;
    ConcurrentHashMap localConcurrentHashMap;
    int j;
    int i;
    do
    {
      return localObject;
      arrayOfString = ((String)localObject).split(",,");
      if (arrayOfString.length == 0) {
        return new ConcurrentHashMap(0);
      }
      localConcurrentHashMap = new ConcurrentHashMap(arrayOfString.length);
      j = arrayOfString.length;
      i = 0;
      localObject = localConcurrentHashMap;
    } while (i >= j);
    localObject = arrayOfString[i];
    if (bhsr.a((String)localObject)) {}
    for (;;)
    {
      i += 1;
      break;
      localObject = ((String)localObject).split("&&");
      if (localObject.length == 2) {
        localConcurrentHashMap.put(localObject[0], Long.valueOf(Long.parseLong(localObject[1])));
      }
    }
  }
  
  private void b()
  {
    if (this.c.size() == 0) {
      return;
    }
    a(new SoftAdExpoStatManager.1(this, new ConcurrentHashMap(this.c)));
  }
  
  private void b(String paramString)
  {
    Vector localVector = (Vector)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((localVector == null) || (localVector.size() == 0)) {
      return;
    }
    a(new SoftAdExpoStatManager.2(this, new Vector(localVector), paramString));
  }
  
  private void c()
  {
    String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!Objects.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_soft_fstreq", str);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Map<String, Long> a()
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {
      return localConcurrentHashMap;
    }
    long l1 = System.currentTimeMillis();
    try
    {
      Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        long l2 = ((Long)this.c.get(localEntry.getKey())).longValue();
        Vector localVector = (Vector)localEntry.getValue();
        Iterator localIterator2 = localVector.iterator();
        for (int i = 0; (localIterator2.hasNext()) && (l1 - ((Long)localIterator2.next()).longValue() > 1000L * l2); i = 1) {
          localIterator2.remove();
        }
        if (i != 0) {
          b((String)localEntry.getKey());
        }
        localConcurrentHashMap.put(localEntry.getKey(), Long.valueOf(localVector.size()));
      }
      return localConcurrentHashMap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
        {
          ((Vector)this.jdField_b_of_type_JavaUtilMap.get(paramString)).add(Long.valueOf(System.currentTimeMillis()));
          b(paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      return;
    }
    try
    {
      if (!this.c.containsKey(paramString)) {
        this.jdField_b_of_type_JavaUtilMap.put(paramString, new Vector(0));
      }
      this.c.put(paramString, Long.valueOf(paramLong));
      b();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_soft_fstreq");
    }
    String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    if (!Objects.equals(this.jdField_b_of_type_JavaLangString, str)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((bool) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 1)) {
        c();
      }
      return bool;
    }
  }
  
  public int b()
  {
    int i = -1;
    if (this.jdField_a_of_type_Int != -1) {
      i = this.jdField_a_of_type_Int;
    }
    String str;
    do
    {
      return i;
      str = bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_last_req_vd_cnt");
    } while (TextUtils.isEmpty(str));
    i = Integer.parseInt(str);
    this.jdField_a_of_type_Int = i;
    return i;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    bhjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString + "expo_stat_last_req_vd_cnt", String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oct
 * JD-Core Version:    0.7.0.1
 */