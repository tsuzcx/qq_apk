package cooperation.ilive.time;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class TimeMonitorManager
{
  private static TimeMonitorManager jdField_a_of_type_CooperationIliveTimeTimeMonitorManager;
  private HashMap<String, TimeMonitorData> jdField_a_of_type_JavaUtilHashMap = null;
  
  public static TimeMonitorManager a()
  {
    if (jdField_a_of_type_CooperationIliveTimeTimeMonitorManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationIliveTimeTimeMonitorManager == null) {
          jdField_a_of_type_CooperationIliveTimeTimeMonitorManager = new TimeMonitorManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationIliveTimeTimeMonitorManager;
  }
  
  @NotNull
  private TimeMonitorData b(String paramString)
  {
    TimeMonitorData localTimeMonitorData2 = (TimeMonitorData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeMonitorData localTimeMonitorData1 = localTimeMonitorData2;
    if (localTimeMonitorData2 == null)
    {
      localTimeMonitorData1 = new TimeMonitorData(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeMonitorData1);
    }
    return localTimeMonitorData1;
  }
  
  public TimeMonitorData a(String paramString)
  {
    TimeMonitorData localTimeMonitorData2 = (TimeMonitorData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeMonitorData localTimeMonitorData1 = localTimeMonitorData2;
    if (localTimeMonitorData2 == null)
    {
      localTimeMonitorData1 = new TimeMonitorData(paramString);
      localTimeMonitorData1.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeMonitorData1);
    }
    return localTimeMonitorData1;
  }
  
  public void a(String paramString)
  {
    if ((TimeMonitorData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    b(paramString).a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b(String paramString)
  {
    b(paramString).a();
  }
  
  public boolean b(String paramString)
  {
    return (TimeMonitorData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorManager
 * JD-Core Version:    0.7.0.1
 */