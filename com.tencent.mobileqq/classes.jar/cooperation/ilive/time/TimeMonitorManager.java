package cooperation.ilive.time;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class TimeMonitorManager
{
  private static TimeMonitorManager a;
  private HashMap<String, TimeMonitorData> b = null;
  
  public static TimeMonitorManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TimeMonitorManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  @NotNull
  private TimeMonitorData f(String paramString)
  {
    TimeMonitorData localTimeMonitorData2 = (TimeMonitorData)this.b.get(paramString);
    TimeMonitorData localTimeMonitorData1 = localTimeMonitorData2;
    if (localTimeMonitorData2 == null)
    {
      localTimeMonitorData1 = new TimeMonitorData(paramString);
      this.b.put(paramString, localTimeMonitorData1);
    }
    return localTimeMonitorData1;
  }
  
  public void a(String paramString)
  {
    if ((TimeMonitorData)this.b.get(paramString) != null) {
      this.b.remove(paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    f(paramString).a(paramLong);
  }
  
  public void b(String paramString)
  {
    f(paramString).a();
  }
  
  public boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public TimeMonitorData d(String paramString)
  {
    TimeMonitorData localTimeMonitorData2 = (TimeMonitorData)this.b.get(paramString);
    TimeMonitorData localTimeMonitorData1 = localTimeMonitorData2;
    if (localTimeMonitorData2 == null)
    {
      localTimeMonitorData1 = new TimeMonitorData(paramString);
      localTimeMonitorData1.a();
      this.b.put(paramString, localTimeMonitorData1);
    }
    return localTimeMonitorData1;
  }
  
  public boolean e(String paramString)
  {
    return (TimeMonitorData)this.b.get(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorManager
 * JD-Core Version:    0.7.0.1
 */