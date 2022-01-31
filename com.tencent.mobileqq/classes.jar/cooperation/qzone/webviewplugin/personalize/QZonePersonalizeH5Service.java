package cooperation.qzone.webviewplugin.personalize;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.MapUtil;
import java.util.Map;

public class QZonePersonalizeH5Service
{
  private static Map a(long paramLong)
  {
    Map localMap = MapUtil.a(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static Map a(Long paramLong)
  {
    return a(paramLong.longValue());
  }
  
  public static void a(Integer paramInteger, Long paramLong)
  {
    Map localMap = a(paramLong);
    localMap.put(paramInteger, Long.valueOf(System.currentTimeMillis() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + paramInteger + "timestamp: " + System.currentTimeMillis() / 1000L);
    }
    a(localMap, paramLong);
  }
  
  public static void a(Map paramMap, Long paramLong)
  {
    LocalMultiProcConfig.putString("CTIME_MAP" + paramLong, MapUtil.a(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service
 * JD-Core Version:    0.7.0.1
 */