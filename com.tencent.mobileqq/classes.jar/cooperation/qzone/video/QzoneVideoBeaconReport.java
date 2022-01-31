package cooperation.qzone.video;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QzoneVideoBeaconReport
{
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, new HashMap(), null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, paramLong, 0L, new HashMap(), null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " duration:" + paramLong);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      localHashMap.put("refer", str);
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString3);
    localHashMap.put("reserve", paramString4);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " resultCode:" + paramString3 + " reserve:" + paramString4);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString3, paramString4);
    localHashMap.put("reserve", paramString5);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " key:" + paramString3 + " value:" + paramString4 + ", reserve:" + paramString5);
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramHashMap);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      localHashMap.put("event_result", str);
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      paramString3 = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramString3 = "0";
      }
      localHashMap.put("refer", str);
      localHashMap.put("type", paramString3);
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str + "type =" + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoBeaconReport
 * JD-Core Version:    0.7.0.1
 */