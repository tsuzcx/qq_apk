package cooperation.ilive.time;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TimeMonitorData
{
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public TimeMonitorData(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init TimeMonitor id：");
      localStringBuilder.append(paramString);
      QLog.i("LiteMonitorTag", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b(HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {}
    try
    {
      localObject = new HashMap();
      if (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
        QLog.e("LiteMonitorTag", 1, "mTimeTag is empty");
      }
      paramHashMap = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramHashMap.hasNext())
      {
        String str = (String)paramHashMap.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(" 执行耗时：");
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
          localStringBuilder.append(" params = ");
          localStringBuilder.append(((HashMap)localObject).toString());
          QLog.e("LiteMonitorTag", 1, localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDataToQLogcat msg = ");
      ((StringBuilder)localObject).append(paramHashMap.getMessage());
      QLog.e("LiteMonitorTag", 1, ((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, String.valueOf(l));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tickTimeTag tag = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" time = ");
      localStringBuilder.append(l);
      QLog.i("LiteMonitorTag", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    b(paramHashMap);
    ThreadManagerV2.postImmediately(new TimeMonitorData.2(this, paramHashMap, paramString, paramLong), null, false);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, String.valueOf(l));
    a(paramString, l, paramHashMap);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      paramHashMap.put("frame_time", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    b(paramHashMap);
    ThreadManagerV2.postImmediately(new TimeMonitorData.1(this, paramHashMap), null, false);
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorData
 * JD-Core Version:    0.7.0.1
 */