package cooperation.ilive.time;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.HashMap;

public class TimeMonitorConfig
{
  public static boolean a = false;
  public static boolean b = true;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMonitor : ");
    localStringBuilder.append(paramString);
    QLog.d("LiteMonitorTag", 1, localStringBuilder.toString());
    TimeMonitorManager.a().b(paramString);
  }
  
  public static void b()
  {
    HashMap localHashMap = c();
    if (b)
    {
      TimeMonitorManager.a().d("ilive_monitor_cool_launch").a("ilive_monitor_cool_launch", localHashMap);
      TimeMonitorManager.a().a("ilive_monitor_cool_launch");
      b = false;
      return;
    }
    TimeMonitorManager.a().d("ilive_monitor_second_launch").a("ilive_monitor_second_launch", localHashMap);
    TimeMonitorManager.a().a("ilive_monitor_second_launch");
  }
  
  public static void b(String paramString)
  {
    TimeMonitorManager.a().d(paramString).a(paramString, c());
    TimeMonitorManager.a().a(paramString);
  }
  
  private static HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu_num", String.valueOf(DeviceInfoUtil.h()));
    localHashMap.put("device_level", String.valueOf(DeviceInfoUtils.getPerfLevel()));
    localHashMap.put("contain_download", String.valueOf(a));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorConfig
 * JD-Core Version:    0.7.0.1
 */