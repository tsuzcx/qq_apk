package cooperation.ilive.time;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.HashMap;

public class TimeMonitorConfig
{
  public static boolean a = false;
  public static boolean b = true;
  
  private static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu_num", String.valueOf(DeviceInfoUtil.b()));
    localHashMap.put("device_level", String.valueOf(DeviceInfoUtils.a()));
    localHashMap.put("contain_download", String.valueOf(a));
    return localHashMap;
  }
  
  public static void a()
  {
    if (b)
    {
      TimeMonitorManager.a().b("ilive_monitor_cool_launch");
      return;
    }
    TimeMonitorManager.a().b("ilive_monitor_second_launch");
  }
  
  public static void a(String paramString)
  {
    TimeMonitorManager.a().b(paramString);
  }
  
  public static void b()
  {
    HashMap localHashMap = a();
    if (b)
    {
      TimeMonitorManager.a().a("ilive_monitor_cool_launch").a("ilive_monitor_cool_launch", localHashMap);
      TimeMonitorManager.a().a("ilive_monitor_cool_launch");
      b = false;
      return;
    }
    TimeMonitorManager.a().a("ilive_monitor_second_launch").a("ilive_monitor_second_launch", localHashMap);
    TimeMonitorManager.a().a("ilive_monitor_second_launch");
  }
  
  public static void b(String paramString)
  {
    TimeMonitorManager.a().a(paramString).a(paramString, a());
    TimeMonitorManager.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorConfig
 * JD-Core Version:    0.7.0.1
 */