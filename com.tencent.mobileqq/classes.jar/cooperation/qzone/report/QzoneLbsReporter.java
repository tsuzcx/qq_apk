package cooperation.qzone.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QzoneLbsReporter
{
  private static final String TAG = "QzoneLbsReporter";
  
  public static void reportLocationCacheResult(boolean paramBoolean, String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (System.currentTimeMillis() % 1000L < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneLocationCacheSampleRate", 1)))
    {
      localObject = ((AppRuntime)localObject).getAccount();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_businessId", paramString);
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance((String)localObject, "QzoneNewLocationCache", paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
  
  public static void reportLocationResult(int paramInt, String paramString, long paramLong)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (System.currentTimeMillis() % 1000L < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneLocationSampleRate", 1)))
    {
      localObject = ((AppRuntime)localObject).getAccount();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", Integer.toString(paramInt));
      localHashMap.put("param_businessId", paramString);
      paramString = StatisticCollector.getInstance(MobileQQ.getContext());
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.collectPerformance((String)localObject, "QzoneNewLocation", bool, paramLong, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.QzoneLbsReporter
 * JD-Core Version:    0.7.0.1
 */