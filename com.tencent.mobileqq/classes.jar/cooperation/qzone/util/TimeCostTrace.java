package cooperation.qzone.util;

import android.os.Debug;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class TimeCostTrace
{
  public static HashMap a;
  public int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  
  private TimeCostTrace(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static TimeCostTrace a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    TimeCostTrace localTimeCostTrace2 = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeCostTrace localTimeCostTrace1 = localTimeCostTrace2;
    if (localTimeCostTrace2 == null)
    {
      localTimeCostTrace1 = new TimeCostTrace(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeCostTrace1);
    }
    return localTimeCostTrace1;
  }
  
  private static long b()
  {
    return System.currentTimeMillis();
  }
  
  public long a()
  {
    long l1;
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_Int < 0)) {
      l1 = -1L;
    }
    long l2;
    do
    {
      return l1;
      l2 = b() - this.jdField_a_of_type_Long;
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getTimeCost:" + l2);
    return l2;
  }
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_Int < 0)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "TimeCostTrace getStepCost sceneId<0");
      return -1L;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "TimeCostTrace getStepCost code 是空字符串");
      return -1L;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, new Object[] { paramString, "没有被监控" });
      return -1L;
    }
    paramString = (long[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.length > 1)) {
      return paramString[1] - paramString[0];
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "TimeCostTrace getStepCost arr不合法");
    return -1L;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long[] arrayOfLong = (long[])this.jdField_a_of_type_JavaUtilMap.get(str);
      if (arrayOfLong != null)
      {
        ((StringBuilder)localObject).append(str).append(":");
        if (arrayOfLong.length > 0)
        {
          ((StringBuilder)localObject).append(arrayOfLong[0] - this.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append(",");
        }
        if (arrayOfLong.length > 1) {
          ((StringBuilder)localObject).append(arrayOfLong[1] - this.jdField_a_of_type_Long);
        }
        ((StringBuilder)localObject).append(";");
      }
    }
    localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "dump step cost detail:" + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    a(b(), 0, false);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "TimeCostTrace--markFirst");
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, -1L);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Int < 0) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      long l = paramLong;
      if (paramLong <= 0L) {
        l = b();
      }
      long[] arrayOfLong2 = (long[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[0] = l;
      arrayOfLong1[2] = Thread.currentThread().getId();
      arrayOfLong1[3] = Debug.threadCpuTimeNanos();
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, paramString + " start");
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {
      return "";
    }
    localJSONObject = new JSONObject();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    try
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long[] arrayOfLong = (long[])localHashMap.get(str);
        if ((arrayOfLong != null) && (arrayOfLong.length > 1)) {
          localJSONObject.put(str, arrayOfLong[1] - arrayOfLong[0]);
        }
      }
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      QZLog.d("qzone_launch", 4, "", localException);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Int < 0) {}
    long l2;
    long l3;
    long l1;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      l2 = b();
      long[] arrayOfLong2 = (long[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[1] = l2;
      arrayOfLong1[4] = Debug.threadCpuTimeNanos();
      l3 = Thread.currentThread().getId();
      l1 = -1L;
      if (l3 == arrayOfLong1[2]) {
        l1 = arrayOfLong1[4] - arrayOfLong1[3];
      }
      l3 = arrayOfLong1[0];
    } while ((!QLog.isColorLevel()) || (l3 <= 0L));
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, paramString + " stop, cpuTime(ns):" + l1 + " ,cost:" + (l2 - l3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.TimeCostTrace
 * JD-Core Version:    0.7.0.1
 */